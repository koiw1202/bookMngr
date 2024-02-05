package com.bookMngr.domain.book.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

import static com.bookMngr.common.constant.CCConst.PAGENO_NOTBLANK_MESSAGE;
import static com.bookMngr.common.constant.CCConst.PAGESIZE_NOTBLANK_MESSAGE;

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
public class BookInfoDto {

    @NotBlank(message = PAGENO_NOTBLANK_MESSAGE)
    @Schema(name = "pageNo", description = "1", example = "현재 페이지", required = true)
    private Integer pageNo ;

    @NotBlank(message = PAGESIZE_NOTBLANK_MESSAGE)
    @Schema(name = "pageSize", description = "10", example = "페이지 사이즈", required = true)
    private Integer pageSize ;

    @NotBlank
    @Schema(name = "searchType", description = "조회 조건", example = "00 : 전체 // 01 : 책 제목 // 02 : 지은이 // 03 : 카테고리", required = true)
    private String searchType ;

    @Schema(name = "writer", description = "작가", example = "김성훈", required = false)
    private String writer ;

    @Schema(name = "title", description = "책 제목", example = "JPA 기본 강의", required = false)
    private String title ;

    @Schema(name = "categoryId", description = "책 카테고리", example = "1", required = false)
    private Long categoryId ;

}

