package com.bookMngr.bookmngr;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.HashMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("local")
@Slf4j
public class MemberTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * 회원가입 테스트
     * @throws Exception
     */
    @Test
    public void joinMember() throws Exception {

        String content = new ObjectMapper().writeValueAsString(
            new HashMap<String, String>(){{
               put("memberId", "abcd123") ;
               put("password", "1q2w3e4r!") ;
               put("phoneNumber", "01012341234") ;
               put("nickNm", "커피한잔마시고") ;

           }}
        ) ;

        MvcResult mvcResult = mockMvc.perform(
           post("http://localhost:8080/v1.0.0/member")
                   .content(content)
                   .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
        .andReturn() ;

        log.info(" Result -----> {}", mvcResult.getResponse().getContentAsString()) ;

    }



}
















