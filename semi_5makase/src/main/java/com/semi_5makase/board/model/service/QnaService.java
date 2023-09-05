package com.semi_5makase.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.semi_5makase.board.model.dao.QnaDao;
import com.semi_5makase.board.model.vo.Qna;
import com.semi_5makase.common.model.vo.PageInfo;
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
	
	public int insertBoard(Qna q, Attachment at) {
		Connection conn = getConnection();
		
		int result1 = new QnaDao().insertBoard(conn, q);
		int result2 = 1;
		
		// 사진있을경우
		if(at != null) {
			result2 = new QnaDao().insertAttachment(conn, at);
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

	public Attachment selectAttachment(int qnaNo) {
		
		Connection conn = getConnection();
		
		Attachment at = new QnaDao().selectAttachment(conn, qnaNo);
		
		close(conn);
		
		return at;
	}
	
	
	/**
	 * qna 수정하기
	 */
	
	public int updateQna(Qna q, Attachment at) {
		
		Connection conn = getConnection();
		// 1. 일단 글은 무조건 수정
		int result1 = new QnaDao().updateQnaBoard(conn, q, at);
		int result2 = 1;
		
		if(at != null) {
			if(at.getFileNo() != 0) {
				result2 = new QnaDao().updateAttachment(conn, at);
			} else {
				result2 = new QnaDao().insertNewAttachment(conn, at);
			}
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
	 * qna 삭제하기
	 */
	
	public int deleteQna(int qnaNo) {
		Connection conn = getConnection();
		
		int result = new QnaDao().deleteQna(conn, qnaNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	/**
	 * qna 답변달기
	 */
	
	public int insertReply(int qnaNo, String qnaContent) {
		
		Connection conn = getConnection();
		
		int result = new QnaDao().insertReply(conn, qnaNo, qnaContent);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	
	
	
	
	

}
