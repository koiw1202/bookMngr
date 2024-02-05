package com.bookMngr.common.util;

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

}
