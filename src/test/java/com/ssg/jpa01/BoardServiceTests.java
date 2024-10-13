package com.ssg.jpa01;

import com.ssg.jpa01.dto.BoardDTO;
import com.ssg.jpa01.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Log4j2
public class BoardServiceTests {
    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister() {
        BoardDTO boardDTO = BoardDTO.builder()
                .title("test register")
                .writer("등록 테스터")
                .content("내용 등록이 되었을까?")
                .registerDate(LocalDateTime.now())
                .build();

        log.info("등록 테스트*******************************");
        boardService.register(boardDTO);
    }

    @Test
    public void testReadOne() {
        Long bno = 3L;
        BoardDTO boardDTO = boardService.readOne(bno);
        log.info("하나 읽어보기 테스트*****************" + boardDTO);
    }

    @Test
    public void testModify() {
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(3L)
                .title("수정이 될까요?")
                .content("나에게도 수정이란게 있다")
                .build();

        boardService.modify(boardDTO);
    }

    @Test
    public void testRemove() {
        Long bno = 2L;
        boardService.remove(bno);
    }

    @Test
    public void testList() {
        boardService.list();
    }
}
