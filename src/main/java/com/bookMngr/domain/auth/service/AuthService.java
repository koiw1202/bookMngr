package com.bookMngr.domain.auth.service;

import com.bookMngr.common.jwt.TokenFactory;
import com.bookMngr.common.jwt.vo.PayloadVo;
import com.bookMngr.common.jwt.vo.TokenVO;
import com.bookMngr.domain.auth.model.PayloadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * description    : 인증과 관련된 기능을 제공해주는 클레스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        koiw1       최초 생성
 */
@Service
@RequiredArgsConstructor
public class AuthService {

    private final TokenFactory tokenFactory ;

    public TokenVO getToken(final PayloadDto payloadDto) {

        return tokenFactory.issueAllToken(
                PayloadVo.builder()
                         .memberCd(payloadDto.getMemberCd())
                         .memberGrade(payloadDto.getMemberGrade())
                         .memberGrant(payloadDto.getMemberGrant())
                         .build()) ;

    }

//    public TokenVO refreshToekn() {
//
//        return tokenFactory.issueAllToken(
//                PayloadVo.builder()
//                        .userCd(payloadDto.getUserCd())
//                        .userGrade(payloadDto.getUserGrade())
//                        .userGrant(payloadDto.getUserGrant())
//                        .build()) ;
//
//    }

}



