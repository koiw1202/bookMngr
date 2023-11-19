package com.example.category.domain;

import com.example.book.domain.Book;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private long categoryId ;

    @Column(nullable = false, length = 30)
    private String categoryNm ;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "categoryId")
//    private Book book = new Book() ;

}
