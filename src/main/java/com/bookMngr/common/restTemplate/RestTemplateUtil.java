package com.bookMngr.common.restTemplate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * description    : RestTmeplate를 통하여 Http 통신을 위한 Util 클레스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-25        koiw1       최초 생성
 */
@Component
@Slf4j
public class RestTemplateUtil {

    private final RestTemplate restTemplate ;
    public RestTemplateUtil(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity get(String uri, HttpEntity entity, Map<String, String> queryStringMap) {

        Set<Map.Entry<String, String>> set = queryStringMap.entrySet() ;
        String queryString = set.stream()
            .map(vo -> String.join("", vo.getKey(), "=", vo.getValue(), "&"))
            .collect(Collectors.joining());

        return this.httpCommunication(String.join("", uri, "?", queryString), HttpMethod.GET, entity);
    }

    public ResponseEntity post(String uri, HttpEntity entity) {

        return this.httpCommunication(uri, HttpMethod.POST, entity) ;
    }

    public ResponseEntity httpCommunication(String uri, HttpMethod httpMethod, HttpEntity entity) {
        return restTemplate.exchange(uri, httpMethod, entity, ResponseVO.class) ;
    }


}














