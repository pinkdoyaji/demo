package com.example.demo.board.service;

import com.example.demo.board.dto.Board;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BoardServiceImpl implements BoardService{

    // DB 없이 진행시에 테스트 위해 ===========================
    private static Map<Long, Board> store = new HashMap<>();
    private long sequence = 0L;
    // =====================================================

    @Override
    public List<Board> list(Board board) {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Board> view(Board board) {
        // HashMap의 values()는,
        // 해당 map의 value 목록을 Collection 형태로 리턴합니다.
        return store.values().stream().filter(result -> result.getBoardId().equals(board.getBoardId())).findAny();
    }

    @Override
    public long insert(Board board) {
       board.setBoardId(++sequence);
       store.put(board.getBoardId(), board);
       return board.getBoardId();
    }

    @Override
    public int update(Board board) {
        store.put(board.getBoardId(), board);
        return 0;
    }

    @Override
    public int delete(Board board) {
        store.remove(board.getBoardId());
        return 0;
    }
}
