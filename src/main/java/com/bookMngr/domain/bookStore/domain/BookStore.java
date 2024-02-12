package com.bookMngr.domain.bookStore.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        koiw1       최초 생성
 */
@Entity
@Getter
@ToString
@Builder
@AllArgsConstructor
public class BookStore {

    @EmbeddedId
    private BookStorePk bookStorePk ;

    private Long quantity ;


    public BookStore() {

    }
}
