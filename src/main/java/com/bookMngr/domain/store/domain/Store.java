package com.bookMngr.domain.store.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-22        koiw1       최초 생성
 */
@Entity
@Builder
@Getter
@AllArgsConstructor
public class Store {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long storeCd ;

    @Column(length = 255, nullable = false)
    private String storeNm ;

    @Column(length = 255, nullable = false)
    private String address ;

    private long latitude ;

    private long longitude ;

    public Store() {

    }

}
