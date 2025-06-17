package com.aloha.spring.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.aloha.spring.dto.User;


@Mapper
public interface UserMapper {

	// 메소드명은 Mapper.xml 매핑 파일의 SQL 태그 id 값과 일치해야한다.
	// 등록
	public int insert(User user)throws Exception;
	
}
