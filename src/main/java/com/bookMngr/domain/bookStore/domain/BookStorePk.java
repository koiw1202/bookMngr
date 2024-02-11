package com.bookMngr.domain.bookStore.domain;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        koiw1       최초 생성
 */
@Embeddable
public class BookStorePk implements Serializable{

    private Long storeCd ;

    private Long bookCd ;

}
