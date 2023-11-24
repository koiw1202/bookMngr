package com.bookMngr.domain.auth.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        koiw1       최초 생성
 */
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthInfoDto {

    @NotBlank(message = "userGrade는 필수입력 값입니다.")
    @Schema(name = "userGrade" , description = "유저등급" , example = "GOLD" , required = true)
    private String userGrade ;

    @NotBlank(message = "userGrant는 필수입력 값입니다.")
    @Schema(name = "userGrant" , description = "유저권한" , example = "M" , required = true)
    private String userGrant ;

    @NotBlank(message = "userCd는 필수입력 값입니다.")
    @Schema(name = "userCd" , description = "유저코드" , example = "U0000000001" , required = true)
    private String userCd ;

}
