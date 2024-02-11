package com.bookMngr.domain.bookStore.domain;

import lombok.NoArgsConstructor;

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
public class BookStore {

    @EmbeddedId
    private BookStorePk bookStore ;

    private Long quantity ;

}
