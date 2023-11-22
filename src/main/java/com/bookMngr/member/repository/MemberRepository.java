package com.bookMngr.member.repository;

import com.bookMngr.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : com.bookMngr.user.repository
 * fileName       : UserRepository
 * author         : FIC08709
 * date           : 2023-11-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-22        FIC08709       최초 생성
 */
public interface MemberRepository extends JpaRepository<Member, String> {

}
