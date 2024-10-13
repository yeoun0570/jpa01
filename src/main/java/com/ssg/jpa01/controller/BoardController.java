package com.ssg.jpa01.controller;

import com.ssg.jpa01.dto.BoardDTO;
import com.ssg.jpa01.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/register")
    public void registerBoard(@RequestBody BoardDTO boardDTO) {
        boardService.register(boardDTO);
    }

    @PostMapping("/modify")
    public void modifyBoard(@RequestBody BoardDTO boardDTO) {
        boardService.modify(boardDTO);
    }

    @PostMapping("/remove")
    public void removeBoard(@RequestBody Long bno) {
        boardService.remove(bno);
    }

    @GetMapping("/read")
    public String readOneBoard(@RequestParam Long bno, Model model) {
        log.info("Requested bno: " + bno);
        BoardDTO response = boardService.readOne(bno);
        log.info("Retrieved board: " + response);
        model.addAttribute("board", response);
        return "board/read";
    }
    @GetMapping("/list")
    public void listBoard() {
        boardService.list();
    }

}
