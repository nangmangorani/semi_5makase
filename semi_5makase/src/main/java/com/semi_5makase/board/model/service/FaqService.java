package com.semi_5makase.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.semi_5makase.board.model.dao.FaqDao;
import com.semi_5makase.board.model.vo.Faq;
import static com.semi_5makase.common.JDBCTemplate.*;

public class FaqService {
	
	public ArrayList<Faq> searchFaqList(String searchFaq) {
		Connection conn = getConnection();
		
		ArrayList<Faq> list = new FaqDao().searchFaqList(conn, searchFaq);
		
		close(conn);
		
		return list;
		
	}
	
	public ArrayList<Faq> selectFaqList() {
		
		Connection conn = getConnection();
		
		ArrayList<Faq> list = new FaqDao().selectFaqList(conn);
		
		close(conn);
		
		return list;
		
	}

	/**
	 * 자주묻는질문 추가하기
	 * @param f
	 * @return
	 */
	public int insertFaq(Faq f) {
		Connection conn = getConnection();
		
		int result = new FaqDao().insertFaq(conn, f);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	


}
