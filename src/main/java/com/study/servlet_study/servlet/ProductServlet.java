package com.study.servlet_study.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.servlet_study.entity.Product;
import com.study.servlet_study.repository.ProductRepository;
import com.study.servlet_study.service.ProductService;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
	
    public ProductServlet() {
    	super();
    	productService = ProductService.getInstance();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = productService.getProduct(request.getParameter("productName")); 
		response.setStatus(200);
		response.getWriter().println(product);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int price = 0;
		
		try {
			// Integer.parseInt() 문자열을 정수로 변환
			price = Integer.parseInt(request.getParameter("price"));
		} catch (NumberFormatException e) {
			response.setStatus(400);
			response.getWriter().println("숫자만 입력해야 합니다.");
			return;
		}
		
		Product product = Product
				.builder()
				.productName(request.getParameter("productName"))
				.price(price)
				.size(request.getParameter("size"))
				.color(request.getParameter("color"))
				.build();
			
		if(productService.getProduct(product.getProductName()) != null) {
			response.setStatus(400);
			response.getWriter().println("이미 등록된 상품명입니다.");
			return; // 밑으로는 실행안됨.
		}
		
		productService.addProduct(product);
		response.setStatus(201); 
		response.getWriter().println("상품 등록이 완료되었습니다.");
		
		// 클린코드 Servlet에서 예외처리 해야됨.
		
//		int body = productService.addProduct(product);
//		if (body == 0) {
//			response.setStatus(404);
//			response.getWriter().println(body);
//		}
//		if (body == 1) {
//			response.setStatus(201); // Created
//			response.getWriter().println(body);
//		}

	}

}
