package com.example.webfluxtest.domain.board.service;

import com.example.webfluxtest.domain.board.model.dto.BoardDto;
import com.example.webfluxtest.domain.board.repository.BoardRepository;
import com.example.webfluxtest.domain.member_board.model.dto.MemberBoardDto;
import com.example.webfluxtest.domain.member_board.service.MemberBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberBoardService memberBoardService;
    public Mono<Void> createBoard(BoardDto boardDto, int delayTime) {
        return Mono.delay(Duration.ofSeconds(delayTime)) // 10초 비동기 지연
                .then(boardRepository.save(boardDto.toEntity())
                        .flatMap(board -> {
                            MemberBoardDto memberBoardDto = new MemberBoardDto(boardDto.member_id, board.getId());
                            return memberBoardService.createMemberBoard(memberBoardDto);
                        })
                ).then();
    }

    public Flux<BoardDto> getBoards(){
        return Mono.delay(Duration.ofSeconds(20)).thenMany(boardRepository.getBoards());
    }
}
