package com.semi_5makase.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.board.model.service.FaqService;
import com.semi_5makase.board.model.vo.Faq;

/**
 * Servlet implementation class FaqListController
 */
@WebServlet("/list.faq")
public class FaqListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		
//		// 1. searchFaq값을 받아옴
//		String searchFaq = (String)request.getAttribute("searchFaq");
//		
//		// 2. list에 실어서 보냄
//		ArrayList<Faq> list = new FaqService().selectFaqList(searchFaq);
//		System.out.println(searchFaq + "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
//		
//		// 3. 
//		request.setAttribute("list", list);
//		request.getRequestDispatcher("views/board/faqListView.jsp").forward(request, response);
//		
		String searchFaq = request.getParameter("searchFaq");
	    ArrayList<Faq> list;

	    if (searchFaq != null && !searchFaq.isEmpty()) {
	    	list = new FaqService().searchFaqList(searchFaq);
	    } else {
	    	list = new FaqService().selectFaqList();
	    }

	    request.setAttribute("list", list);
	    request.setAttribute("searchFaq", searchFaq);

	    request.getRequestDispatcher("views/board/faqListView.jsp").forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
