package com.bookMngr.bookmngr;

import com.bookMngr.common.auth.UserAuthHolderService;
import com.bookMngr.common.auth.UserAuthProvider;
import com.bookMngr.common.auth.vo.UserAuthVO;
import com.bookMngr.common.code.PAYLOAD_TYPE;
import com.bookMngr.common.jwt.vo.PayloadVo;
import com.bookMngr.common.restTemplate.RestTemplateUtil;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
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

    }

    @BeforeAll
    public static void junit5Test1() {
        System.out.println("junit5 Test1 started");
    }

    @BeforeEach
    public void junit5Test2() {
        System.out.println("junit5 Test2 started");
    }

    @Test
    public void junit5Test3() {
        System.out.println("junit5 Test3 started") ;
    }

    @AfterEach
    public void junit5Test41() {
        System.out.println("junit5 Test41 started");
    }

    @AfterEach
    public void junit5Test42() {
        System.out.println("junit5 Test42 started");
    }

    @AfterEach
    public void junit5Test4() {
        System.out.println("junit5 Test4 started");
    }

    @AfterAll
    public static void junit5Test5() {
        System.out.println("junit5 Test5 started");
    }


}























