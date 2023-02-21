package com.cos.blog.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class ApiServerTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ApiServerTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * String food = request.getParameter("food"); String method =
		 * request.getParameter("method");
		 * int result = 1; //정상 PrintWriter out = response.getWriter(); if(result == 1)
		 * { out.println("{\"food\":"+food+"\"method\":"+method+"}"); }else {
		 * out.println("{\"error\":\"fail\"}"); } out.println(result); out.flush();
		 */
		
		// DB에 insert 하고 끝
//		response.setContentType("application/json; charset=utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>안녕</h1>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
	}

}
