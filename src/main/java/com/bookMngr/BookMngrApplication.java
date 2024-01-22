package com.bookMngr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class BookMngrApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMngrApplication.class, args);
    }

}
