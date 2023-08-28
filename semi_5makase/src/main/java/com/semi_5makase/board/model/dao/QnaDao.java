package com.semi_5makase.board.model.dao;

import static com.semi_5makase.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.semi_5makase.board.model.vo.Qna;
import com.semi_5makase.common.model.PageInfo;

public class QnaDao {
	
	Properties prop = new Properties();
	
	public QnaDao() {
		try {
			prop.loadFromXML(new FileInputStream(QnaDao.class.getResource("/db/sql/board-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Qna> selectQnaList(Connection conn, PageInfo pi){
		
		ArrayList<Qna> list = new ArrayList<Qna>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectQnaList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		System.out.println(startRow);
		System.out.println(endRow);
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Qna(rset.getInt("qna_no"),
						 rset.getString("board_title"),
						 rset.getDate("create_date"),
						 rset.getString("open"),
						 rset.getString("reply"),
						 rset.getString("board_writer")
						 ));
			}
			
			System.out.println(list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
		
	}
	
	
	public int insertQna(Connection conn, Qna q) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertQna");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, q.getBoardTitle());
			pstmt.setString(2, q.getBoardContent());
			pstmt.setString(3, q.getOpen());
			pstmt.setInt(4, Integer.parseInt(q.getBoardWriter()));
			System.out.println(q.getOpen()+"df1a6s");
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public int selectListCount(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public int increaseQnaViews(Connection conn, int qnaNo) {
		
		int result = 0; 
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("increaseQnaViews");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public Qna selectQna(Connection conn, int qnaNo) {
		
		Qna q = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectQna");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, qnaNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) { // 생성자 만들어라
				q = new Qna(rset.getInt("qna_no"),
						    rset.getString("board_title"),
						    rset.getString("board_content"),
						    rset.getInt("qna_views"),
						    rset.getDate("create_date"),
						    rset.getString("open"),
						    rset.getString("reply"),
						    rset.getString("board_writer"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return q;
		
	}

	
	
	
	
	
}
