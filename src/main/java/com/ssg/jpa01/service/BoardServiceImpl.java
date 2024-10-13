package com.ssg.jpa01.service;

import com.ssg.jpa01.domain.Board;
import com.ssg.jpa01.dto.BoardDTO;
import com.ssg.jpa01.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;

    @Override
    public void register(BoardDTO boardDTO) {
        Board board = modelMapper.map(boardDTO, Board.class);

        boardRepository.save(board);
    }

    @Override
    public void list() {
        boardRepository.findAll();
    }

    @Override
    public BoardDTO readOne(Long bno) {
        Optional<Board> board = boardRepository.findById(bno);
        board.orElseThrow();
        BoardDTO boardDTO = modelMapper.map(board, BoardDTO.class);
        return boardDTO;
    }

    @Override
    public void modify(BoardDTO boardDTO) {
        Optional<Board> result = boardRepository.findById(boardDTO.getBno());
        //DTO에서 찾은 ID를 VO에 적용
        Board board = result.orElseThrow(); //orElseThrow() : Optional 인자가 null일 경우 예외 발생시킴
        
        //DTO에서 받은 값을 수정
        board.change(boardDTO.getTitle(), boardDTO.getContent());
        boardRepository.save(board);
    }

    @Override
    public void remove(Long bno) {
        boardRepository.deleteById(bno);
    }
}
