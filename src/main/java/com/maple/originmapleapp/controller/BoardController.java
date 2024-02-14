package com.maple.originmapleapp.controller;

import com.maple.originmapleapp.dto.BoardDto;
import com.maple.originmapleapp.dto.response.DefaultResponse;
import com.maple.originmapleapp.entity.BoardEntity;
import com.maple.originmapleapp.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // View
    @GetMapping({"/","/board/list"})
    public String board(){
        return"board/boardList";
    }

    // process
    @PostMapping("/list.process")
    public ResponseEntity<DefaultResponse<Object>> boardList() throws Exception{
        List<BoardEntity> getBoardListAll = boardService.getBoardListAll();
        System.out.println("나실행함?");
        return new ResponseEntity<>(new DefaultResponse<>(1, "성공", getBoardListAll),HttpStatus.OK);
    }

    @PostMapping("/board/insert")
    public ResponseEntity<DefaultResponse<Object>> boardInsert(@RequestBody BoardDto boardDto) throws Exception{

        BoardEntity data = boardDto.toEntity(boardDto);
        BoardEntity boardInsert = boardService.boardInsert(data);
        System.out.println("나실행함?");
        return new ResponseEntity<>(new DefaultResponse<>(1 , "성공", boardInsert),HttpStatus.OK);
    }

    @GetMapping("/board/registerPage")
    public String registerPage(){
        return"board/register/registerPage";
    }

    @GetMapping("/board/registerDetail")
    public String registerDetail(){
        return"board/register/registerDetail";
    }

}
