package com.bookMngr.domain.store.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

import static com.bookMngr.common.constant.CCConst.PAGENO_NOTBLANK_MESSAGE;
import static com.bookMngr.domain.store.cc.CommonMessage.STORE_MSG_001;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-05        koiw1       최초 생성
 */
@Getter
@Builder
@ToString
public class StoreInfoDto {

    private Long storeCd ;
    private String storeNm ;
    private String storeAddress ;
    private BigDecimal storeLatitude ;
    private BigDecimal storeLongitude ;
    private Integer pageNo ;
    private Integer pageSize ;

}
