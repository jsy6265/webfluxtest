package com.example.webfluxtest.domain.board.model.dto;

import com.example.webfluxtest.domain.board.model.Board;
import lombok.Builder;

@Builder
public class BoardDto {
    public String member_id;
    public String title;
    public String content;

    public Board toEntity() {
        return new Board(this.title, this.content);
    }
}
