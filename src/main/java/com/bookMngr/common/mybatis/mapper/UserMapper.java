package com.bookMngr.common.mybatis.mapper;

import com.bookMngr.common.dao.user.SelectUserOutDao;
import com.bookMngr.domain.member.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<SelectUserOutDao> selectUser1() ;

    List<SelectUserOutDao> selectUser2() ;

    List<SelectUserOutDao> selectUser3() ;

    List<SelectUserOutDao> selectUser4(String userId) ;

    Integer joinUserInfoByMyBatis(Member member) ;
}
