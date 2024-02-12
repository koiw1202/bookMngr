package com.bookMngr.domain.bookStore.domain;

import com.bookMngr.domain.book.domain.Book;
import com.bookMngr.domain.store.domain.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-12        koiw1       최초 생성
 */
@Embeddable
@Builder
@AllArgsConstructor
@Getter
public class BookStorePk implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STORE_CD")
    private Store store ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_ID")
    private Book book ;


    public BookStorePk() {

    }
}
