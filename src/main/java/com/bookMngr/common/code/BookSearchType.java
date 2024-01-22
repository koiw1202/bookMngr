package com.bookMngr.common.code;

import com.bookMngr.common.error.ErrorCode;
import com.bookMngr.common.error.ErrorHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * packageName    : com.bookMngr.common.code
 * fileName       : SearchType
 * author         : FIC08709
 * date           : 2023-11-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-20        FIC08709       최초 생성
 */
@Getter
@AllArgsConstructor
public enum BookSearchType {

     BOOK_SERACH_ALL("00", "전체 조회")
    ,TITLE_NAME("01", "책 제목")
    ,WRITER_NAME("02", "지은이")
    ,CATEGORY_ID("03", "카테고리 코드")

    ;

    private String code ;
    private String name ;

    public static BookSearchType convertCodeToType(String code){
        try {
            return Arrays.asList(BookSearchType.values())
                    .stream()
                    .filter(t->t.code.equals(code))
                    .findAny()
                    .get();
        } catch (Exception e) {
          throw new ErrorHandler(ErrorCode.BOOK_ERROR_007) ;
        }
    }
}
