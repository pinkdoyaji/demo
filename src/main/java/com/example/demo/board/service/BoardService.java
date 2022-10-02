package com.example.demo.board.service;

import com.example.demo.board.dto.Board;

import java.util.List;
import java.util.Optional;


public interface BoardService {
   public List<Board> list(Board board);
   public Optional<Board> view(Board board);
   public long insert(Board board);
   public int update(Board board);
   public int delete(Board board);
}
