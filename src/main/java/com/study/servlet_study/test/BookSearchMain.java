package com.study.servlet_study.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.study.servlet_study.config.DBConnectionMgr;
import com.study.servlet_study.entity.Author;
import com.study.servlet_study.entity.Book;
import com.study.servlet_study.entity.Publisher;

public class BookSearchMain {

	public static void main(String[] args) {
		
		/*
		 * 검색할 도서명을 입력하세요 >>> 글
		 * 
		 * 도서명 / 저자 / 출판사
		 * 
		 */
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("검색할 도서명을 입력하세요 >>> ");
		String name = scanner.nextLine(); // like?
		
		DBConnectionMgr pool = DBConnectionMgr.getInstance(); 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
//		try {
//			con = pool.getConnection();
//			String authorSql = "select * from author_tb";
//			pstmt = con.prepareStatement(authorSql);
//			rs = pstmt.executeQuery();
//					
//			List<Author> authorList = new ArrayList<>();
//			
//			while(rs.next()) {
//				authorList.add(Author.builder()
//						.authorId(rs.getInt(1))
//						.authorName(rs.getString(2))
//						.build());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//		try {
//			con = pool.getConnection();
//			String publisherSql = "select * from publisher_tb";
//			pstmt = con.prepareStatement(publisherSql);
//			rs = pstmt.executeQuery();
//			List<Publisher> authorList = new ArrayList<>();
//			
//			while(rs.next()) {
//				authorList.add(Publisher.builder()
//						.publisherId(rs.getInt(1))
//						.publisherName(rs.getString(2))
//						.build());
//			}
//					
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
		try {
			con = pool.getConnection();
			String bookSql = "SELECT \r\n"
					+ "	bt.book_name,\r\n"
					+ "    at.author_name,\r\n"
					+ "    pt.publisher_name\r\n"
					+ "from\r\n"
					+ "	book_tb bt\r\n"
					+ "	left outer join author_tb at on (at.author_id = bt.author_id)\r\n"
					+ "    left outer join publisher_tb pt on(pt.publisher_id = bt.publisher_id)";
			pstmt = con.prepareStatement(bookSql);
			rs = pstmt.executeQuery();
			List<Book> authorList = new ArrayList<>();
			
			while(rs.next()) {
				authorList.add(Book.builder()
						.bookName(rs.getString(1))
						.authorName(rs.getString(2))
						.publisherName(rs.getString(3))
						.build());
				
				authorList.forEach(book -> System.out.println(book));
				while (rs.next()) {
					System.out.println(rs.getString(1) + "   " + rs.getString(2) + "   " + rs.getString(3));
				
				}
				
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}  finally { 
			pool.freeConnection(con, pstmt, rs);
		}
		
		
		
		
	}

}
