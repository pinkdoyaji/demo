package com.example.demo.board.controller;

import com.example.demo.board.dto.Board;

import com.example.demo.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String list(Board board, Model model) {
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
    public String view(@ModelAttribute("boardId") long boardId, Model model) {

        Board board = new Board();
        board.setBoardId(boardId);
        // 목록 조회
        model.addAttribute("board", boardService.view(board));
        return "/content/board/boardView";
    }
    
    @GetMapping("/regist")
    public String regist(Model model) {
        // 등록 페이지에서 th:object="${board}"로 받는다.
        model.addAttribute("board", new Board());
        return "/content/board/boardRegist";
    }

    @PostMapping("/modify")
    public String modify(@ModelAttribute Board board, Model model) {
        model.addAttribute("board", boardService.view(board));
        return "/content/board/boardRegist";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute Board board, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("boardId", boardService.insert(board));
        return "redirect:./view";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Board board, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("boardId", boardService.update(board));
        return "redirect:./view";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Board board, RedirectAttributes redirectAttributes) {
        boardService.delete(board);
        return "redirect:./list";
    }

    /*
    * C.A.S
    * ({"/list.do","/search.do"}) : 페이징 처리됨
    * ({"/listAll.do","/searchAll.do"}) 전체 리스트
    * ("/view.do") 상세조회
    * "/regist.do") : 등록화면
    * "/modify.do") : 수정화면
    * ("/save.do") : 저장 처리
    * ("/insert.do") : 등록
    * ("/update.do") : 수정
    * ("/delete.do") : 삭제
    * ("/ajaxList.do") : 페이징 처리 리스트
    * ("/ajaxListAll.do") : 전체 페이지
    * g("/ajaxView.do") : 상세조회
    * ("/ajaxSave.do") : 저장
     * ("/ajaxInsert.do") : 등록
     * ("/ajaxUpdate.do") : 수정
     * ("/ajaxDelete.do") : 삭제
     * exceldown : 엑셀 다운로드
     *
     * */
}
