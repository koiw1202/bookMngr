package com.bookMngr.member.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import static com.bookMngr.common.constant.RegExpConstants.*;
import static com.bookMngr.common.error.ErrorMessage.*;

/**
 * packageName    : com.bookMngr.member.model
 * fileName       : MemberDto
 * author         : FIC08709
 * date           : 2023-11-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-22        FIC08709       최초 생성
 */
@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

    @NonNull
    @Schema(name = "memberId" , description = "아이디" , example = "abcd123" , required = true)
    @Pattern(regexp = REGEXP_NOT_SPECIAL_CHAR_TYPE1, message = MSG_MEMBER_ERROR_001)
    @Size(min = 5, max = 12, message = MSG_MEMBER_ERROR_002)
    private String memberId ;

    @NonNull
    @Schema(name = "password" , description = "비밀번호" , example = "1q2w3e4r!" , required = true, maxLength = 200)
    @Pattern(regexp = REGEXP_USER_PW_TYPE1, message = MSG_MEMBER_ERROR_004)
    private String password ;

    @NonNull
    @Schema(name = "phoneNo" , description = "휴대전화 번호" , example = "01012341234" , required = true)
    @Pattern(regexp = REGEXP_PHONENUMBER_TYPE, message = MSG_MEMBER_ERROR_003)
    private String phoneNo ;

    @NonNull
    @Schema(name = "nickNm" , description = "닉네임" , example = "커피한잔마시고" , required = true)
    @Pattern(regexp = REGEXP_NOT_SPECIAL_CHAR_TYPE3, message = MSG_MEMBER_ERROR_006)
    @Size(min = 5, max = 12, message = MSG_MEMBER_ERROR_005)
    private String nickNm ;

}
