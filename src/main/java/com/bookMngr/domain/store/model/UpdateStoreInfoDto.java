package com.bookMngr.domain.store.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;

import static com.bookMngr.domain.store.cc.CommonMessage.STORE_MSG_001;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-02        koiw1       최초 생성
 */
@Getter
@Setter
public class UpdateStoreInfoDto {

    @NotBlank(message = STORE_MSG_001)
    @Schema(name = "storeCd" , description = "매장코드" , example = "1" , required = true)
    private long storeCd ;

    @Schema(name = "storeNm" , description = "매장명" , example = "1")
    private String storeNm ;

    @Schema(name = "address" , description = "매장 주소" , example = "서울시 양천구 신정동")
    private String address ;

    @Schema(name = "latitude" , description = "매장위도" , example = "37.5337")
    private BigDecimal latitude ;

    @Schema(name = "longitude" , description = "매장경도" , example = "126.8331")
    private BigDecimal longitude ;

}
