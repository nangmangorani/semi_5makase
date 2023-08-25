package com.semi_5makase.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.semi_5makase.common.JDBCTemplate.*;

import com.semi_5makase.notice.model.dao.NoticeDao;
import com.semi_5makase.notice.model.vo.Notice;

public class NoticeService {
	
	
	/**
	 * 공지사항 리스트 조회
	 */
	public ArrayList<Notice> selectNoticeList() {
		
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn);
		
		close(conn);
		
		return list;
	}
	

}
