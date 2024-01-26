package com.maple.originmapleapp.service.impl;

import com.maple.originmapleapp.dto.BoardDto;
import com.maple.originmapleapp.entity.BoardEntity;
import com.maple.originmapleapp.exception.exceptionList.CustomApiException;
import com.maple.originmapleapp.repository.BoardRepository;
import com.maple.originmapleapp.service.BoardService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }


    @Override
    public List<BoardEntity> getBoardListAll() {
        List<BoardEntity> boardEntity = boardRepository.findAll();

        return boardEntity;
    }

    @Override
    public BoardEntity boardInsert(BoardEntity boardEntity) {

        BoardEntity insertBoard = boardRepository.save(boardEntity);

        return insertBoard;
    }


}
