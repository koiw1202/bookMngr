package com.bookMngr.book.repository;

import com.bookMngr.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {

}
