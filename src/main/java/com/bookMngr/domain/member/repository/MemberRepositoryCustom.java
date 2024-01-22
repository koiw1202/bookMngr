package com.bookMngr.domain.member.repository;

import com.bookMngr.domain.member.domain.Member;
import com.bookMngr.domain.member.model.ChngMemberInfoForSerDto;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-03        koiw1       최초 생성
 */
public interface MemberRepositoryCustom {

    long updateMember(final ChngMemberInfoForSerDto chngMemberInfoForSerDto) ;

    Member checkMemberIdExist(String memberId) ;

    Member login(String memberId, String password) ;


}
