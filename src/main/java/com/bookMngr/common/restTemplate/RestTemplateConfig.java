package com.bookMngr.common.restTemplate;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.apache.http.impl.client.HttpClientBuilder;

import java.net.http.HttpClient;

/**
 * description    : restTemplate 환경설정
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-25        koiw1       최초 생성
 */

@Configuration(proxyBeanMethods = false)
public class RestTemplateConfig {

    @Value("${network.time.connection}")
    private int CONNECTION_TIMEOUT;

    @Value("${network.time.read}")
    private int READ_TIMEOUT;

    @Value("${network.rt.max-conn}")
    private int RT_MAX_CONN;

    @Value("${network.rt.max-per-route}")
    private int RT_MAX_PER_ROUTE;

    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        CloseableHttpClient httpClient =
                HttpClientBuilder.create().build();

        factory.setConnectTimeout(CONNECTION_TIMEOUT);
        factory.setReadTimeout(READ_TIMEOUT);
        factory.setHttpClient(httpClient);

        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(factory));
        return restTemplate;
    }


}
