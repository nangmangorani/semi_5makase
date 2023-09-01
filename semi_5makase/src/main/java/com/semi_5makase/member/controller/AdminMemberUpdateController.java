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

/**
 * Servlet implementation class AdminMemberUpdate
 */
@WebServlet("/memberUpdate.ad")
public class AdminMemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberUpdateController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int no = Integer.parseInt(request.getParameter("num"));
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String grade = request.getParameter("grade");
		String status = request.getParameter("status");
		
		Member m = new Member();
		m.setMemNo(no);
		m.setAddress(address);
		m.setPhone(phone);
		m.setEmail(email);
		m.setMemGrade(grade);
		m.setStatus(status);
		
		int result = new MemberService().updateAdminMember(m);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "회원정보를 수정하였습니다.");
			response.sendRedirect(request.getContextPath() + "/memberDetail.ad?num=" + no);
		} else {
			request.setAttribute("errorMsg", "회원 정보 수정에 실패했습니다.");
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
