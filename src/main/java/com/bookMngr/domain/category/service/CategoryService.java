package com.bookMngr.domain.category.service;

import com.bookMngr.common.error.ErrorCode;
import com.bookMngr.common.error.ErrorHandler;
import com.bookMngr.domain.category.domain.Category;
import com.bookMngr.domain.category.model.CategoryDto;
import com.bookMngr.domain.category.repository.CategoryQueryRepository;
import com.bookMngr.domain.category.repository.CategoryRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CategoryService {

    private final JPAQueryFactory jpaQueryFactory ;
    private final CategoryRepository categoryRepo ;
    private final CategoryQueryRepository categoryQueryRepository ;

    public CategoryService(JPAQueryFactory jpaQueryFactory, CategoryRepository categoryRepo, CategoryQueryRepository categoryQueryRepository) {
        this.jpaQueryFactory = jpaQueryFactory;
        this.categoryRepo = categoryRepo;
        this.categoryQueryRepository = categoryQueryRepository;
    }

    @Transactional(rollbackFor = {ErrorHandler.class, Exception.class}, propagation = Propagation.REQUIRED)
    public boolean insertCategory(final CategoryDto categoryDto) {
        CategoryDto categoryExist = categoryQueryRepository.selectSingleCategory(categoryDto) ;

            Optional.ofNullable(categoryExist)
                .ifPresentOrElse(vo -> {
                    throw new ErrorHandler(ErrorCode.CATEGORY_ERROR_002) ;
                }, () -> {
                    try {
                        categoryRepo.save(
                                Category.builder()
                                        .categoryNm(categoryDto.getCategoryNm())
                                        .build()
                        ) ;
                    } catch(Exception e) {
                        throw new ErrorHandler(ErrorCode.BOOK_ERROR_002, e.getMessage()) ;
                    }
                });

        return true ;
    }

}
