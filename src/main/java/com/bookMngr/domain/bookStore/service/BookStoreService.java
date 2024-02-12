package com.bookMngr.domain.bookStore.service;

import com.bookMngr.domain.bookStore.model.dto.BookStoreDtoForInsertion;
import com.bookMngr.domain.bookStore.service.dto.BookStoreQuantityInfoDto;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        koiw1       최초 생성
 */
public interface BookStoreService {

    BookStoreQuantityInfoDto getBookStoreQuantityInfo(final Long storeId) ;
    Integer insertBookStoreQuantityInfo(final BookStoreDtoForInsertion bookStoreDtoForInsertion) ;

}
