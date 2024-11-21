package com.example.webfluxtest.domain.member_board.service;

import com.example.webfluxtest.domain.member_board.model.MemberBoard;
import com.example.webfluxtest.domain.member_board.model.dto.MemberBoardDto;
import com.example.webfluxtest.domain.member_board.repository.MemberBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MemberBoardService {
    private final MemberBoardRepository memberBoardRepository;

    public Mono<Void> createMemberBoard(MemberBoardDto memberBoardDto){
        return memberBoardRepository.save(memberBoardDto.toEntity()).then();
    }
}
