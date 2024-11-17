package com.example.webfluxtest.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/dontworking")
public class TestController {
    @GetMapping("/getTestData")
    public Mono<? extends ResponseEntity<?>> getTestData() {
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body("TEST DATA"));
    }
}
