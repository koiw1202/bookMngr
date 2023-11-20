package com.bookMngr.book.domain;


import com.bookMngr.category.domain.Category;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
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

    public Book(long bookId) {
        this.bookId = bookId ;
    }

}
