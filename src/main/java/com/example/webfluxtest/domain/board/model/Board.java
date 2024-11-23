package com.example.webfluxtest.domain.board.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("board")
@Getter
public class Board {
    @Id
    private Long id;
    private String title;
    private String content;
    @CreatedDate
    private LocalDateTime create_at;
    @LastModifiedDate
    private LocalDateTime update_at;

    public Board(String title, String content){
        this.title = title;
        this.content = content;
    }
}
