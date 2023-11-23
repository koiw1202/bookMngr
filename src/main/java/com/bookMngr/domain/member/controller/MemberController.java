package com.bookMngr.domain.member.controller;

import com.bookMngr.common.constant.CCConst;
import com.bookMngr.common.response.ApiResponse;
import com.bookMngr.domain.member.model.MemberDto;
import com.bookMngr.domain.member.model.MemberForServiceDto;
import com.bookMngr.domain.member.model.MemberForResDto;
import com.bookMngr.domain.member.model.MemberLoginDto;
import com.bookMngr.domain.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.bookMngr.common.constant.CCConst.MEMBER_JOIN_SUCCESS;
import static com.bookMngr.common.error.ErrorCode.MEMBER_ERROR_002;

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
    public HttpEntity joinMember(@Valid @RequestBody final MemberDto memberDto) {

        MemberForResDto memberForResDto = memberService.joinMember(
            new MemberForServiceDto()
                    .builder()
                    .memberId(memberDto.getMemberId())
                    .password(memberDto.getPassword())
                    .nickNm(memberDto.getNickNm())
                    .rstYn(CCConst.N)
                    .unregYn(CCConst.N)
                    .build()
        ) ;

        return ApiResponse.ok(MEMBER_JOIN_SUCCESS, memberForResDto) ;
    }

    @Operation(summary = "회원정보 변경" , description = "회원정보 변경 관련 API")
    @PutMapping(name = "/v1.0.0/member")
    public HttpEntity chngMemberInfo(@Valid @RequestBody final MemberLoginDto memberLoginDto) {

        return memberService.chngMemberInfo(memberLoginDto) == true ?
            ApiResponse.ok(CCConst.UPDATE_SUCCESS, null) : ApiResponse.fail(MEMBER_ERROR_002);

    }
}



















