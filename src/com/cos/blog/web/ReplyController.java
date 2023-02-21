package com.cos.blog.web;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.domain.board.dto.CommonRespDto;
import com.cos.blog.domain.reply.Reply;
import com.cos.blog.domain.reply.dto.SaveReqDto;
import com.cos.blog.service.ReplyService;
import com.cos.blog.util.Script;
import com.google.gson.Gson;

//http://localhost:8090/blog/reply
@WebServlet("/reply")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReplyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		ReplyService replyService = new ReplyService();
		// http://localhost:8090/blog/reply?cmd=save
		HttpSession session = request.getSession();
		if(cmd.equals("save")) {
//			int userId = Integer.parseInt(request.getParameter("userId"));
//			int boardId = Integer.parseInt(request.getParameter("boardId"));
//			String content = request.getParameter("content");
			BufferedReader br = request.getReader();
			String reqData = br.readLine();
			Gson gson = new Gson();
			SaveReqDto dto = gson.fromJson(reqData, SaveReqDto.class);
//			SaveReqDto dto = new SaveReqDto();
//			dto.setUserId(userId);
//			dto.setBoardId(boardId);
//			dto.setContent(content);
			CommonRespDto<Reply> commonRespDto = new CommonRespDto<>();
			Reply reply = null;
			int result = replyService.댓글쓰기(dto);
			if(result != 1) {
				reply = replyService.댓글찾기(result);
				commonRespDto.setStatusCode(1);
				commonRespDto.setData(reply);
			}else {
				commonRespDto.setStatusCode(-1);
			}
			
			String responseData = gson.toJson(commonRespDto);
			Script.responseData(response, responseData);
		}else if(cmd.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			int result = replyService.댓글삭제(id);

			CommonRespDto commonDto = new CommonRespDto<>();
			commonDto.setStatusCode(result);
			
			Gson gson = new Gson();
			String jsonData = gson.toJson(commonDto);
			Script.responseData(response, jsonData);
		}
	}

}
