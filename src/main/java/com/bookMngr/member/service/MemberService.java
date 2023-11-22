package com.bookMngr.member.service;

import com.bookMngr.common.CCConst;
import com.bookMngr.member.domain.Member;
import com.bookMngr.member.model.MemberDto;
import com.bookMngr.member.model.MemberDtoForService;
import com.bookMngr.member.repository.MemberRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * packageName    : com.bookMngr.user.service
 * fileName       : UserService
 * author         : FIC08709
 * date           : 2023-11-22
 * description    :
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


    public void joinMember(MemberDtoForService memberDtoForService) {

        Member member = memberRepository.save(
            Member.builder()
                    .memberId(memberDtoForService.getMemberId())
                    .nickNm(memberDtoForService.getNickNm())
                    .unregYn(CCConst.N)
                    .rstYn(CCConst.N)
                    .regerDt(new Timestamp(System.currentTimeMillis()))
                    .build()
        ) ;

        log.info("save result --> {}", member ) ;

    }

}














