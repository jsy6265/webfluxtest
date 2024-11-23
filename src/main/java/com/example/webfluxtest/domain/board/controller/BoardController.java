package com.example.webfluxtest.domain.board.controller;

import com.example.webfluxtest.domain.board.model.dto.BoardDto;
import com.example.webfluxtest.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public Mono<ResponseEntity<Void>> createBoard(@RequestBody Mono<BoardDto> boardDtoMono){
       return boardDtoMono.flatMap(boardService::createBoard)
                .then(Mono.just(ResponseEntity.ok().build()));
    }
}
