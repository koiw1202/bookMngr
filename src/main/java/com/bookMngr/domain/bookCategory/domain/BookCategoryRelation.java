package com.bookMngr.domain.bookCategory.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * packageName    : com.bookMngr.bookCategoryRelation.domain
 * fileName       : BookCategoryRelation
 * author         : FIC08709
 * date           : 2023-11-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-20        FIC08709       최초 생성
 */
@Entity
@Getter
@Builder
@AllArgsConstructor
public class BookCategoryRelation {

    @EmbeddedId
    private BookCategoryRelationPK bookCategoryRelationPK ;


    public BookCategoryRelation() {

    }
}
