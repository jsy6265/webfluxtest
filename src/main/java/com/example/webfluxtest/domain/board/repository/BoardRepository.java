package com.example.webfluxtest.domain.board.repository;

import com.example.webfluxtest.domain.board.model.Board;
import com.example.webfluxtest.domain.board.model.dto.BoardDto;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BoardRepository extends ReactiveCrudRepository<Board, Long> {
    @Query("""
            SELECT mb.member_id, b.title, b.content
            FROM board b
            JOIN member_board mb
            ON b.id = mb.board_id
            ORDER BY create_at
           """)
    Flux<BoardDto> getBoards();
}
