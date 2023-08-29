package com.semi_5makase.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.board.model.service.QnaService;
import com.semi_5makase.board.model.vo.Qna;

/**
 * Servlet implementation class QnaDetailViewController
 */
@WebServlet("/detail.qna")
public class QnaDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaDetailViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// qnaNo 받고 한 행 select
		int qnaNo = Integer.parseInt( request.getParameter("num"));
		
		int result = new QnaService().increaseQnaViews(qnaNo);
		
		if(result > 0) {
			Qna q = new QnaService().selectQna(qnaNo);
			request.setAttribute("q", q);
			request.getRequestDispatcher("views/board/qnaDetailView.jsp").forward(request, response);
			
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
