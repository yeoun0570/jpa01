package com.ssg.jpa01.service;

import com.ssg.jpa01.dto.BoardDTO;

public interface BoardService {
    void register (BoardDTO boardDTO);

    BoardDTO readOne(Long bno);

    void modify(Long bno);

    void  remove(Long bno);

}
