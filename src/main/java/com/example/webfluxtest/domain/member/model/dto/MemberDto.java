package com.example.webfluxtest.domain.member.model.dto;

import com.example.webfluxtest.domain.member.model.Member;

public class MemberDto {
    public String id;
    public String pass;
    public String name;

    public Member toEntity(){
        return new Member(this.id, this.pass, this.name);
    }
}
