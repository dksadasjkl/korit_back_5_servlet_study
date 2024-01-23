package com.study.servlet_study.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.study.servlet_study.config.DBConnectionMgr;
import com.study.servlet_study.entity.Author;

public class DBConnectionTestMain {

	public static void main(String[] args) {
		// 싱글톤 생성
		DBConnectionMgr pool = DBConnectionMgr.getInstance(); 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		// java + db연결 -> Connection connection = pool.getConnection()[jdbc]
		try { //지역변수
			con = pool.getConnection();
//			String name = "%" + "aaa" + "%";
			String sql = "select * from author_tb";
			pstmt = con.prepareStatement(sql); //객체 생성
//			pstmt.setString(1, name); -> (물음표 순번, 타입)
			
			rs = pstmt.executeQuery(); // 실행(mysql = ctrl + enter)
			
			List<Author> authorList = new ArrayList<>();
			
			while(rs.next()) {
				authorList.add(Author.builder()
						.authorId(rs.getInt(1))
						.authorName(rs.getString(2))
						.build());
			}
			
			// 람다식 객체생성
			authorList.forEach(author -> System.out.println(author));
//			for (Author author : authorList) {
//				System.out.println(author);
//			}
//			for (int i = 0; i <authorList.size(); i++) {
//				Author author = authorList.get(i);
//				System.out.println(author);
//			}
			
			
			while (rs.next()) {
				System.out.println("id: " + rs.getInt(1)); // author_id(int)
				System.out.println("name: " + rs.getString(2)); // author_name(varchar(100))
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally { //무조건 실행
			pool.freeConnection(con, pstmt, rs);
		}

	}

}
