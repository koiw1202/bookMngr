package com.bookMngr.domain.book.repository;

import com.bookMngr.domain.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
