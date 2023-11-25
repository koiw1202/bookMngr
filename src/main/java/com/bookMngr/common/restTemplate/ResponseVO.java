package com.bookMngr.common.restTemplate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.MultiValueMap;

import java.util.Map;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-25        koiw1       최초 생성
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ResponseVO {

    private Integer status ;
    private String code ;
    private String message ;
    private Object data ;

}
