package com.bookMngr.domain.bookCategory.service;

import com.bookMngr.domain.bookCategory.model.BookCategoryRelationDto;
import com.bookMngr.domain.bookCategory.repository.BookCategoryRepository;
import com.bookMngr.common.error.ErrorHandler;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static com.bookMngr.domain.bookCategory.domain.QBookCategoryRelation.bookCategoryRelation;

/**
 * packageName    : com.bookMngr.relation.bookCategory.service
 * fileName       : BookCategoryRelationService
 * author         : FIC08709
 * date           : 2023-11-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-20        FIC08709       최초 생성
 */

@Service
@AllArgsConstructor
public class BookCategoryRelationService {

    private final JPAQueryFactory jpaQueryFactory ;
    private final BookCategoryRepository bookCategoryRepo ;

    @Transactional(rollbackFor = {ErrorHandler.class, Exception.class}, propagation = Propagation.REQUIRED)
    public boolean updateBookCategoryRelation(BookCategoryRelationDto bookCategoryRelationDto) {

        long result = jpaQueryFactory.update(bookCategoryRelation)
                                    .set(bookCategoryRelation.bookCategoryRelationPK.category.categoryId, bookCategoryRelationDto.getCategoryId())
                                    .where(bookCategoryRelation.bookCategoryRelationPK.book.bookId.eq(bookCategoryRelationDto.getBookId()))
                                    .execute() ;

        if(result == 1)
            return true ;
        else
            return false ;

    }



}
