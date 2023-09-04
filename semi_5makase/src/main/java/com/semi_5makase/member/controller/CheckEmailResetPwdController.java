package com.semi_5makase.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi_5makase.member.model.service.MemberService;
import com.semi_5makase.member.model.vo.Member;

/**
 * Servlet implementation class CheckEmailResetPwdController
 */
@WebServlet("/checkEmailResetPwd.me")
public class CheckEmailResetPwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckEmailResetPwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String memId = request.getParameter("memId");
		String newPwd = request.getParameter("newPwd");
		String checkPwd = request.getParameter("checkPwd");
		String memPwd = request.getParameter("memPwd");

		
		
		Member resetPwd1 = new MemberService().resetPwd(memId,memPwd,newPwd,checkPwd);
		
		HttpSession session = request.getSession(); 
		
		if(resetPwd1 == null) {
			session.setAttribute("alertMsg", "비밀번호 변경에 실패했습니다");
		}else {
			session.setAttribute("alertMsg", "비밀번호가 변경됐습니다");
		}

		

		response.sendRedirect(request.getContextPath());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
