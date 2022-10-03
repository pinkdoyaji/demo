package com.example.demo.board.controller;

import com.example.demo.board.dto.Board;

import com.example.demo.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/board/*")
public class BoardController {

    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping(value = {"/list", "/search"})
    public String list(Board board, Model model) throws Exception{
        // 조회
        List<Board> list = boardService.list(board);
        model.addAttribute("boardList", list);
        return "/content/board/boardList";
    }

    @GetMapping(value = {"/listAll", "/searchAll"})
    public String listAll() {
        return "/content/board/boardList";
    }

    // 게시판 한건 조회
    @GetMapping("/view")
    public String view(@ModelAttribute("boardId") long boardId, Model model) throws Exception{

        Board board = new Board();
        board.setBoardId(boardId);
        // 목록 조회
        model.addAttribute("board", boardService.view(board));
        return "/content/board/boardView";
    }
    
    @GetMapping("/regist")
    public String regist(Model model) throws Exception{
        // 등록 페이지에서 th:object="${board}"로 받는다.
        model.addAttribute("board", new Board());
        return "/content/board/boardRegist";
    }

    @PostMapping("/modify")
    public String modify(@ModelAttribute Board board, Model model) throws Exception{
        model.addAttribute("board", boardService.view(board));
        return "/content/board/boardRegist";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute Board board, RedirectAttributes redirectAttributes) throws Exception{
        redirectAttributes.addFlashAttribute("boardId", boardService.insert(board));
        return "redirect:./view";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Board board, RedirectAttributes redirectAttributes) throws Exception{
        redirectAttributes.addFlashAttribute("boardId", boardService.update(board));
        return "redirect:./view";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Board board, RedirectAttributes redirectAttributes) throws Exception{
        boardService.delete(board);
        return "redirect:./list";
    }
}
