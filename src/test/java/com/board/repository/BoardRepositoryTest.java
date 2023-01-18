package com.board.repository;

import java.util.List;
import com.board.entity.BoardDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    @DisplayName("게시물 저장 테스트")
    public void createItemTest(){
        BoardDTO board = new BoardDTO();
        board.setSubject("게시물 이름");
        board.setContent("게시물 내용");
        board.setReadCount(111);
        board.setName("게시자");
        board.setReg_date(LocalDateTime.now());
        BoardDTO savedBoard = boardRepository.save(board);
        System.out.println(savedBoard.toString());
    }

    public void createBoardList(){
        for(int i=1;i<=10;i++){
            BoardDTO board = new BoardDTO();
            board.setSubject("게시물 제목 "+i);
            board.setName("게시자 " +i);
            board.setContent("게시물 내용 "+i);
            board.setReg_date(LocalDateTime.now());
            board.setReadCount(i);
            BoardDTO savedBoard = boardRepository.save(board);
        }
    }


    @Test
    @DisplayName("제목 조회 테스트")
    public void findBySubjectTest(){
        this.createBoardList();
        List<BoardDTO> boardList = boardRepository.findBySubject("게시물 제목 4");
        for(BoardDTO board : boardList){
            System.out.println(board.toString());
        }
    }

    @Test
    @DisplayName("이름 조회 테스트")
    public void findByNameTest(){
        this.createBoardList();
        List<BoardDTO> boardList = boardRepository.findByName("게시자 4");
        for(BoardDTO board : boardList){
            System.out.println(board.toString());
        }
    }

    @Test
    @DisplayName("게시번호 조회 테스트")
    public void findBySeqTest(){
        this.createBoardList();
        List<BoardDTO> boardList = boardRepository.findBySeq(4);
        for(BoardDTO board : boardList){
            System.out.println(board.toString());
        }
    }
}