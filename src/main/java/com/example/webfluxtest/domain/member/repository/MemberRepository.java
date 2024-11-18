package com.example.webfluxtest.domain.member.repository;

import com.example.webfluxtest.domain.member.model.Member;
import com.example.webfluxtest.domain.member.model.dto.MemberDto;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MemberRepository extends ReactiveCrudRepository<Member, String> {
    @Query("INSERT INTO member (id, pass, name, create_at, update_at) VALUES (:id, :pass, :name, SYSDATE(), SYSDATE())")
    Mono<Void> saveMember(String id, String pass, String name);
}
