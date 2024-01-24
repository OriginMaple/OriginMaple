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
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired


    @Override
    public List<BoardEntity> getBoardListAll() {
        List<BoardEntity> boardEntity = boardRepository.findAll();

        return boardEntity;
    }



}
