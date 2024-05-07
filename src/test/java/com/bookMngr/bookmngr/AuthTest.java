package com.bookMngr.bookmngr;

import com.bookMngr.common.auth.UserAuthProvider;
import com.bookMngr.common.code.PAYLOAD_TYPE;
import com.bookMngr.common.jwt.TokenManagement;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-24        koiw1       최초 생성
 */
@SpringBootTest
@ActiveProfiles("local")
@AutoConfigureMockMvc
@Slf4j
public class AuthTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TokenManagement tokenManagement ;

    @Autowired
    UserAuthProvider userAuthProvider ;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll invoke");
    }

    public String refreshTokenTest() throws Exception {

        String content = new ObjectMapper().writeValueAsString(new HashMap<String, String>(){{
            put("userGrade", "G") ;
            put("userGrant", "G") ;
            put("userCd", "0001") ;
        }}
        ) ;

        log.info("----------> content {}", content) ;

//      토큰 발급
        MvcResult mvcResult = mockMvc.perform(
                post("http://localhost:8080/v1.0.0/auth/token")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        )
        .andExpect(status().isOk())
        .andReturn()

        ;

        System.out.println("accessToken : " + mvcResult.getResponse().getHeader("accessToken"));
        System.out.println("refreshToken : " + mvcResult.getResponse().getHeader("refreshToken"));

        String accessToken = mvcResult.getResponse().getHeader("accessToken") ;
        String refreshToken = mvcResult.getResponse().getHeader("refreshToken") ;

        assertEquals(tokenManagement.validationCheckToken(accessToken), true) ;
        assertEquals(tokenManagement.validationCheckToken(refreshToken), true) ;

        return accessToken ;
    }

    /**
     * 만료된 토큰으로 유효기간 테스트
     */
    @Test
    public void jwtValidCheck() {

        String accessToken = "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VyR3JhZGUiOiJHIiwidXNlckNkIjoiMDAwMSIsInVzZXJHcmFudCI6IkciLCJzdWIiOiJVc2VyJ3Mgand0IGZvciBBdXRob3JpemF0aW9uIiwiZXhwIjoxNzAwODAwODQwfQ.b0TSfa-WTfk1DC5AW8qa_MxxAXK2TwwT9m7EteCfBTY" ;
        assertEquals(tokenManagement.validationCheckToken(accessToken), false) ;
    }

    /**
     * jwtToPayload 메소드 기능 테스트하는 메소드
     */
    @Test
    public void jwtToPayloadTest() throws Exception {
        String accessToken = refreshTokenTest() ;

        System.out.println( tokenManagement.jwtToPayload(accessToken)) ;
        System.out.println( userAuthProvider.getUserInfo(PAYLOAD_TYPE.GRADE) );
        System.out.println( userAuthProvider.getUserInfo(PAYLOAD_TYPE.USER_CD) );
        System.out.println( userAuthProvider.getUserInfo(PAYLOAD_TYPE.GRANT) );

    }

}

























