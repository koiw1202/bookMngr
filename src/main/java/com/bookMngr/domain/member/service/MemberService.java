package com.bookMngr.domain.member.service;

import com.bookMngr.common.dao.user.SelectUserOutDao;
import com.bookMngr.common.error.ErrorCode;
import com.bookMngr.common.error.ErrorHandler;
import com.bookMngr.common.mybatis.mapper.UserMapper;
import com.bookMngr.common.restTemplate.HttpProtocol;
import com.bookMngr.common.restTemplate.RestTemplateUtil;
import com.bookMngr.domain.member.domain.Member;
import com.bookMngr.domain.member.model.ChngMemberInfoForSerDto;
import com.bookMngr.domain.member.model.MemberLoginForServiceDto;
import com.bookMngr.domain.member.model.res.MemberForResDto;
import com.bookMngr.domain.member.model.res.MemberForServiceDto;
import com.bookMngr.domain.member.repository.MemberNativeRepository;
import com.bookMngr.domain.member.repository.MemberRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
//@Transactional(rollbackFor = {ErrorHandler.class, Exception.class}, propagation = Propagation.REQUIRED)
public class MemberService {

    private final MemberRepository memberRepository ;
    private final RestTemplateUtil restTemplateUtil ;
    private final UserMapper userMapper ;
    private final MemberNativeRepository memberNativeRepository ;

    public MemberForResDto joinMember(final MemberForServiceDto memberForServiceDto) {

        Member existMember = memberRepository.checkMemberIdExist(memberForServiceDto.getMemberId()) ;

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

    public boolean chngMemberInfo(final ChngMemberInfoForSerDto chngMemberInfoForSerDto) {

        Long result = memberRepository.updateMember(chngMemberInfoForSerDto) ;

        if(result == 0 || result >= 2)
            throw new ErrorHandler(ErrorCode.MEMBER_ERROR_001) ;
        else
            return true ;

    }

    public Map<String, Object> doSignIn(MemberLoginForServiceDto memberLoginForServiceDto) {

        Member member = memberRepository.login(memberLoginForServiceDto.getMemberId(), memberLoginForServiceDto.getPassword()) ;

        Optional.ofNullable(member).orElseThrow(() -> new UsernameNotFoundException("미존재 회원")) ;

        HttpEntity httpEntity = HttpProtocol.builder()
                .body(new HashMap<String, Object>() {{
                    put("memberGrade", member.getMemberGrade()) ;
                    put("memberGrant", member.getMemberGrant()) ;
                }})
                .headers(null)
                .build() ;

        ResponseEntity responseEntity = restTemplateUtil.httpCommunication("http://localhost:8080/v1.0.0/auth/token", POST, httpEntity) ;
        log.info("responseVO : {}", responseEntity.getHeaders()) ;

        return null ;
    }

    @Transactional(readOnly = true)
    public List<SelectUserOutDao> getUserInfoByMyBatis() {
        return userMapper.selectUser() ;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class} )
    public Integer joinUserInfoByMyBatis() throws Exception {

        LocalDateTime.now().getNano();

        Member member = Member.builder()
                .memberForServiceDto(MemberForServiceDto.builder().memberId("TEST" + String.valueOf(LocalDateTime.now().getNano()))
                        .password("12345")
                        .phoneNumber("0000000")
                        .nickNm("123")
                        .rstYn("Y")
                        .unregYn("Y")
                        .unregYn("N")
                        .build()
                ).build() ;

        memberNativeRepository.insertTestFunc() ;

        if(1==1)
            throw new RuntimeException() ;

        return userMapper.joinUserInfoByMyBatis(member);

    }
}
