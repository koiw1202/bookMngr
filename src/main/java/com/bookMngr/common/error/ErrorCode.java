package com.bookMngr.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

     ACCESS_DENIED(403, "403", "접근권한이 없습니다.", "")
    ,EXIST_ID(409, "EC0001", "이미 존재하는 아이디입니다.", "아이디 중복")
    ,CATEGORY_ERROR_001(500, "EC0002", ErrorMessage.MSG_ERROR_001, "카테고리 생성 중 에러 발생")
    ,CATEGORY_ERROR_002(409, "EC0003", ErrorMessage.MSG_CATEGORY_ERROR_002, "이미 존재하는 카테고리명 생성")

    ,BOOK_ERROR_001(500, "EC0004", ErrorMessage.MSG_ERROR_001, "책과 카테고리 연결 중 에러 발생")
    ,BOOK_ERROR_002(500, "EC0005", ErrorMessage.MSG_ERROR_001, "책 등록 시 에러 발생")

    ,BOOK_ERROR_003(400, "EC0006", "책 이름은 필수입력 값 입니다.", "책 조회시 에러 발생")
    ,BOOK_ERROR_004(400, "EC0007", "책 제목은 필수입력 값 입니다.", "책 조회시 에러 발생")
    ,BOOK_ERROR_005(400, "EC0008", "저자는 필수입력 값 입니다.", "책 조회시 에러 발생")
    ,BOOK_ERROR_006(400, "EC0009", "카테고리는 필수입력 값 입니다.", "책 조회시 에러 발생")
    ,BOOK_ERROR_007(400, "EC0010", "존재하지 않는 조회 조건입니다.", "존재하지 않는 검색 조건(searchType) 입니다.")
    ,BOOK_ERROR_008(400, "EC0011", "존재하지 않는 책 입니다.", "책 ID가 존재하지 않는 조건입니다.")

    ,BOOK_CATEGORY_ERROR_001(500, "EC00010", ErrorMessage.MSG_ERROR_001, "책 - 카테고리 연관관계 변경 에러 발생")

    ;

    private Integer status ;
    private String code ;
    private String message ;
    private String internalMessage ;


}
