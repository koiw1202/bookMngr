package com.bookMngr.domain.auth.model;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * description    : Controller로부터 받은 페이로드 정보를 담는 클레스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        koiw1       최초 생성
 */
@Getter
@Builder
public class PayloadDto {

    private String memberGrade ;
    private String memberGrant ;
    private String memberCd ;
}
