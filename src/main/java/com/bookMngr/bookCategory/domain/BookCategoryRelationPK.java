package com.bookMngr.bookCategory.domain;

import com.bookMngr.book.domain.Book;
import com.bookMngr.category.domain.Category;
import lombok.*;
import org.hibernate.annotations.Fetch;

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
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookCategoryRelationPK implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_ID")
    private Book book ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category ;

}
