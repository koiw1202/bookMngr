package com.bookMngr.domain.member.repository;

import com.bookMngr.common.auth.UserAuthProvider;
import com.bookMngr.common.code.PAYLOAD_TYPE;
import com.bookMngr.domain.member.domain.Member;
import com.bookMngr.domain.member.model.ChngMemberInfoForSerDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static com.bookMngr.domain.member.domain.QMember.member;
import static org.springframework.util.StringUtils.hasText;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-03        koiw1       최초 생성
 */
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory ;
    private final UserAuthProvider userAuthProvider ;

    public MemberRepositoryImpl(JPAQueryFactory jpaQueryFactory, UserAuthProvider userAuthProvider) {
        this.jpaQueryFactory = jpaQueryFactory;
        this.userAuthProvider = userAuthProvider;
    }

    private BooleanExpression memberIdEq(final String memberId) {
        return hasText(memberId) ? member.memberId.eq(memberId) : null ;
    }

    private BooleanExpression memberCdEq(final Long memberCd) {
        return hasText(String.valueOf(memberCd)) ? member.memberCd.eq(memberCd) : null ;
    }

    private BooleanExpression passwordEq(final String password) {
        return hasText(password) ? member.password.eq(password) : null ;
    }

    @Override
    public long updateMember(final ChngMemberInfoForSerDto chngMemberInfoForSerDto) {
        return jpaQueryFactory.update(member)
                .where(memberIdEq(userAuthProvider.getUserInfo(PAYLOAD_TYPE.USER_CD)))
                .execute() ;
    }

    @Override
    public Member checkMemberIdExist(String memberId) {
        return jpaQueryFactory.selectFrom(member)
                .where(memberIdEq(memberId))
                .fetchOne() ;
    }

    @Override
    public Member login(String memberId, String password) {
        return jpaQueryFactory.selectFrom(member)
                .where(memberIdEq(memberId)
                        .and(passwordEq(password))
                ).fetchOne() ;
    }
}
