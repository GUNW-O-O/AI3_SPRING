package com.aloha.spring.service;

import com.aloha.spring.dto.User;

public interface UserService {

	// 게시글 등록
	public boolean insert(User user) throws Exception;
	
}
