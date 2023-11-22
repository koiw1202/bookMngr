package com.bookMngr.category.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private long categoryId ;

    @Column(nullable = false, length = 30)
    private String categoryNm ;

    public Category(long categoryId) {
        this.categoryId = categoryId ;
    }



}
