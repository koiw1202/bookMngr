package com.example.category.repository;

import com.example.book.domain.Book;
import com.example.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
