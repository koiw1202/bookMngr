package com.bookMngr.common.restTemplate;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import java.util.Arrays;
import java.util.Optional;

/**
 * description    : HttpEntity의 값에 Builder를 적용한 클레스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-25        koiw1       최초 생성
 */

@Getter
public class HttpProtocol<T> extends HttpEntity {

    private final T body ;
    private final HttpHeaders headers ;

    @Builder
    public HttpProtocol(T body, HttpHeaders headers) {
        super(body, headers) ;


        this.body = body;

        if(headers == null) {
            this.headers = new HttpHeaders() ;
        } else {
            this.headers = headers ;
        }

        this.headers.add("Content-Type", "application/json");

    }
}
