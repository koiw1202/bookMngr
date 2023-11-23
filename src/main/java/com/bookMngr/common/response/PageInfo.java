package com.bookMngr.common.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Getter
@Builder
@ToString
public class PageInfo<T> {

    private Integer pageNo ;
    private Integer pageSize ;
    private long totalCnt ;
    private List<T> content ;

}
