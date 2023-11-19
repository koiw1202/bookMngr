package com.example.book.model;

import com.example.category.domain.Category;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@ToString
public class BookDto {

    @NonNull
    private String writer ;
    @NonNull
    private String title ;
    @NonNull
    private long categoryId ;

}
