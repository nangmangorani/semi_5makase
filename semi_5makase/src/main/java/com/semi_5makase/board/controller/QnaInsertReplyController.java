package com.semi_5makase.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.board.model.service.QnaService;
import com.semi_5makase.board.model.vo.Qna;

/**
 * Servlet implementation class QnaInsertReplyController
 */
@WebServlet("/insertReply.qna")
public class QnaInsertReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaInsertReplyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//String userNo = request.getParameter("userNo");
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		String qnaContent = request.getParameter("qnaContent");
		
		
		int result = new QnaService().insertReply(qnaNo, qnaContent);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "성공적으로 추가되었습니다.");
			response.sendRedirect(request.getContextPath() + "/list.qna?cpage=1");
		} else {
			// 실패
			request.setAttribute("errorMsg", "게시글 추가에 실패했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
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
