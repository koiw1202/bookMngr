package com.bookMngr.member.controller;

import com.bookMngr.common.constant.CCConst;
import com.bookMngr.member.model.MemberDto;
import com.bookMngr.member.model.MemberForServiceDto;
import com.bookMngr.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

    @Operation(summary = "회원가입" , description = "회원가입 API")
    @PostMapping(name = "/v1.0.0/member")
    public void joinMember(@Valid @RequestBody final MemberDto memberDto) {
        memberService.joinMember(
            new MemberForServiceDto().builder()
                    .memberId(memberDto.getMemberId())
                    .password(memberDto.getPassword())
                    .nickNm(memberDto.getNickNm())
                    .rstYn(CCConst.N)
                    .unregYn(CCConst.N)
                    .build()
        ) ;

    }


}
