package com.bookMngr.book.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * packageName    : com.bookMngr.book.model
 * fileName       : SelectBookDto
 * author         : FIC08709
 * date           : 2023-11-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-20        FIC08709       최초 생성
 */

@Getter
@Builder
public class SelectBookDto {

    @NonNull
    @Schema(name = "pageNo", description = "1", example = "현재 페이지", required = true)
    private Integer pageNo ;

    @NonNull
    @Schema(name = "pageSize", description = "10", example = "페이지 사이즈", required = true)
    private Integer pageSize ;

    @NonNull
//    BOOK_SERACH_ALL("00", "전체 조회")
//    ,TITLE_NAME("01", "책 제목")
//    ,WRITER_NAME("02", "지은이")
//    ,CATEGORY_ID("03", "카테고리 코드")
    @Schema(name = "searchType", description = "조회 조건", example = "00 : 전체 // 01 : 책 제목 // 02 : 지은이 // 03 : 카테고리", required = true)
    private String searchType ;

    @Schema(name = "writer", description = "작가", example = "김성훈", required = false)
    private String writer ;

    @Schema(name = "title", description = "책 제목", example = "JPA 기본 강의", required = false)
    private String title ;

    @Schema(name = "categoryId", description = "책 카테고리", example = "1", required = false)
    private Long categoryId ;

}

