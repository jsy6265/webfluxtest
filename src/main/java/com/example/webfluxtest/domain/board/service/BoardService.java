package com.example.webfluxtest.domain.board.service;

import com.example.webfluxtest.domain.board.model.dto.BoardDto;
import com.example.webfluxtest.domain.board.repository.BoardRepository;
import com.example.webfluxtest.domain.member_board.model.dto.MemberBoardDto;
import com.example.webfluxtest.domain.member_board.service.MemberBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberBoardService memberBoardService;
    public Mono<Void> createBoard(BoardDto boardDto, String member_id) {
        return boardRepository.save(boardDto.toEntity()).flatMap(
                board -> {
                    MemberBoardDto memberBoardDto = new MemberBoardDto(member_id, board.getId());
                    return memberBoardService.createMemberBoard(memberBoardDto);
                }
        ).then();
    }
}
