package com.cos.blog.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cos.blog.config.DB;
import com.cos.blog.domain.user.User;
import com.cos.blog.domain.user.UserDao;
import com.cos.blog.domain.user.dto.JoinReqDto;
import com.cos.blog.domain.user.dto.LoginReqDto;
import com.cos.blog.domain.user.dto.UpdateReqDto;

public class UserService {
	
	private UserDao userDao;
	
//	public UserService(UserDao userDao) {
//		this.userDao = userDao;
//	}
	public UserService() {
		userDao = new UserDao();
	}
	// 회원가입, 회원 수정, 회원 로그인, 로그아웃,  아이디 중복체크
	public int 회원가입(JoinReqDto dto) {
		int result = userDao.save(dto);
		return result;
	}
	
	public User 로그인(LoginReqDto dto) {
		return userDao.findByUsernameAndPassword(dto);
	}
	
	public int 회원수정(UpdateReqDto dto) {
		
		return -1;
	}
	
	public int 유저네임중복체크(String username) {
		int result = userDao.findByUsername(username);
		return result;
	}
	
	// public void 로그아웃() {} 서비스단에 만들지 않음 request를 들고오지 않기 때문에 컨트롤러단에서 처리
}
