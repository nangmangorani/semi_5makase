package com.semi_5makase.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.member.model.service.MemberService;
import com.semi_5makase.member.model.vo.Member;
import com.semi_5makase.member.model.vo.Report;

/**
 * Servlet implementation class AdminMemberUpdate
 */
@WebServlet("/reportUpdate.ad")
public class AdminReportUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReportUpdate() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int reportNo = Integer.parseInt(request.getParameter("num"));
		String status = request.getParameter("result");
		
		Report rep = new Report();
		rep.setReportNo(reportNo);
		rep.setResult(status);
		
		int result = new MemberService().adminUpdaterReport(rep);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "처리 여부를 반영하였습니다.");
			response.sendRedirect(request.getContextPath() + "/reportList.ad?cpage=1");
		} else {
			request.setAttribute("errorMsg", "처리 여부 반영을 실패하였습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
