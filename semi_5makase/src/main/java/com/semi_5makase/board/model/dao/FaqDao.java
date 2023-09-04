package com.semi_5makase.board.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.semi_5makase.board.model.vo.Faq;

import static com.semi_5makase.common.JDBCTemplate.*;

public class FaqDao {
	
	Properties prop = new Properties();
	
	public FaqDao() {
		try {
			prop.loadFromXML(new FileInputStream(FaqDao.class.getResource("/db/sql/board-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Faq> searchFaqList(Connection conn, String searchFaq) {
		
		ArrayList<Faq> list = new ArrayList<Faq>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectFaqList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, searchFaq);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Faq(rset.getInt("faq_no"),
						         rset.getString("faq_title"),
						         rset.getString("faq_content")
						         ));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public ArrayList<Faq> selectFaqList(Connection conn) {
		
		ArrayList<Faq> list = new ArrayList<Faq>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectFaqListNoSearch");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Faq(rset.getInt("faq_no"),
						         rset.getString("faq_title"),
						         rset.getString("faq_content")
						         ));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}

	/**
	 * 자주묻는질문 추가하기
	 * @param conn
	 * @param f
	 * @return
	 */
	public int insertFaq(Connection conn, Faq f) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, f.getFaqTitle());
			pstmt.setString(2, f.getFaqContent());
			pstmt.setInt(3, Integer.parseInt(f.getFaqWriter()));
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
	/**
	 * faq 삭제하기
	 */
	
	public int deleteFaq(Connection conn, int[] faqNoArray) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteFaq");
		
		try {
			for(int i = 0; i<faqNoArray.length; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, faqNoArray[i]);
				
				result = pstmt.executeUpdate();
				if(result == 0) {
					return result;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	
	
	
	

}
