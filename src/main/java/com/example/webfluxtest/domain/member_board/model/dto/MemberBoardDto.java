package com.example.webfluxtest.domain.member_board.model.dto;

import com.example.webfluxtest.domain.member.model.dto.MemberDto;
import com.example.webfluxtest.domain.member_board.model.MemberBoard;

public class MemberBoardDto {
    public String member_id;
    public Long board_id;

    public MemberBoardDto(String member_id, Long board_id){
        this.member_id = member_id;
        this.board_id = board_id;
    }

    public MemberBoard toEntity(){
        return new MemberBoard(this.member_id, this.board_id);
    }
}
