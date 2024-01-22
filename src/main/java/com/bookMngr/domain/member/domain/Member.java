package com.bookMngr.domain.member.domain;

import com.bookMngr.common.code.MemberGradeType;
import com.bookMngr.common.code.MemberGrantType;
import com.bookMngr.common.constant.CCConst;
import com.bookMngr.domain.member.model.res.MemberForServiceDto;
import lombok.*;

import javax.persistence.*;
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
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@TableGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        table = "sequence_all",
        pkColumnValue = "MEMBER_SEQ",
        allocationSize = 1
)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "MEMBER_SEQ_GENERATOR")
    private long memberCd ;

    @Column(name = "Member_ID", length = 15, unique = true, nullable = false)
    private String memberId ;

    @Column(length = 200, nullable = false)
    private String password ;

    @Column(length = 12, nullable = true)
    private String nickNm ;

    @Column(length = 2, nullable = false)
    private String memberGrade ;

    @Enumerated(EnumType.STRING)
    private MemberGrantType memberGrant ;

    @Column(length = 12, nullable = false)
    private String phoneNumber ;

//    탈퇴여부
    @Column(length = 1, nullable = false)
    private String unregYn ;

//   휴면여부
    @Column(length = 1, nullable = false)
    private String rstYn ;

    @Column(nullable = false)
    private Timestamp regerDt ;


    @Builder
    public Member(MemberForServiceDto memberForServiceDto) {

        this.memberId = memberForServiceDto.getMemberId() ;
        this.password = memberForServiceDto.getPassword() ;
        this.nickNm = memberForServiceDto.getNickNm() ;
        this.unregYn = CCConst.N ;
        this.rstYn = CCConst.N ;
        this.memberGrade = MemberGradeType.WELCOME_LEVEL.getCode() ;
        this.memberGrant = MemberGrantType.U ;
        this.phoneNumber = memberForServiceDto.getPhoneNumber();
        this.regerDt = new Timestamp(System.currentTimeMillis()) ;

    }

}
