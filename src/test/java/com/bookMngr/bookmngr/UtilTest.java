package com.bookMngr.bookmngr;

import com.bookMngr.common.auth.UserAuthHolderService;
import com.bookMngr.common.auth.UserAuthProvider;
import com.bookMngr.common.auth.vo.UserAuthVO;
import com.bookMngr.common.code.PAYLOAD_TYPE;
import com.bookMngr.common.jwt.vo.PayloadVo;
import com.bookMngr.common.restTemplate.RestTemplateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static com.bookMngr.common.code.PAYLOAD_TYPE.USER_CD;

/**
 * description    : 부가 기능을 테스트 하기 위한 테스트 클레스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-24        koiw1       최초 생성
 */

@SpringBootTest
@ActiveProfiles("local")
public class UtilTest {

    @Autowired
    UserAuthProvider userAuthProvider ;

    @Autowired
    UserAuthHolderService userAuthHolderService ;

    @Test
    public void threadLocalTest() throws NoSuchFieldException, IllegalAccessException {

        userAuthHolderService.set(
                                PayloadVo.builder()
                        .memberGrant("1")
                        .memberCd("2")
                        .memberGrade("3")
                        .build())
        ;

        UserAuthVO userAuthVO = userAuthHolderService.get() ;

        Class rCls = userAuthVO.getClass() ;
        Field field = rCls.getDeclaredField(USER_CD.getName()) ;
        field.setAccessible(true) ;

        System.out.println( (String) field.get(userAuthVO)) ;
        System.out.println(userAuthHolderService.get()) ;

        System.out.println(userAuthProvider.getUserInfo(USER_CD));
        System.out.println(userAuthProvider.getUserInfo(PAYLOAD_TYPE.GRANT));
        System.out.println(userAuthProvider.getUserInfo(PAYLOAD_TYPE.GRADE));
    }


    @Autowired
    RestTemplateUtil restTemplateUtil ;
    /**
     * RestTmeplate 테스트용 메소드
     */

    @Test
    public void restTmeplateTest() {
        Map<String, String> body = new HashMap<>(){{
            put("pageNo", String.valueOf(1)) ;
            put("pageSize", String.valueOf(10)) ;
            put("searchType", "00") ;
        }} ;

        HttpEntity entity = new HttpEntity(body) ;

        System.out.println(restTemplateUtil.get("http://localhost:8080/v1.0.0/book", entity, body));

    }




}













