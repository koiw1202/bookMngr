package com.bookMngr.common.dao.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Getter
@Setter
@ToString
public class SelectUserOutDao {

    private Integer memberCd ;
    private Integer loginCnt ;
    private String memberGrade ;
    private String member_grant ;
    private String memberId ;
    private String nickNm ;
    private String password ;
    private String phoneNumber ;
    private Date regerDt ;
    private String rstYn ;
    private String unregYn ;
}
