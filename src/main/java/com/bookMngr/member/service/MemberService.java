package com.bookMngr.member.service;

import com.bookMngr.common.constant.CCConst;
import com.bookMngr.common.error.ErrorCode;
import com.bookMngr.common.error.ErrorHandler;
import com.bookMngr.member.domain.Member;
import com.bookMngr.member.model.MemberDto;
import com.bookMngr.member.model.MemberForResDto;
import com.bookMngr.member.model.MemberForServiceDto;
import com.bookMngr.member.model.MemberLoginDto;
import com.bookMngr.member.repository.MemberRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Optional;

import static com.bookMngr.common.error.ErrorCode.EXIST_ID;
import static com.bookMngr.member.domain.QMember.member;
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

    private BooleanExpression memberIdEq(final String memberId) {
        return hasText(memberId) ? member.memberId.eq(memberId) : null ;
    }

    public MemberForResDto joinMember(final MemberForServiceDto memberForServiceDto) {

        Member existMember = jpaQueryFactory.selectFrom(member)
                .where(memberIdEq(memberForServiceDto.getMemberId()))
                .fetchOne() ;

//      중복된 계정이 있다면 예외처리
        Optional.ofNullable(existMember)
                .orElseThrow(() -> new ErrorHandler(EXIST_ID)) ;

//      회원가입 처리
        Member joinMemberEntity = memberRepository.save(
            Member.builder()
                    .memberId(memberForServiceDto.getMemberId())
                    .password(memberForServiceDto.getPassword())
                    .nickNm(memberForServiceDto.getNickNm())
                    .unregYn(CCConst.N)
                    .rstYn(CCConst.N)
                    .regerDt(new Timestamp(System.currentTimeMillis()))
                    .build()) ;

        return MemberForResDto.builder()
                .regerDt(joinMemberEntity.getRegerDt())
                .nickNm(joinMemberEntity.getNickNm())
                .build() ;

    } //End of joinMember

    @Transactional
    public boolean chngMemberInfo(final MemberLoginDto memberLoginDto) {

        Long result = jpaQueryFactory.update(member)
                                     .where(memberIdEq(memberLoginDto.getMemberId()))
                                     .execute() ;

        if(result == 0 || result >= 2)
            throw new ErrorHandler(ErrorCode.MEMBER_ERROR_001) ;
        else
            return true ;

    }

}













