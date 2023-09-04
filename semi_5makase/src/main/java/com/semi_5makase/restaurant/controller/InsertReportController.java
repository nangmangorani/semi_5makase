package com.semi_5makase.restaurant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.member.model.vo.Member;
import com.semi_5makase.restaurant.model.service.RestaurantService;

/**
 * Servlet implementation class InsertReportController
 */
@WebServlet("/report.rv")
public class InsertReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int restNo = Integer.parseInt(request.getParameter("restNo"));
		int memNo = ((Member)request.getSession().getAttribute("loginMember")).getMemNo();
		int susNo = Integer.parseInt(request.getParameter("suspectNo"));
		String report = request.getParameter("reportContent");
		
		int result = new RestaurantService().insertReport(memNo, susNo, report);
		
		System.out.println("멤 신고자" + memNo);
		System.out.println("피 신고자" + susNo);
		System.out.println("내용" + report);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "유저리뷰 신고가 성공적으로 작성되었습니다!");
			response.sendRedirect(request.getContextPath() + "/detail.rt?restNo=" + restNo);
		} else {
			request.setAttribute("errorMsg", "유저리뷰 신고에에 실패했습니다.");
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
