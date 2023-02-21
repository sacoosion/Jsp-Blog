package com.cos.blog.service;

import java.util.List;

import com.cos.blog.domain.reply.Reply;
import com.cos.blog.domain.reply.ReplyDao;
import com.cos.blog.domain.reply.dto.SaveReqDto;

public class ReplyService {
	
	private ReplyDao replyDao;
	
	public ReplyService() {
		replyDao = new ReplyDao();
	}

	public int 댓글쓰기(SaveReqDto dto) {
		int result = replyDao.save(dto);
		return result;
	}

	public Reply 댓글찾기(int id) {
		return replyDao.findById(id);
	}

	public List<Reply> 글목록보기(int boardId) {
		return replyDao.findAll(boardId);
	}

	public int 댓글삭제(int id) {
		return replyDao.deleteById(id);
	}

}
