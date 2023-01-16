package com.board.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="board")
@Getter
@Setter
@ToString
public class BoardDTO {
    @Id
    @Column(name="seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer seq;

    @Column(nullable = false, length =100)
    String subject;

    @Lob
    @Column(nullable=false, length = 300)
    String content;

    @Column(nullable = false, length=10)
    String name;

    LocalDateTime reg_date;
    int readCount;
}
