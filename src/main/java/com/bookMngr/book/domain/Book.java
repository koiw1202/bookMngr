package com.bookMngr.book.domain;


import com.bookMngr.bookCategory.domain.BookCategoryRelation;
import com.bookMngr.category.domain.Category;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id @GeneratedValue
    @Column(name = "BOOK_ID")
    private long bookId ;

    @Column(name = "WRITER", length = 30, nullable = false )
    private String writer ;

    @Column(name = "TITLE", length = 100, nullable = false)
    private String title ;

    @Column(name = "BOOK_STATUS", length = 2, nullable = false)
    private String bookStatus ;

    @OneToMany(mappedBy = "bookCategoryRelationPK.book", fetch = FetchType.LAZY)
    private List<BookCategoryRelation> bookCategoryRelation ;

    public Book(long bookId) {

        this.bookId = bookId ;
    }

}
