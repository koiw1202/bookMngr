package com.bookMngr.domain.book.domain;


import com.bookMngr.domain.bookCategory.domain.BookCategoryRelation;
import com.bookMngr.domain.store.domain.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
