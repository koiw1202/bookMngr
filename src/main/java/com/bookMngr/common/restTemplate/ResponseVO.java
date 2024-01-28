package com.bookMngr.common.restTemplate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpHeaders;

import java.util.Map;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-25        koiw1       최초 생성
 */
@AllArgsConstructor
@Getter
@ToString
public class ResponseVO {

    private final Integer status ;
    private final String code ;
    private final String message ;
    private final Map<String, Object> data ;
    private final HttpHeaders headers ;

}
