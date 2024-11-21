package com.example.webfluxtest.domain.member_board.repository;

import com.example.webfluxtest.domain.member_board.model.MemberBoard;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberBoardRepository extends R2dbcRepository<MemberBoard, Long> {
}
