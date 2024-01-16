package com.study.servlet_study.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// *웹 -> 무조건 요청, 응답이 있다
// 새로고침 (F5) -> 새 요청
// 주소창에서 Enter 요청시 -> Request Method: get(get 요청)
// request, response 객체로 생성됨.
@WebServlet("/hello") // 1. 요청 주소
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getMethod()); 
		System.out.println(request.getRequestURL()); // 전체 주소
		System.out.println(request.getRequestURI());
		
		System.out.println(response.getStatus());  // 응답 상태
		
		response.setContentType("text/plain");
		System.out.println(response.getContentType());
		
		response.getWriter().println("헬로");
	
		System.out.println("요청이 들어옴!!");
		
	}

}
