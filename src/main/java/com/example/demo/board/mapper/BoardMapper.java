package com.example.demo.board.mapper;

import com.example.demo.board.dto.Board;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Component
public interface BoardMapper {
    List<Board> selectList(Board board) throws Exception;
}
