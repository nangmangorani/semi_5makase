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
import com.semi_5makase.common.model.vo.Attachment;


public class QnaDao {
	
	Properties prop = new Properties();
	
	public QnaDao() {
		try {
			prop.loadFromXML(new FileInputStream(QnaDao.class.getResource("/db/sql/board-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * qna리스트 조회
	 * @return
	 */
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
						 rset.getString("mem_id")
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
	
	
	/**
	 * qna 사진없을경우
	 */
	
	public int insertBoard(Connection conn, Qna q) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, q.getBoardTitle());
			pstmt.setString(2, q.getBoardContent());
			pstmt.setString(3, q.getOpen());
			pstmt.setInt(4, Integer.parseInt(q.getBoardWriter()));
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	
	/**
	 * qna 사진있는경우
	 */
	public int insertAttachment(Connection conn, ArrayList<Attachment> list) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertAttachment");
		try {
			for(Attachment at : list) {
				pstmt = conn.prepareStatement(sql);
			
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				
				result = pstmt.executeUpdate();
				System.out.println(result + "dao at");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	/**
	 * Qna 총 개수(페이징처리용)
	 * @return
	 */
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
	
	
	/**
	 * Qna 조회수 증가
	 * @param qnaNo
	 * @return
	 */
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
	
	/**
	 * Qna list에서 클릭시 상세페이지
	 * @param qnaNo
	 * @return
	 */
	public Qna selectQna(Connection conn, int qnaNo) {
		
		Qna q = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectQna");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, qnaNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				q = new Qna(rset.getInt("qna_no"),
						    rset.getString("board_title"),
						    rset.getString("board_content"),
						    rset.getInt("qna_views"),
						    rset.getDate("create_date"),
						    rset.getString("open"),
						    rset.getString("reply"),
						    rset.getString("mem_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return q;
		
	}

	public ArrayList<Attachment> selectAttachment(Connection conn, int qnaNo) {
		
		ArrayList<Attachment> list = new ArrayList<Attachment>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Attachment at = new Attachment();
				at.setOriginName(rset.getString("origin_name"));
				at.setChangeName(rset.getString("change_name"));
				at.setFilePath(rset.getString("file_path"));
				
				list.add(at);
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
	 * qna 수정하기
	 */
	public int updateQna(Connection conn, Qna q) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateQna");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, q.getBoardTitle());
			pstmt.setString(2, q.getBoardContent());
			pstmt.setInt(3, q.getQnaNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
		
	}
	
	/**
	 * qna 사진 수정
	 */
	public int updateAttachment(Connection conn, ArrayList<Attachment> list) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteAttachment");
		
		try {
			for(Attachment at : list) {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, at.getRefBno());
				
				result = pstmt.executeUpdate();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println(result + "ㅋㅋㅋㅋㅋㅋㅋㅋ나는 dao");
		return result;
		
	}
	
	
	/**
	 * qna삭제
	 * @param conn
	 * @param qnaNo
	 * @return
	 */
	public int deleteQna(Connection conn, int qnaNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteQna");
		
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
	
	
	
	
}
