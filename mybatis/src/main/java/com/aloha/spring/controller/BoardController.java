package com.aloha.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aloha.spring.dto.Board;
import com.aloha.spring.service.BoardService;

@Controller					// 컨트롤러로 빈 등
@RequestMapping("/board")	// 클래스 레벨 경로 /board 로 지정
public class BoardController {

	// 로거
	private static final Logger logger
				= LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	// [GET]	: @GetMapping("/list")
	// [POST]	: @PostMapping("/insert")
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
	/**
	 * 
	 *	게시글 목록			-[GET]	/list
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")		// Spring 4.3 버전 이상 사용 가능
	public String list(Model model) throws Exception {
		List<Board> list = boardService.list();
		model.addAttribute("list",list);
		return "/board/list";
	}
	
	/**
	 * 
	 * 게시글 조회			-[GET]	/read
	 * @param model
	 * @param no
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/read")		// Spring 4.3 버전 이상 사용 가능
	public String read(Model model, int no) throws Exception {
		Board board = boardService.select(no);
		model.addAttribute("board",board);
		return "/board/read";
	}
	
	/**
	 *  게시글 등록			-[GET]	/insert
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insert")		// Spring 4.3 버전 이상 사용 가능
	public String insert() throws Exception {
		
		return "/board/insert";
	}
	
	/**
	 * 게시글 등록 처리		-[POST] /insert 
	 * @param board
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/insert")
	public String insertPOST(Board board) throws Exception {
		
		boolean result = boardService.insert(board);
		
		if(result)
			return "redirect:/board/list";
		else
			return "redirect:/board/insert?error";
	}
	
	/**
	 * 게시글 수정			-[GET]	/update 
	 * @param model
	 * @param no
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/update")		// Spring 4.3 버전 이상 사용 가능
	public String update(Model model, int no) throws Exception {
		Board board = boardService.select(no);
		model.addAttribute("board", board);
		return "/board/update";
	}
	
	/**
	 * 게시글 수정 처리		-[POST]	/update 
	 * @param board
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public String updatePOST(Board board) throws Exception {
		
		boolean result = boardService.update(board);
		
		if(result)
			return "redirect:/board/list";
		else
			return "redirect:/board/update?error";
	}
	
	/**
	 * 게시글 삭제 처리		-[POST]	/delete 
	 * @param no
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/delete")
	public String deletePOST(int no) throws Exception {
		
		boolean result = boardService.delete(no);
		
		if(result)
			return "redirect:/board/list";
		else
			return "redirect:/board/update?error";
	}
	
	
}
