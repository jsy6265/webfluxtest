package com.example.webfluxtest.domain.board.model.dto;

import com.example.webfluxtest.domain.board.model.Board;

public class BoardDto {
    public String title;
    public String content;

    public Board toEntity() {
        return new Board(this.title, this.content);
    }
}
