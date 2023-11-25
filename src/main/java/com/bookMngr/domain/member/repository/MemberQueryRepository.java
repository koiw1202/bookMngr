package com.bookMngr.domain.member.repository;

import com.bookMngr.common.auth.UserAuthProvider;
import com.bookMngr.common.code.PAYLOAD_TYPE;
import com.bookMngr.domain.member.domain.Member;
import com.bookMngr.domain.member.model.ChngMemberInfoForSerDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import static com.bookMngr.domain.member.domain.QMember.member;
import static org.springframework.util.StringUtils.hasText;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-25        koiw1       최초 생성
 */
@Repository
public class MemberQueryRepository {

    private final JPAQueryFactory jpaQueryFactory ;
    private final UserAuthProvider userAuthProvider ;

    public MemberQueryRepository(JPAQueryFactory jpaQueryFactory, UserAuthProvider userAuthProvider) {
        this.jpaQueryFactory = jpaQueryFactory;
        this.userAuthProvider = userAuthProvider;
    }

//    private BooleanExpression memberIdEq(final String memberId) {
//        return hasText(memberId) ? member.memberPK.memberId.eq(memberId) : null ;
//    }

    private BooleanExpression memberIdEq(final String memberId) {
        return hasText(memberId) ? member.memberId.eq(memberId) : null ;
    }

    private BooleanExpression memberCdEq(final Long memberCd) {
        return hasText(String.valueOf(memberCd)) ? member.memberCd.eq(memberCd) : null ;
    }

    private BooleanExpression passwordEq(final String password) {
        return hasText(password) ? member.password.eq(password) : null ;
    }

    public long updateMember(final ChngMemberInfoForSerDto chngMemberInfoForSerDto) {
        return jpaQueryFactory.update(member)
                .where(memberIdEq(userAuthProvider.getUserInfo(PAYLOAD_TYPE.USER_CD)))
                .execute() ;
    }

    public Member checkMemberIdExist(String memberId) {
        return jpaQueryFactory.selectFrom(member)
                .where(memberIdEq(memberId))
                .fetchOne() ;
    }

    public Member login(String memberId, String password) {
        return jpaQueryFactory.selectFrom(member)
                .where(memberIdEq(memberId)
                        .and(passwordEq(password))
                ).fetchOne() ;
    }


}
