package com.bookMngr.domain.member.controller;

import com.bookMngr.common.constant.CCConst;
import com.bookMngr.common.response.ApiResponse;
import com.bookMngr.domain.member.controller.dto.ChngMemberInfoDto;
import com.bookMngr.domain.member.controller.dto.MemberDto;
import com.bookMngr.domain.member.controller.dto.MemberLoginDto;
import com.bookMngr.domain.member.model.ChngMemberInfoForSerDto;
import com.bookMngr.domain.member.model.MemberLoginForServiceDto;
import com.bookMngr.domain.member.model.res.MemberForResDto;
import com.bookMngr.domain.member.model.res.MemberForServiceDto;
import com.bookMngr.domain.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

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
    @PostMapping("/v1.0.0/member2")
    public HttpEntity joinMember2(@Valid @RequestBody final MemberDto memberDto) {

        memberService.joinMemberTest(
                MemberForServiceDto
                        .builder()
                        .memberId(memberDto.getMemberId())
                        .password(memberDto.getPassword())
                        .nickNm(memberDto.getNickNm())
                        .rstYn(CCConst.N)
                        .unregYn(CCConst.N)
                        .phoneNumber(memberDto.getPhoneNumber())
                        .build()
        ) ;

        return ApiResponse.ok(MEMBER_JOIN_SUCCESS, null) ;
    }

    @Operation(summary = "회원가입" , description = "회원가입 API")
    @PostMapping("/v1.0.0/member")
    public HttpEntity joinMember(@Valid @RequestBody final MemberDto memberDto) {

        MemberForResDto memberForResDto = memberService.joinMember(
            MemberForServiceDto
                    .builder()
                    .memberId(memberDto.getMemberId())
                    .password(memberDto.getPassword())
                    .nickNm(memberDto.getNickNm())
                    .rstYn(CCConst.N)
                    .unregYn(CCConst.N)
                    .phoneNumber(memberDto.getPhoneNumber())
                    .build()
        ) ;

        return ApiResponse.ok(MEMBER_JOIN_SUCCESS, memberForResDto) ;
    }

    @Operation(summary = "회원정보 변경" , description = "회원정보 변경 관련 API")
    @PutMapping("/v1.0.0/member")
    public HttpEntity chgMemberInfo(@Valid @RequestBody ChngMemberInfoDto chngMemberInfoDto) {

        return memberService.chgMemberInfo(
                ChngMemberInfoForSerDto
                        .builder()
                        .nickNm(chngMemberInfoDto.getNickNm())
                        .password(chngMemberInfoDto.getPassword())
                        .build()) == true ?
            ApiResponse.ok(CCConst.UPDATE_SUCCESS, null) : ApiResponse.fail(MEMBER_ERROR_002);

    }


    @Operation(summary = "로그인", description = "로그인 관련 API")
    @PostMapping("/v1.0.0/login")
    public HttpEntity doSignIn(@Valid @RequestBody final MemberLoginDto memberLoginDto) {
        Map<String, Object> body = memberService.doSignIn(
                MemberLoginForServiceDto.builder()
                        .memberId(memberLoginDto.getMemberId())
                        .password(memberLoginDto.getPassword())
                        .build()) ;

        MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<>() ;

        headerMap.add("accessToken", body.get("accessToken").toString());
        headerMap.add("refreshToken", body.get("refreshToken").toString());

        return ApiResponse.ok("성공적으로 로그인되었습니다.", null, new HttpHeaders(headerMap)) ;

    }

    @GetMapping("/v1.0.0/myBatis/user1")
    public HttpEntity getUserByMybatis1() {
        return ApiResponse.ok(CCConst.SELECT_SUCCESS, memberService.getUserInfoByMyBatis3()) ;
    }

    @GetMapping("/v1.0.0/myBatis/user2")
    public HttpEntity getUserByMybatis2() {
        return ApiResponse.ok(CCConst.SELECT_SUCCESS, memberService.getUserInfoByMyBatis4()) ;
    }

    @PostMapping("/v1.0.0/myBatis/user")
    public HttpEntity joinUserByMybatis() throws Exception {

        return ApiResponse.ok(CCConst.MERGE_SUCCESS, memberService.joinUserInfoByMyBatis()) ;

    }
}



