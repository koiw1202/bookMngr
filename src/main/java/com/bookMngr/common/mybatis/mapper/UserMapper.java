package com.bookMngr.common.mybatis.mapper;

import com.bookMngr.common.dao.user.SelectUserOutDao;
import com.bookMngr.domain.member.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<SelectUserOutDao> selectUser() ;

    Integer joinUserInfoByMyBatis(Member member) ;
}
