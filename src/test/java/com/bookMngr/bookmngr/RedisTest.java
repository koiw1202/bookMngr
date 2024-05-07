package com.bookMngr.bookmngr;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ActiveProfiles;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-24        koiw1       최초 생성
 */
@SpringBootTest
@ActiveProfiles("local")
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate ;

    @Test
    public void redisTest() {
        ValueOperations<String, String> value = redisTemplate.opsForValue() ;

        System.out.println(value.get("TEST")) ;

    }






}
