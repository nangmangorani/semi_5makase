package com.semi_5makase.notice.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.notice.model.service.NoticeService;
import com.semi_5makase.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateViewController
 */
@WebServlet("/updateview.no")
public class NoticeUpdateViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("여기는 뷰컨트롤러~~~~~~~~~ㅎㅎㅋㅠㅠㅠ");
		
		int noticeNo = Integer.parseInt(request.getParameter("cpage"));
		
		
		
		System.out.println(noticeNo+"여기는 뷰컨트롤러~~~~~~~~~ㅎㅎㅋㅠㅠㅠ");
		
		Notice n = new NoticeService().selectNotice(noticeNo);
		
		//n.setNoticeNo(noticeNo);
		request.setAttribute("n", n);
		
		request.getRequestDispatcher("views/notice/noticeUpdateView.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
