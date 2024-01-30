package com.bookMngr.domain.store.repository;

import com.bookMngr.domain.store.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-30        koiw1       최초 생성
 */
public interface StoreRepository extends JpaRepository<Store, Long> {

}
