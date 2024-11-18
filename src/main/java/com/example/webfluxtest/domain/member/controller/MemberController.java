package com.example.webfluxtest.domain.member.controller;

import com.example.webfluxtest.domain.member.model.dto.MemberDto;
import com.example.webfluxtest.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @PostMapping
    public Mono<ResponseEntity<Void>> createMember(@RequestBody Mono<MemberDto> memberDto){
        return memberDto.flatMap(memberService::createMember)
                .then(Mono.just(ResponseEntity.ok().build()));
    }
}
