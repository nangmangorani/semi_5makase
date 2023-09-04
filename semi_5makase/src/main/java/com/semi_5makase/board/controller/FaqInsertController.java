package com.semi_5makase.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.board.model.service.FaqService;
import com.semi_5makase.board.model.vo.Faq;

/**
 * Servlet implementation class FaqInsertController
 */
@WebServlet("/insert.faq")
public class FaqInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String faqTitle = request.getParameter("faqTitle");
		String faqContent = request.getParameter("faqContent");
		String faqWriter = request.getParameter("faqWriter");
		
		
		Faq f = new Faq();
		f.setFaqTitle(faqTitle);
		f.setFaqContent(faqContent);
		f.setFaqWriter(faqWriter);
		
		int result = new FaqService().insertFaq(f);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "성공적으로 추가되었습니다.");
			response.sendRedirect(request.getContextPath() + "/list.faq");
		} else {
			// 실패
			request.setAttribute("errorMsg", "게시글 추가에 실패하였습니다.");
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
