package com.example.webfluxtest.domain.member.service;

import com.example.webfluxtest.domain.member.model.dto.MemberDto;
import com.example.webfluxtest.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Mono<Void> createMember(MemberDto memberDto){
        return memberRepository.saveMember(memberDto.id, memberDto.pass, memberDto.name).then();
    }
}
