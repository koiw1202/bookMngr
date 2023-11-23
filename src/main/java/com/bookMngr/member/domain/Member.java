package com.bookMngr.member.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * packageName    : com.bookMngr.user.domain
 * fileName       : User
 * author         : FIC08709
 * date           : 2023-11-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-22        FIC08709       최초 생성
 */
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @Column(name = "Member_ID", length = 15)
    private String memberId ;

    @Column(length = 200, nullable = false)
    private String password ;

    @Column(length = 12, nullable = true)
    private String nickNm ;

    @Column(length = 2, nullable = false)
    private String memberGrade ;

    @Column(length = 1, nullable = false)
    private String authGrade ;

//    탈퇴여부
    @Column(length = 1, nullable = false)
    private String unregYn ;

//   휴면여부
    @Column(length = 1, nullable = false)
    private String rstYn ;

    @Column(nullable = false)
    private Timestamp regerDt ;

}
