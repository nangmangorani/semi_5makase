package com.semi_5makase.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.member.model.service.MemberService;
import com.semi_5makase.member.model.vo.Report;

/**
 * Servlet implementation class AdminReportDetail
 */
@WebServlet("/reportDetail.ad")
public class AdminReportDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReportDetail() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int reportNo = Integer.parseInt(request.getParameter("num"));
		Report rep = new MemberService().adminSelectReportDetail(reportNo);
		
		if(rep != null) {
			request.setAttribute("rep", rep);
			request.getRequestDispatcher("views/admin/adminReportDetail.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsmg", "조회를 실패했습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
