package com.bookMngr.common.auth;

import com.bookMngr.common.code.PAYLOAD_TYPE;
import com.bookMngr.common.jwt.TokenManagement;
import com.bookMngr.common.jwt.vo.PayloadVo;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Optional;

import static com.bookMngr.common.code.PAYLOAD_TYPE.USER_CD;

/**
 * description    : 유저의 정보를 제공해주는 클레스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-24        koiw1       최초 생성
 */
@Component
public class UserAuthProvider {
    private final UserAuthHolderService userAuthHolderService ;
    private final TokenManagement tokenManagement;

    public UserAuthProvider(TokenManagement tokenManagement, UserAuthHolderService userAuthHolderService) {
        this.userAuthHolderService = userAuthHolderService ;
        this.tokenManagement = tokenManagement;
    }

    public String getUserInfo(PAYLOAD_TYPE payloadType) {

        return Optional.ofNullable(userAuthHolderService.get())
                       .map(holder -> {
                        try {
                            Class rCls = holder.getClass() ;
                            Field field = rCls.getDeclaredField(payloadType.getName()) ;
                            field.setAccessible(true) ;

                            return field.get(holder).toString() ;

                        } catch(Exception e) {
                            return null ;
                        }
               })
               .orElse(null) ;
    }
}
