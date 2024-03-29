package com.bookMngr.domain.bookCategory.service;

import com.bookMngr.common.error.ErrorHandler;
import com.bookMngr.domain.bookCategory.model.BookCategoryRelationDto;
import com.bookMngr.domain.bookCategory.repository.BookCategoryQueryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    private final BookCategoryQueryRepository bookCategoryQueryRepository ;

    @Transactional(rollbackFor = {ErrorHandler.class, Exception.class}, propagation = Propagation.REQUIRED)
    public boolean changeBookCategoryRelation(BookCategoryRelationDto bookCategoryRelationDto) {

        long result = bookCategoryQueryRepository.updateBookCategoryRelation(bookCategoryRelationDto) ;

        if(result == 1)
            return true ;
        else
            return false ;

    }



}
