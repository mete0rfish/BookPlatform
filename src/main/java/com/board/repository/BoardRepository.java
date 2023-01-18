package com.board.repository;

import com.board.entity.BoardDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardDTO, Integer> {

    List<BoardDTO> findBySubject(String subject);
    List<BoardDTO> findByName(String name);
    List<BoardDTO> findBySeq(Integer seq);

}
