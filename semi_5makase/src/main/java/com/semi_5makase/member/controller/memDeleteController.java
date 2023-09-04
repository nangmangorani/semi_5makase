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
 * Servlet implementation class memDeleteController
 */
@WebServlet("/memDeleteController.me")
public class memDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String memId = request.getParameter("memId");
		String memPwd = request.getParameter("memPwd");
		String reason = request.getParameter("reason");
		String textareaData = request.getParameter("textareaData");
		
		int result = new MemberService().memDelete(memId, memPwd);
		
		if(reason.equals("on")) {
			reason = textareaData;
		}
		
		Member m = new Member(memId, memPwd, reason);
		new MemberService().deleteReason(m);
		
		HttpSession session = request.getSession();
		
		if(result >0) {
			session.setAttribute("alertMsg", "성공적으로 회원 탈퇴 되었습니다. 그동안 이용해주셔서 감사합니다");
			session.removeAttribute("loginMember");
			response.sendRedirect(request.getContextPath());
			
		}else {
			session.setAttribute("alertMsg", "회원탈퇴 실패했습니다");
			response.sendRedirect(request.getContextPath()+"/myPage.me");
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
