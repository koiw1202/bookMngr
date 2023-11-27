package com.bookMngr.domain.member.service;

import com.bookMngr.common.error.ErrorCode;
import com.bookMngr.common.error.ErrorHandler;
import com.bookMngr.common.restTemplate.HttpProtocol;
import com.bookMngr.common.restTemplate.ResponseVO;
import com.bookMngr.common.restTemplate.RestTemplateUtil;
import com.bookMngr.domain.member.domain.Member;
import com.bookMngr.domain.member.model.ChngMemberInfoForSerDto;
import com.bookMngr.domain.member.model.MemberLoginForServiceDto;
import com.bookMngr.domain.member.model.res.MemberForResDto;
import com.bookMngr.domain.member.model.res.MemberForServiceDto;
import com.bookMngr.domain.member.repository.MemberQueryRepository;
import com.bookMngr.domain.member.repository.MemberRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Optional;

import static com.bookMngr.common.error.ErrorCode.EXIST_ID;
import static com.bookMngr.domain.member.domain.QMember.member;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.util.StringUtils.hasText;

/**
 * description    : 회원등록, 수정, 삭제, 조회와 관련된 비즈니스를 수행하는 클레스입니다.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-22        FIC08709       최초 생성
 */
@Service
@AllArgsConstructor
@Slf4j
public class MemberService {

    private final JPAQueryFactory jpaQueryFactory ;
    private final MemberRepository memberRepository ;
    private final MemberQueryRepository memberQueryRepository ;
    private final RestTemplateUtil restTemplateUtil ;

    private BooleanExpression memberIdEq(final String memberId) {
        return hasText(memberId) ? member.memberCd.eq(Long.valueOf(memberId)) : null ;
//        return hasText(memberId) ? member.memberPK.memberId.eq(memberId) : null ;
    }

    @Transactional(rollbackFor = {ErrorHandler.class, Exception.class}, propagation = Propagation.REQUIRED)
    public MemberForResDto joinMember(final MemberForServiceDto memberForServiceDto) {

        Member existMember = memberQueryRepository.checkMemberIdExist(memberForServiceDto.getMemberId()) ;

//      중복된 계정이 있다면 예외처리
        Optional.ofNullable(existMember)
                .ifPresent(vo -> {
                    throw new ErrorHandler(EXIST_ID) ;
                }) ;

//      회원가입 처리
        Member joinMemberEntity = memberRepository.save(
                Member.builder()
                      .memberForServiceDto(memberForServiceDto)
                      .build()
        ) ;

        return MemberForResDto.builder()
                .regerDt(joinMemberEntity.getRegerDt())
                .nickNm(joinMemberEntity.getNickNm())
                .build() ;

    } //End of joinMember

    @Transactional(rollbackFor = {ErrorHandler.class, Exception.class}, propagation = Propagation.REQUIRED)
    public boolean chngMemberInfo(final ChngMemberInfoForSerDto chngMemberInfoForSerDto) {

        Long result = memberQueryRepository.updateMember(chngMemberInfoForSerDto) ;

        if(result == 0 || result >= 2)
            throw new ErrorHandler(ErrorCode.MEMBER_ERROR_001) ;
        else
            return true ;

    }

    public HttpEntity doSignIn(MemberLoginForServiceDto memberLoginForServiceDto) {

        Member member = memberQueryRepository.login(memberLoginForServiceDto.getMemberId(), memberLoginForServiceDto.getPassword()) ;

        HttpEntity httpEntity = HttpProtocol.builder()
                .body(new HashMap<String, Object>() {{
                    put("memberGrade", member.getMemberGrade()) ;
                    put("memberaGrant", member.getMemberGrant()) ;
                    put("memberCd", String.valueOf(member.getMemberCd())) ;
//                    put("memberCd", String.valueOf(member.getMemberPK().getMemberCd())) ;
                }})
                .headers(null)
                .build() ;

        ResponseVO responseVO = restTemplateUtil.httpCommunication("http://localhost:8080/v1.0.0/auth/token", POST, httpEntity) ;
        log.info("responseVO : {}", responseVO) ;

        return null ;

    }

}













