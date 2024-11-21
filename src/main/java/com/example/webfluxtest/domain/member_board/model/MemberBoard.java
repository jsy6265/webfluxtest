package com.example.webfluxtest.domain.member_board.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("member_board")
@Getter
public class MemberBoard {
    @Id
    private Long id;
    private String member_id;
    private Long board_id;

    public MemberBoard(String member_id, Long board_id){
        this.member_id = member_id;
        this.board_id = board_id;
    }
}
