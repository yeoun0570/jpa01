package com.ssg.jpa01;

import com.ssg.jpa01.controller.BoardController;
import com.ssg.jpa01.dto.BoardDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@SpringBootTest
@Log4j2
public class BoardControllerTests {

    @Autowired
    private BoardController boardController;

    @Test
    public void registerBoardTest() {
        BoardDTO boardDTO = BoardDTO.builder()
                .writer("신가영")
                .content("신가영 바보")
                .title("신가영 멍청이")
                .registerDate(LocalDateTime.now())
                .build();

        boardController.registerBoard(boardDTO);
    }

    @Test
    public void modifyBoardTest() {
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(5L)
                .writer("신가영")
                .content("신가영 천재")
                .title("신가영 똑똑행")
                .registerDate(LocalDateTime.now())
                .build();

        boardController.registerBoard(boardDTO);
    }

    @Test
    public void removeBoardTest() {
        Long bno = 5L;
        boardController.removeBoard(bno);
    }

}
