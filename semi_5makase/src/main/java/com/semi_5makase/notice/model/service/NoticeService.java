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
	
	
	/**
	 * 공지사항 세부창
	 */
	
	public Notice selectNotice(int noticeNo) {
		
		Connection conn = getConnection();
		
		Notice n = new NoticeDao().selectNotice(conn, noticeNo);
		
		close(conn);
		
		return n;
	}
	
	/**
	 * 공지사항 조회수 증가
	 */
	
	public int increaseNoticeViews(int noticeNo) {
		
		Connection conn = getConnection();
		
		int result = new NoticeDao().increaseNoticeViews(conn, noticeNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	

}
