package com.bookMngr.domain.bookStore.repository;

import com.bookMngr.domain.bookStore.domain.BookStore;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.bookMngr.domain.book.domain.QBook.book;
import static com.bookMngr.domain.bookStore.domain.QBookStore.bookStore;
import static com.bookMngr.domain.bookStore.domain.QBookStorePk.bookStorePk;
import static com.bookMngr.domain.store.domain.QStore.store;


/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        koiw1       최초 생성
 */
@RequiredArgsConstructor
public class BookStoreCustomImpl implements BookStoreCustom{

    private final JPAQueryFactory jpaQueryFactory ;

    public static BooleanExpression eqStoreCdInBookStore(final Long storeCd) {
        return storeCd == null ? null : bookStore.bookStorePk.store.storeCd.eq(storeCd) ;
    }

    public static BooleanExpression eqBookCdInBookStore(final Long bookId) {
        return bookId == null ? null : bookStorePk.book.bookId.eq(bookId) ;
    }

    @Override
    public List<BookStore> getBookStoreInfoByStoreCd(final Long storeCd) {

        List<BookStore> bookStores = jpaQueryFactory.select(bookStore)
                .from(bookStore)

                .join(store)
                .on(store.storeCd.eq(storeCd))

                .join(book)
                .on(book.bookId.eq(bookStore.bookStorePk.book.bookId))

                .where(eqStoreCdInBookStore(storeCd))
                .fetch() ;

        return bookStores ;
    }
}









