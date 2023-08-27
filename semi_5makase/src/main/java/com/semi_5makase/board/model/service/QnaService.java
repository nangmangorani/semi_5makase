package com.semi_5makase.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.semi_5makase.board.model.dao.QnaDao;
import com.semi_5makase.board.model.vo.Qna;
import com.semi_5makase.common.model.PageInfo;


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
	
	public int insertQna(Qna q) {
		Connection conn = getConnection();
		
		int result = new QnaDao().insertQna(conn, q);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new QnaDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
	}

}
