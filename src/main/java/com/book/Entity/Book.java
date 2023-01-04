package com.book.Entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="book")
@Getter
@Setter
@ToString
public class Book {

    @Id
    @Column(name="book_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 책 코드

    @Column(nullable = false, name = "bookNm")
    private String bookNm; // 책명

    @Column(nullable = false, name = "price")
    private int price; //

    @Lob
    @Column(nullable = false, name="bookDetail")
    private String bookDetail; // 책 상세 내용

    @Column(nullable = false, name = "totalRate")
    private int totalRate; // 책평점

    @Enumerated(EnumType.STRING)
    private BookGenre bookGenre; // 책 장르

}
