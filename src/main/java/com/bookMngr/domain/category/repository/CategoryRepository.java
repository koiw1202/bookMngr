package com.bookMngr.domain.category.repository;

import com.bookMngr.domain.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>, CategoryRepositoryCustom {

}
