package com.bookMngr.domain.bookStore.repository;

import com.bookMngr.domain.bookStore.domain.BookStore;

import java.util.List;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        koiw1       최초 생성
 */
public interface BookStoreCustom {

    List<BookStore> getBookStoreInfoByStoreCd(Long StoreCd) ;

}
