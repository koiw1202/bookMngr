package com.bookMngr.domain.member.repository;

import com.bookMngr.common.mybatis.mapper.UserMapper;
import com.bookMngr.domain.member.domain.Member;
import com.bookMngr.domain.member.model.res.MemberForServiceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-23        koiw1       최초 생성
 */
@Component
@RequiredArgsConstructor
@Repository
public class MemberNativeRepository {

    private final UserMapper userMapper ; ;

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void insertTestFunc() throws Exception {

        Member member = Member.builder()
                .memberForServiceDto(MemberForServiceDto.builder().memberId("TEST" + String.valueOf(LocalDateTime.now().getNano()))
                        .password("12345")
                        .phoneNumber("1111111")
                        .nickNm("123")
                        .rstYn("Y")
                        .unregYn("Y")
                        .unregYn("N")
                        .build()
                ).build() ;

        userMapper.joinUserInfoByMyBatis(member);

//        if(1==1)
//            throw new Exception() ;

    }
}
