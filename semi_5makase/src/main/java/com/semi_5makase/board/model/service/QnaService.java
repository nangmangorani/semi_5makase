package com.semi_5makase.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.semi_5makase.board.model.dao.QnaDao;
import com.semi_5makase.board.model.vo.Qna;
import com.semi_5makase.common.model.PageInfo;
import com.semi_5makase.common.model.vo.Attachment;

import static com.semi_5makase.common.JDBCTemplate.*;

public class QnaService {
	
	/**
	 * qna리스트 조회
	 * @return
	 */
	public ArrayList<Qna> selectQnaList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Qna> list = new QnaDao().selectQnaList(conn, pi);
		
		close(conn);
		
		return list;
	}
		
	/**
	 * qna insert. 사진 있는경우 없는경우 분기처리할곳
	 */
	
	public int insertBoard(Qna q, ArrayList<Attachment> list) {
		Connection conn = getConnection();
		
		int result1 = new QnaDao().insertBoard(conn, q);
		int result2 = 1;
		
		// 사진있을경우
		if(list != null && list.size() != 0) {
			result2 = new QnaDao().insertAttachment(conn, list);
			System.out.println(result2);
		}
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1 * result2;
		
	}
	
	
	
	
	/**
	 * Qna 총 개수(페이징처리용)
	 * @return
	 */
	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new QnaDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	
	/**
	 * Qna 조회수 증가
	 * @param qnaNo
	 * @return
	 */
	public int increaseQnaViews(int qnaNo) {
		
		Connection conn = getConnection();
		
		int result = new QnaDao().increaseQnaViews(conn, qnaNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	/**
	 * Qna list에서 클릭시 상세페이지
	 * @param qnaNo
	 * @return
	 */
	public Qna selectQna(int qnaNo) {
		
		Connection conn = getConnection();
		
		Qna q = new QnaDao().selectQna(conn, qnaNo);
		
		close(conn);
		
		return q;
		
	}

	public ArrayList<Attachment> selectAttachment(int qnaNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Attachment> list = new QnaDao().selectAttachment(conn, qnaNo);
		
		close(conn);
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
