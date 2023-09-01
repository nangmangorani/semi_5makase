package com.semi_5makase.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.board.model.service.FaqService;
import com.semi_5makase.common.model.PageInfo;
import com.semi_5makase.notice.model.service.NoticeService;
import com.semi_5makase.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeListController
 */
@WebServlet("/list.no")
public class NoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchNo = request.getParameter("searchNo");
		// 페이징처리
		int listCount;   // 현재 총 게시글 개수
		int currentPage; // 현재 페이지(즉, 사용자가 요청한 페이지)
		int pageLimit;   // 페이지 하단에 보여질 페이징바의 페이지 최대개수(몇개 단위씩)
		int boardLimit;  // 한 페이지 내에 보여질 게시글 최대개수(몇개 단위씩)
		
		// 위의 4개를 가지고 아래 3개의 값을 구해낼꺼임
		int maxPage;	 // 가장 마지막페이지 (총 페이지 수)
		int startPage;   // 페이징바의 시작수
		int endPage;	 // 페이징바의 끝수
		
		
		// * listCount : 총 게시글 개수
		if (searchNo != null && !searchNo.isEmpty()) {
			listCount = new NoticeService().searchListCount(searchNo);
			System.out.println(listCount+ "개수");
		} else {
			listCount = new NoticeService().selectListCount();
		}
		
		// * currentPage : 현재 페이지 (즉, 사용자가 요청한 페이지)
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		// *pageLimit : 페이징바의 페이지 최대 개수
		pageLimit = 5;

		// *boardLimit : 게시글 최대 개수
		boardLimit = 5;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Notice> list;
		if (searchNo != null && !searchNo.isEmpty()) {
	    	list = new NoticeService().searchNoticeList(pi,searchNo);
	    } else {
	    	list = new NoticeService().selectNoticeList(pi);
	    }
		
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/notice/noticeListView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
