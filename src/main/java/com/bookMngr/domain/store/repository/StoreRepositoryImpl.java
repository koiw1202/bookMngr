package com.bookMngr.domain.store.repository;

import com.bookMngr.domain.store.domain.Store;
import com.bookMngr.domain.store.model.StoreInfoDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.bookMngr.common.util.UtilFunction.calOffset;
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

    public static BooleanExpression eqStoreCd(final Long storeCd) {
        return storeCd != null ? store.storeCd.eq(storeCd) : null ;
    }

    public static BooleanExpression likeStoreNm(final String storeNm) {
        return hasText(storeNm) ? store.storeNm.like(String.join("", "%", storeNm, "%")) : null ;
    }

    public static BooleanExpression likeStoreAddress(final String storeAddress) {
        return hasText(storeAddress) ? store.address.like(String.join("", "%", storeAddress , "%")) : null ;
    }

    @Override
    public Long updateStore(Store storeToUpdate) {

        return jpaQueryFactory.update(store)
                .set(store.storeNm, storeToUpdate.getStoreNm())
                .where(eqStoreCd(storeToUpdate.getStoreCd()))
                .execute() ;
    }

    @Override
    public List<Store> selectStore(StoreInfoDto storeInfoDto) {

        return jpaQueryFactory.selectFrom(store)
                .where( eqStoreCd(storeInfoDto.getStoreCd())
                       ,likeStoreNm(storeInfoDto.getStoreNm())
                       ,likeStoreAddress(storeInfoDto.getStoreAddress())
                )
                .offset((calOffset(storeInfoDto.getPageNo(), storeInfoDto.getPageSize())))
                .limit(storeInfoDto.getPageSize())
                .fetch() ;

    }
}
