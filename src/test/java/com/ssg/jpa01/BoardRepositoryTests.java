package com.ssg.jpa01;

import com.ssg.jpa01.domain.Board;
import com.ssg.jpa01.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert() {
        Board board = Board.builder()
                .title("test title")
                .content("test content")
                .registerDate(LocalDateTime.now())
                .writer("yeoun")
                .build();

        Board result = boardRepository.save(board);
        System.out.println(result);
    }

    @Test
    public void testSelectOne() {
        Long bno = 1L;

        Optional<Board> result = boardRepository.findById(bno);
        System.out.println("나와라.............." + result);
    }

    @Test
    public void testUpdate() {
        Board board = Board.builder()
                .bno(1L)
                .title("test update title")
                .content("test update content")
                .registerDate(LocalDateTime.now())
                .writer("yeoun update")
                .build();

        Board result = boardRepository.save(board);
        System.out.println("수정해라.........." + result);
    }
}
