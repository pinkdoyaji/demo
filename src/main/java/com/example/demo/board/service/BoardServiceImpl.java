package com.example.demo.board.service;

import com.example.demo.board.dto.Board;
import com.example.demo.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class BoardServiceImpl implements BoardService{

    private BoardMapper boardMapper;

    @Autowired
    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public List<Board> list(Board board) throws Exception {
        return boardMapper.selectList(board);
    }

    @Override
    public Optional<Board> view(Board board) throws Exception {
        // HashMap의 values()는,
        // 해당 map의 value 목록을 Collection 형태로 리턴합니다.
        //return store.values().stream().filter(result -> result.getBoardId().equals(board.getBoardId())).findAny();
        return null;
    }

    @Override
    public long insert(Board board) throws Exception{
        //board.setBoardId(++sequence);
        //store.put(board.getBoardId(), board);
        //return board.getBoardId();
        return 0L;
    }

    @Override
    public int update(Board board) throws Exception{
        //.put(board.getBoardId(), board);
        //return 0;
        return 0;
    }

    @Override
    public int delete(Board board) throws Exception{
        //store.remove(board.getBoardId());
//        return 0;
        return 0;
    }
}
