package com.example.webfluxtest.domain.member.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("member")
public class Member {
    @Id
    private String id;
    private String pass;
    private String name;
    @CreatedDate
    private LocalDateTime create_at;
    @LastModifiedDate
    private LocalDateTime update_at;

    public Member(String id, String pass, String name){
        this.id = id;
        this.pass = pass;
        this.name = name;
    }
}
