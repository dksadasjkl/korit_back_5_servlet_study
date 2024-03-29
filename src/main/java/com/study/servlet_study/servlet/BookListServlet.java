package com.study.servlet_study.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.servlet_study.entity.Book;
import com.study.servlet_study.service.BookService;

@WebServlet("/books")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookService bookService;  
	
    public BookListServlet() {
        super();
        bookService = BookService.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// params
		// bookName -> like 조회 
		// authorName -> like 조회 or 일치할때                  
		// publisherName -> like 조회  
		// 팁 1 = 1 
		// 		and (not 1 = 1 or book_neme like '%금%') 
		// 		and (not 1 = 1 or authorName like '%금%') 
		// 		and (not 1 = 1 or publisherName like '%금%') 
		
		String bookName = request.getParameter("bookName");
		String authorName = request.getParameter("authorName");
		String publisherName = request.getParameter("publisherName");
		
		Map<String, String> params = new HashMap<>();
		if (bookName != null) {
			params.put("bookName", bookName);
		}
		if (authorName != null) {
			params.put("authorName", authorName);
		}
		if (publisherName != null) {
			params.put("publisherName", publisherName);
		}
		
		params.size();
		
	}
}
	
