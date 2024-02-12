package com.bookMngr.domain.store.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

import static com.bookMngr.domain.store.cc.CommonMessage.*;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-02        koiw1       최초 생성
 */
@Getter
@Setter
public class EnrollStoreDto {

    @NotBlank(message = STORE_MSG_001)
    @Schema(name = "storeNm" , description = "매장명" , example = "1" , required = true)
    private String storeNm ;

    @NotBlank(message = STORE_MSG_002)
    @Schema(name = "address" , description = "매장 주소" , example = "서울시 양천구 신정동" , required = true)
    private String address ;

    @NotBlank(message = STORE_MSG_003)
    @Schema(name = "latitude" , description = "매장위도" , example = "37.5337" , required = true)
    private BigDecimal latitude ;

    @NotBlank(message = STORE_MSG_004)
    @Schema(name = "longitude" , description = "매장경도" , example = "126.8331" , required = true)
    private BigDecimal longitude ;

}
