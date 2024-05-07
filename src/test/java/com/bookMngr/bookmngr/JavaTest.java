package com.bookMngr.bookmngr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.concurrent.CompletableFuture;

@SpringBootTest
@ActiveProfiles("local")
public class JavaTest {

    @Test
    public void inheritableThreadTest() {

        ThreadLocal<String> threadLocal = new InheritableThreadLocal() ;
        ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal() ;

        threadLocal.set("threadLocal TEST") ;
        inheritableThreadLocal.set("inheritableThreadLocal TEST") ;

        CompletableFuture.runAsync(() -> {
            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());
        }) ;
        
    }
}
