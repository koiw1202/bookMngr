package com.bookMngr.bookCategory.repository;

import com.bookMngr.bookCategory.domain.BookCategoryRelation;
import com.bookMngr.bookCategory.domain.BookCategoryRelationPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : com.bookMngr.relation.bookCategory.repository
 * fileName       : BookCategoryRepo
 * author         : FIC08709
 * date           : 2023-11-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-20        FIC08709       최초 생성
 */
public interface BookCategoryRepository extends JpaRepository <BookCategoryRelation, BookCategoryRelationPK> {

}
