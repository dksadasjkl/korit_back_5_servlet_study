package com.study.servlet_study.servlet;

import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.servlet_study.utils.ParamsConverter;


@WebServlet("/http")
public class HttpStudyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public HttpStudyServlet() {
        super();
        
    }
    
//     HTTP 메소드
    // POST 요청	 -> C reate(추가) ->로그인
    // GET 요청		 -> R ead(조회)
    // PUT 요청		 -> U pdate(수정)
    // DELETE 요청	 -> D elete(삭제)
    
    
    // 클라이언트 -> 서버 -> DB
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	request.setCharacterEncoding("utf-8"); // 요청 시 -> body 인코딩 -> 응답받아오기 때문에 원래는 변환이 안됨
    	Map<String, String> paramsMap = new HashMap<>();
    	    	
    	request.getParameterMap().forEach((k, v) -> {
    		StringBuilder builder = new StringBuilder();
    		Arrays.asList(v).forEach(value -> builder.append(value)); //asList -> ArrayList로 변환
    		paramsMap.put(k, builder.toString());
    		});
    	System.out.println(paramsMap);
    	System.out.println(request.getParameter("name"));
    	
    	
    	Map<String, String> paramsMap2 = new HashMap<>();
    	Iterator<String> ir = request.getParameterNames().asIterator();
    	while (ir.hasNext()) { //.hasNext() 
    		String key = ir.next();
    		paramsMap2.put(key, request.getParameter(key));
		}
    
    }

	// 주소창에 바로 데이터 입력
    // http?username=aaa &password
    // ?params k = v &(구분)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> paramsMap = ParamsConverter.convertParamsMapToMap(request.getParameterMap());
    	System.out.println(paramsMap);
	}

	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

}
