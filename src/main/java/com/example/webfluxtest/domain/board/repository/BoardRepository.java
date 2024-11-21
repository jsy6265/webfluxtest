package com.example.webfluxtest.domain.board.repository;

import com.example.webfluxtest.domain.board.model.Board;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends R2dbcRepository<Board, Long> {
}
