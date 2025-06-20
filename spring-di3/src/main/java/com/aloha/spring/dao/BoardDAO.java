package com.aloha.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.aloha.spring.dto.Board;

// DAO 역할을 하는 빈으로 등록 
@Repository
public class BoardDAO {
	
	public BoardDAO() { 
		
	}
	
	public List<Board> list() { 
		List<Board> boardList = new ArrayList<Board>();
		boardList.add(new Board("제목01", "작성자01", "내용01"));
		boardList.add(new Board("제목02", "작성자02", "내용02"));
		boardList.add(new Board("제목03", "작성자03", "내용03"));
		
		System.out.println("BoardDAO 목록 조회");
		return boardList;
	}
}
