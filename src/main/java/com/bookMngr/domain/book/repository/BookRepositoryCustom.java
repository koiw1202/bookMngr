package com.bookMngr.domain.book.repository;

import com.bookMngr.domain.book.model.BookInfoDto;
import com.bookMngr.domain.book.model.UpdateBookStatusDto;
import com.bookMngr.domain.book.model.response.SelectBookResultDto;

import java.util.List;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-28        koiw1       최초 생성
 */
public interface BookRepositoryCustom {

    public List<SelectBookResultDto> selectBookInfo(BookInfoDto bookInfoDto) ;

    public long updateBookStatus(UpdateBookStatusDto updateBookStatusDto) ;



}
