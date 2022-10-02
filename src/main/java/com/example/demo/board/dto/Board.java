package com.example.demo.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    private Long boardId;   // 게시판 번혼
    private String title;   // 제목
    private String content; // 내용

}
