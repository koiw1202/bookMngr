package com.bookMngr.bookCategory.domain;

import lombok.*;

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
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookCategoryRelation {

    @EmbeddedId
    private BookCategoryRelationPK bookCategoryRelationPK ;



}
