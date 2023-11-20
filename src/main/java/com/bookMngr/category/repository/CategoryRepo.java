package com.bookMngr.category.repository;

import com.bookMngr.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
