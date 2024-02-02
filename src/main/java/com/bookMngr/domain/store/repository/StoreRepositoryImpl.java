package com.bookMngr.domain.store.repository;

import com.bookMngr.domain.store.domain.Store;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;

import static com.bookMngr.domain.store.domain.QStore.store;
import static org.springframework.util.StringUtils.hasText;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-30        koiw1       최초 생성
 */
@Slf4j
public class StoreRepositoryImpl implements StoreRepsitoryCustom {

    private final JPAQueryFactory jpaQueryFactory ;

    public StoreRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    private BooleanExpression storeCdEq(final Long storeCd) {
        return hasText(String.valueOf(storeCd)) ? store.storeCd.eq(storeCd) : null ;
    }

    @Override
    public Long updateStore(Store store2) {

        jpaQueryFactory.update(store)
                .set(store.storeNm, store2.getStoreNm())
                .where(storeCdEq(store2.getStoreCd()))
                .execute() ;

        return null;
    }
}
