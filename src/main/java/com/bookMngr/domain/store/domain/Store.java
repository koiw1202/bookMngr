package com.bookMngr.domain.store.domain;

import com.bookMngr.domain.bookStore.domain.BookStore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

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
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeCd ;

    @Column(length = 255, nullable = false)
    private String storeNm ;

    @Column(length = 255, nullable = false)
    private String address ;

    @Column(precision=12, scale=9)
    private BigDecimal latitude ;

    @Column(precision=12, scale=9)
    private BigDecimal longitude ;



    @OneToMany(mappedBy = "bookStorePk.store", fetch = FetchType.LAZY)
    private List<BookStore> bookStores ;

}
