package com.example.demo.board.service;

import com.example.demo.board.dto.Board;

import java.util.List;
import java.util.Optional;


public interface BoardService {
   public List<Board> list(Board board) throws Exception;
   public Optional<Board> view(Board board) throws Exception;
   public long insert(Board board)  throws Exception;
   public int update(Board board)  throws Exception;
   public int delete(Board board)  throws Exception;
}
