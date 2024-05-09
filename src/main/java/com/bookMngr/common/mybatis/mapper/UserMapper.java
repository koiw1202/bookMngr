package com.bookMngr.common.mybatis.mapper;

import com.bookMngr.common.dao.user.SelectUserOutDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<SelectUserOutDao> selectUser() ;
}
