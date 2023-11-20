package com.bookMngr.bookmngr;

import com.bookMngr.common.CCConst;
import com.bookMngr.common.code.CommCd;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookMngrApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void insertCategoryTest() throws Exception {

        List<Map> requestList = new ArrayList<>() ;
        String[] categoryStr = {"문학", "경제경영", "인문학", "IT", "과학"} ;

        for(String s : categoryStr) {
            requestList.add( new HashMap<String, String>() {
                {
                    put("categoryNm", s) ;
                }
            }) ;
        }

        for(Map bodyMap : requestList) {
            String content = new ObjectMapper().writeValueAsString(bodyMap) ;
            mockMvc.perform(
                            MockMvcRequestBuilders.post("http://localhost:8080/category") // url
                                    .contentType(MediaType.APPLICATION_JSON) // contentType 설정
                                    .content(content)
                    )
                    .andDo(print()) // api 수행내역 로그 출력
                    .andExpect(status().isOk()) // response status 200 검증
                    .andExpect(jsonPath("code").value(CommCd.OK_CODE))
                    ;
        }
    }

    @Test
    void insertBookTest() throws Exception {

        List<Map> requestList = new ArrayList<>() ;

        String[] bookTitleStrArr = {
                 "너에게 해주지 못한 말들"
                ,"단순하게 배부르게"
                ,"게으른 사랑"
                ,"트랜드 코리아 2322"
                ,"초격자 투자"
                ,"파이어족 강환국의 하면 되지 않는다! 퀀트 투자"
                ,"진심보다 밥"
                ,"실패에 대하여 생각하지 마라"
                ,"실리콘밸리 리더십 쉽다"
                ,"데이터분석을 위한 A 프로그래밍"
                ,"Skye가 알려주는 피부 채색의 비결"
                ,"인공지능1-12"
                ,"-1년차 게임 개발"
                ,"자연의 발전"
                ,"코스모스 필 무렵"
        } ;

        String[] bookWriterStrArr = {
                 "권태영"
                ,"현영서"
                ,"권태영"
                ,"권태영"
                ,"장동혁"
                ,"홍길동"
                ,"이서연"
                ,"위성원"
                ,"지승열"
                ,"지승열"
                ,"장동혁"
                ,"위성원"
                ,"권태영"
                ,"장지명"
                ,"이승열"
        } ;

        Long[] categoryStrArr = {
                10L,
                10L,
                10L,
                11L,
                11L,
                11L,
                12L,
                12L,
                13L,
                13L,
                13L,
                13L,
                13L,
                14L,
                14L
        } ;

        for(int i=0; i < categoryStrArr.length; i++) {
            int j = i ;
            requestList.add( new HashMap<String, Object>() {
                {
                    put("writer", bookWriterStrArr[j]) ;
                    put("title", bookTitleStrArr[j]) ;
                    put("categoryId", categoryStrArr[j]) ;
                }
            }) ;
        }

        for(Map bodyMap : requestList) {
            String content = new ObjectMapper().writeValueAsString(bodyMap) ;
            mockMvc.perform(
                            MockMvcRequestBuilders.post("http://localhost:8080/book") // url
                                    .contentType(MediaType.APPLICATION_JSON) // contentType 설정
                                    .content(content)
                    )
                    .andDo(print()) // api 수행내역 로그 출력
                    .andExpect(status().isOk()) // response status 200 검증
                    .andExpect(jsonPath("code").value(CommCd.OK_CODE))
            ;
        }
    }
}
