package com.bookMngr.bookCategory.domain;

import com.bookMngr.book.domain.Book;
import com.bookMngr.category.domain.Category;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * packageName    : com.bookMngr.bookCategoryRelation.domain
 * fileName       : BookCategoryRelationPK
 * author         : FIC08709
 * date           : 2023-11-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-20        FIC08709       최초 생성
 */
@Embeddable
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookCategoryRelationPK implements Serializable {

    @OneToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book ;

    @OneToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category ;

}
