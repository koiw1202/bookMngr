package com.bookMngr.bookmngr;

import com.bookMngr.common.auth.UserAuthHolderService;
import com.bookMngr.common.auth.UserAuthProvider;
import com.bookMngr.common.auth.vo.UserAuthVO;
import com.bookMngr.common.code.PAYLOAD_TYPE;
import com.bookMngr.common.jwt.vo.PayloadVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.lang.reflect.Field;

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
                        .userGrant("1")
                        .userCd("2")
                        .userGrade("3")
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


}
