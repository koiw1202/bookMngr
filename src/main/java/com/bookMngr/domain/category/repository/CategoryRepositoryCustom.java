package com.bookMngr.domain.category.repository;

import com.bookMngr.domain.category.model.CategoryDto;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-28        koiw1       최초 생성
 */
public interface CategoryRepositoryCustom {

    public CategoryDto getSingleCategory(CategoryDto categoryDto) ;

}
