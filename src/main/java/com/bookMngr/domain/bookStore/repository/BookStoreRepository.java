package com.bookMngr.domain.bookStore.repository;

import com.bookMngr.domain.bookStore.domain.BookStore;
import com.bookMngr.domain.bookStore.domain.BookStorePk;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        koiw1       최초 생성
 */
public interface BookStoreRepository extends JpaRepository<BookStore, BookStorePk> {

}
