package com.study.servlet_study.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.study.servlet_study.config.DBConnectionMgr;
import com.study.servlet_study.entity.Author;
import com.study.servlet_study.entity.Book;
import com.study.servlet_study.entity.Publisher;

public class BookInsertMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String bookName = null;
		String authorName = null;
		String publisherName = null;
		

		System.out.print("도서명 >>> ");
		bookName = scanner.nextLine();
		System.out.print("저자명 >>> ");
		authorName = scanner.nextLine();
		System.out.print("출판사 >>> ");
		publisherName = scanner.nextLine();
		
		
		Book book = Book.builder()
					.bookName(bookName)
					.author(Author.builder()
							.authorName(authorName)
							.build())
					.publisher(Publisher.builder()
							.publisherName(publisherName)
							.build())
					.build();
				
		
		
		DBConnectionMgr pool = DBConnectionMgr.getInstance();
		
		Connection con = null; 
		PreparedStatement pstmt = null;
		int count = 0;
		
		try {
			con = pool.getConnection();
			String sql = "insert into author_tb values (0, ?)";
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //Statement.RETURN_GENERATED_KEYS - insert(해당 auto increment 키값)
			pstmt.setString(1, book.getAuthor().getAuthorName()); 				// 1번, ?표에 이름 입력
			pstmt.executeUpdate();        										// executeUpdate  - MySql 에서 update, delete 의 해당 건수                         
			ResultSet rs = pstmt.getGeneratedKeys();							// getGeneratedKeys - 생성된 키값
			if (rs.next()) {														
				book.getAuthor().setAuthorId(rs.getInt(1));						// 해당 책의 저자객체를 꺼내서 id 추가해라
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		
		
		try {
			con = pool.getConnection();
			String sql = "insert into publisher_tb values (0, ?)";
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //Statement.RETURN_GENERATED_KEYS - insert(해당 auto increment 키값)
			pstmt.setString(1, book.getPublisher().getPublisherName()); 				// 1번, ?표에 이름 입력
			pstmt.executeUpdate();        										// executeUpdate  - MySql 에서 update, delete 의 해당 건수                         
			ResultSet rs = pstmt.getGeneratedKeys();							// getGeneratedKeys - 생성된 키값
			if (rs.next()) {														
				book.getPublisher().setPublisherId(rs.getInt(1));						// 해당 책의 저자객체를 꺼내서 id 추가해라
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		
		
		try {
			con = pool.getConnection();
			String sql = "insert into book_tb values (0, ?, ?, ?)";
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //Statement.RETURN_GENERATED_KEYS - insert(해당 auto increment 키값)
			pstmt.setString(1, book.getBookName()); // 1번, ?표에 이름 입력
			pstmt.setInt(2, book.getAuthor().getAuthorId());
			pstmt.setInt(3, book.getPublisher().getPublisherId());
			pstmt.executeUpdate();        										// executeUpdate  - MySql 에서 update, delete 의 해당 건수                         
			ResultSet rs = pstmt.getGeneratedKeys();							// getGeneratedKeys - 생성된 키값
			if (rs.next()) {														
				book.setBookId(rs.getInt(1));						// 해당 책의 저자객체를 꺼내서 id 추가해라
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		
		
		System.out.println("추가된 도서 정보");
		System.out.println(book);
		
	}

}
