package com.example.webfluxtest.domain.board.controller;

import com.example.webfluxtest.domain.board.model.dto.BoardDto;
import com.example.webfluxtest.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public Mono<ResponseEntity<Void>> createBoard(@RequestParam int delayTime, @RequestBody Mono<BoardDto> boardDtoMono) {
       return boardDtoMono.flatMap(boardDto -> boardService.createBoard(boardDto, delayTime))
                .then(Mono.just(ResponseEntity.ok().build()));
    }

    @GetMapping("/list")
    public Flux<BoardDto> getBoardList(){
        return boardService.getBoards();
    }
}
