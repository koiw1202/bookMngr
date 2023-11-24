package com.bookMngr.domain.member.controller;

import com.bookMngr.common.auth.UserAuthHolderService;
import com.bookMngr.common.auth.UserAuthProvider;
import com.bookMngr.common.code.PAYLOAD_TYPE;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-24        koiw1       최초 생성
 */
@RestController
public class UtilController {

    @Autowired
    UserAuthProvider userAuthProvider ;

    @Autowired
    UserAuthHolderService userAuthHolderService ;

    @GetMapping("/util")
    public void Test() {

        System.out.println(userAuthProvider.getUserInfo(PAYLOAD_TYPE.USER_CD) );
        System.out.println(userAuthProvider.getUserInfo(PAYLOAD_TYPE.GRANT));
        System.out.println(userAuthProvider.getUserInfo(PAYLOAD_TYPE.GRADE));

    }

}
