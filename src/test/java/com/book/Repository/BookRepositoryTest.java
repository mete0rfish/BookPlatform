package com.book.Repository;

import com.book.Entity.Book;
import com.book.Entity.BookGenre;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @DisplayName("책 저장 테스트")
    public void createBookTest(){
        Book book = new Book();
        book.setBookNm("책1");
        book.setPrice(10000);
        book.setBookDetail("책1 상세 설명");
        book.setBookGenre(BookGenre.Fantasy);
        book.setTotalRate(100);
        Book savedBook = bookRepository.save(book);
        System.out.println(savedBook.toString());
    }
}