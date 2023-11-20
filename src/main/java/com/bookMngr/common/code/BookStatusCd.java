package com.bookMngr.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BookStatusCd {

     BOOK_STATUS_OK("01", "대여가능")
    ,BOOK_STATUS_DAMAGED("02", "훼손")
    ,BOOK_STATUS_LOST("03", "분실")
    ,BOOK_STATUS_RENT("04", "대여중")

    ;

    private String code ;
    private String name ;
}
