package com.bookMngr.member.controller;

import com.bookMngr.common.CCConst;
import com.bookMngr.member.model.MemberDto;
import com.bookMngr.member.model.MemberDtoForService;
import com.bookMngr.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : com.bookMngr.member.controller
 * fileName       : UserController
 * author         : FIC08709
 * date           : 2023-11-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-22        FIC08709       최초 생성
 */
@RestController
@AllArgsConstructor
public class MemberController {

    private final MemberService memberService ;


    @PostMapping(name = "/v1.0.0/member")
    public void joinMember(MemberDto memberDto) {
        memberService.joinMember(
            MemberDtoForService.builder()
                    .memberId(memberDto.getMemberId())
                    .nickNm(memberDto.getNickNm())
                    .rstYn(CCConst.N)
                    .unregYn(CCConst.N).build()
        );

    }


}
