package com.semi_5makase.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.notice.model.service.NoticeService;
import com.semi_5makase.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeInsertController
 */
@WebServlet("/insert.no")
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String NoticeWriter = request.getParameter("noticeWriter");
		
		Notice n = new Notice();
		
		n.setNoticeTitle(title);
		n.setNoticeContent(content);
		n.setNoticeWriter(NoticeWriter);
		
		
		int result = new NoticeService().insertNotice(n);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/list.no?cpage=1");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
