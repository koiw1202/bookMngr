package com.bookMngr.common.util;

import java.lang.reflect.Field;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-05        koiw1       최초 생성
 */
public class UtilFunction {

    public static Integer calOffset(Integer pageNo, Integer pageSize) {
        return (pageNo - 1) * pageSize ;
    }

    public static void reflectionFields(Object obj, Object target) throws Exception {

        Field[] fieldArr = obj.getClass().getDeclaredFields() ;
        Field[] targetField = target.getClass().getDeclaredFields() ;

        for(Field i : targetField) {
            for(Field j : fieldArr) {

                if(j.getName().equals(i.getName())) {
                    i.setAccessible(true) ;
                    j.setAccessible(true) ;

                    i.set(target, j.get(obj)) ;
                }
            }
        }
    }
}
