package com.bookMngr.domain.bookStore.service;

import com.bookMngr.common.constant.CCConst;
import com.bookMngr.common.error.ErrorCode;
import com.bookMngr.common.error.ErrorHandler;
import com.bookMngr.domain.book.domain.Book;
import com.bookMngr.domain.bookStore.domain.BookStore;
import com.bookMngr.domain.bookStore.domain.BookStorePk;
import com.bookMngr.domain.bookStore.model.dto.BookStoreDtoForInsertion;
import com.bookMngr.domain.bookStore.repository.BookStoreRepository;
import com.bookMngr.domain.bookStore.service.dto.BookInfoDto;
import com.bookMngr.domain.bookStore.service.dto.BookStoreQuantityInfoDto;
import com.bookMngr.domain.store.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        koiw1       최초 생성
 */
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = {Exception.class, ErrorHandler.class})
public class BookStoreServiceImpl implements BookStoreService{

    private final BookStoreRepository bookStoreRepository ;

    @Override
    public BookStoreQuantityInfoDto getBookStoreQuantityInfo(Long storeCd) {

        List<BookStore> bookStores = bookStoreRepository.getBookStoreInfoByStoreCd(storeCd) ;

        Optional.ofNullable(bookStores)
                .filter(bookStore -> bookStore.size() > 0)
                .orElseThrow(() -> new ErrorHandler(CCConst.SELECT_FAIL, CCConst.FAIL_CODE)) ;

        BookStore bookStore = bookStores.get(0) ;
        Store store = bookStore.getBookStorePk().getStore() ;

        BookStoreQuantityInfoDto bookStoreQuantityInfoDto = BookStoreQuantityInfoDto.builder()
                .storeCd(store.getStoreCd())
                .storeNm(store.getStoreNm())
                .address(store.getAddress())
                .latitude(store.getLatitude())
                .longitude(store.getLongitude())
                .bookQuantity(bookStore.getQuantity())
                .bookInfoDtos(this.makeBookInfoDto(bookStores))
                .build() ;

        return bookStoreQuantityInfoDto ;
    }

    private List<BookInfoDto> makeBookInfoDto(List<BookStore> bookStores) {
        return bookStores.stream()
                .map(bookStore -> bookStore.getBookStorePk().getBook())
                .map(book -> BookInfoDto.builder()
                        .writer(book.getWriter())
                        .title(book.getTitle())
                        .bookId(book.getBookId())
                        .build()
                ).toList() ;
    }

    @Override
    public Integer insertBookStoreQuantityInfo(BookStoreDtoForInsertion bookStoreDtoForInsertion) {

        Store store = Store.builder()
                        .storeCd(bookStoreDtoForInsertion.getStoreCd())
                        .build() ;

        Book book = Book.builder()
                        .bookId(bookStoreDtoForInsertion.getBookId())
                        .build() ;

        BookStore bookStore = BookStore.builder()
                .bookStorePk(BookStorePk.builder()
                        .book(book)
                        .store(store)
                        .build())
                .quantity(bookStoreDtoForInsertion.getQuantity())
                .build() ;

        return Optional.of(bookStoreRepository.save(bookStore))
                .map(v -> CCConst.OK_CODE_FOR_CUD)
                .orElseThrow(() -> new ErrorHandler(ErrorCode.STORE_ERROR_005)) ;
    }



}
