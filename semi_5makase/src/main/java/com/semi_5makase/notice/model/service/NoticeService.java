package com.semi_5makase.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.semi_5makase.common.JDBCTemplate.*;

import com.semi_5makase.common.model.vo.PageInfo;
import com.semi_5makase.notice.model.dao.NoticeDao;
import com.semi_5makase.notice.model.vo.Notice;

public class NoticeService {
	
	
	/**
	 * 공지사항 리스트 조회
	 */
	public ArrayList<Notice> selectNoticeList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 검색결과 있을 경우
	 * @param pi
	 * @param searchNo
	 * @return
	 */
	public ArrayList<Notice> searchNoticeList(PageInfo pi, String searchNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().searchNoticeList(conn, pi, searchNo);
		
		close(conn);
		
		return list;
	}
	
	public int searchListCount(String searchNo) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().searchListCount(conn, searchNo);
		
		close(conn);
		
		return result;
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
	
	/**
	 * 총 게시물 개수
	 * @return
	 */
	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new NoticeDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
		
	}

	
//	public int insertNotice(Notice n) {
//		
//		Connection conn = getConnection();
//		
//		int result = new NoticeDao().insertNotice(conn, n);
//		
//		if(result > 0) {
//			commit(conn);
//		} else {
//			rollback(conn);
//		}
//		
//		close(conn);
//		
//		return result;
//		
//	}


	public int updateNotice(Notice n) {
		
		Connection conn = getConnection();
		
		int result = new NoticeDao().updateNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}


	




	
	
	
	

}
