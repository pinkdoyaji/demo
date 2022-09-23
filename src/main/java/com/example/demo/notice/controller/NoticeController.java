package com.example.demo.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

    //private
    @GetMapping("/list")
    public String list() {
        System.out.println("!!!!");
        return "notice/noticeList";
    }

    @GetMapping("/regist")
    public String regist() {
        return "notice/noticeRegist";
    }

    /*
    *
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
