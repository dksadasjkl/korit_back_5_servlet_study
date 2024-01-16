package com.study.servlet_study.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//  "/*" 모든 경로 요청 
// 클라이언트 -> 요청 -> 전처리 -> 필터 -> 후처리 -> 클라이언트
@WebFilter("/*")
public class ResponseCharactorEncodingFilter extends HttpFilter implements Filter {
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 생성될때 ServletRequest로 업캐스팅 -> HttpServlet로 다운캐스팅
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		httpResponse.setCharacterEncoding("utf-8");
		// 전처리
		
		chain.doFilter(request, response); // 최종 필터(doGet()) -> 메소드호출 (매개변수:주소를 받아서)
		
		// 후처리
		
//		httpResponse.getWriter().println("무조건 후처리함");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
