package com.bookMngr.bookCategory.service;

import com.bookMngr.book.domain.Book;
import com.bookMngr.bookCategory.model.BookCategoryRelationDto;
import com.bookMngr.category.domain.Category;
import com.bookMngr.bookCategory.repository.BookCategoryRepo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.bookMngr.bookCategory.domain.QBookCategoryRelation.bookCategoryRelation;

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
    private final BookCategoryRepo bookCategoryRepo ;

    @Transactional
    public boolean updateBookCategoryRelation(BookCategoryRelationDto bookCategoryRelationDto) {

        Book book = new Book(bookCategoryRelationDto.getBookId()) ;
        Category category = new Category(bookCategoryRelationDto.getCategoryId()) ;

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
