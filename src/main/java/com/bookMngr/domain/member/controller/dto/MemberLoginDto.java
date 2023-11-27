package com.bookMngr.domain.member.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.bookMngr.common.constant.RegExpConstants.REGEXP_NOT_SPECIAL_CHAR_TYPE1;
import static com.bookMngr.common.constant.RegExpConstants.REGEXP_USER_PW_TYPE1;
import static com.bookMngr.common.error.ErrorMessage.*;

/**
 * description    : 아이디와 비밀번호만을 가진 객체
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        koiw1       최초 생성
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberLoginDto {

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    @Schema(name = "memberId" , description = "아이디" , example = "abcd123" , required = true)
    @Pattern(regexp = REGEXP_NOT_SPECIAL_CHAR_TYPE1, message = MSG_MEMBER_ERROR_001)
    @Size(min = 5, max = 12, message = MSG_MEMBER_ERROR_002)
    private String memberId ;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Schema(name = "password" , description = "비밀번호" , example = "1q2w3e4r!" , required = true, maxLength = 200)
    @Pattern(regexp = REGEXP_USER_PW_TYPE1, message = MSG_MEMBER_ERROR_004)
    private String password ;

}
