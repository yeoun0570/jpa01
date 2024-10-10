package com.ssg.jpa01.service;

import com.ssg.jpa01.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class BoardServiceImpl implements BoardService{

    @Override
    public void register(BoardDTO boardDTO) {

    }

    @Override
    public BoardDTO readOne(Long bno) {
        return null;
    }

    @Override
    public void modify(Long bno) {

    }

    @Override
    public void remove(Long bno) {

    }
}
