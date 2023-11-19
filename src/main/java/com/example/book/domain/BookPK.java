package com.example.book.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookPK implements Serializable {

    @GeneratedValue
    @Column(name = "BOOK_ID")
    private long bookId ;

    @Column(name = "CATEGORY_ID", nullable = false)
    private long categoryId ;
}
