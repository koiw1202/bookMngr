package com.bookMngr.common.auth;

import com.bookMngr.common.auth.vo.UserAuthVO;
import com.bookMngr.common.jwt.TokenManagement;
import com.bookMngr.common.jwt.vo.PayloadVo;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-24        koiw1       최초 생성
 */
@Component
public class UserAuthHolderService {

    public final ThreadLocal<UserAuthVO> threadHolder ;
    private final TokenManagement tokenManagement ;

    public UserAuthHolderService(TokenManagement tokenManagement) {
        this.tokenManagement = tokenManagement;
        this.threadHolder = new ThreadLocal<>() ;
    }

    /**
     * JWT의 페이로드 정보를 user정보에 담아주는 메소드
     */
    public void set(PayloadVo payloadVo) {

        Optional.ofNullable(payloadVo)
                .ifPresentOrElse(svo -> {
                    this.threadHolder.remove();
                    this.threadHolder.set(
                            UserAuthVO.builder()
                                    .userGrant(svo.getUserGrant())
                                    .userCd(svo.getUserCd())
                                    .userGrade(svo.getUserGrade())
                                    .build()
                    ) ;
                }, () -> {

                });

    }

    /**
     * 현재 사용자 정보를 Holder에서 추출..
     * @return
     */
    public UserAuthVO get(){

        return Optional.ofNullable(threadHolder.get())
                .orElse(null);
    }

    public void clear() {
        Optional.ofNullable(this.threadHolder.get())
                .ifPresent(holder -> {
                    this.threadHolder.remove() ;
                }) ;
    }

    public void addUserInfo(String accessToken) {
        Optional.ofNullable(accessToken)
                .ifPresentOrElse(token -> {
                    this.set(tokenManagement.jwtToPayload(accessToken)) ;
                }, () -> {

                }) ;
    }

}



























