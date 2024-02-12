package com.bookMngr.domain.bookStore.repository;

import com.bookMngr.domain.bookStore.domain.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        koiw1       최초 생성
 */
@Transactional(readOnly = true)
public interface BookStoreRepository extends JpaRepository<BookStore, Long>, BookStoreCustom {


}
