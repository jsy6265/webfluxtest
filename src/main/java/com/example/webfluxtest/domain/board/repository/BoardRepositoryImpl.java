//package com.example.webfluxtest.domain.board.repository;
//
//import com.example.webfluxtest.domain.board.model.dto.BoardDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.r2dbc.core.DatabaseClient;
//import org.springframework.stereotype.Repository;
//import reactor.core.publisher.Flux;
//
//@Repository
//@RequiredArgsConstructor
//public class BoardRepositoryImpl implements BoardRepository{
//    private final DatabaseClient datebaseClient;
//
//    @Override
//    public Flux<BoardDto> getBoards() {
//        String query = """
//                    SELECT mb.member_id, b.title, b.content
//                    FROM board b
//                    JOIN member_board mb
//                    ON b.id = mb.board_id
//                    ORDER BY create_at
//                """;
//        return datebaseClient.sql(query)
//                .fetch()
//                .all()
//                .map(row -> BoardDto.builder()
//                        .member_id((String) row.get("member_id"))
//                        .title((String) row.get("title"))
//                        .content((String) row.get("content"))
//                        .build());
//    }
//}
