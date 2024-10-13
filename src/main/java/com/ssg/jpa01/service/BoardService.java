package com.ssg.jpa01.service;

import com.ssg.jpa01.domain.Board;
import com.ssg.jpa01.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    void register (BoardDTO boardDTO);

    void list();

    BoardDTO readOne(Long bno);

    void modify(BoardDTO boardDTO);

    void  remove(Long bno);

}
