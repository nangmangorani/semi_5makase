package com.semi_5makase.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi_5makase.member.model.service.MemberService;
import com.semi_5makase.member.model.vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.me")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String memId = request.getParameter("memId");
		String memPwd = request.getParameter("memPwd");
		System.out.println(memId);
		System.out.println(memPwd);
		Member loginMember = new MemberService().loginMember(memId,memPwd);
		
		if(loginMember == null) {
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "로그인 실패했습니다"); // request는 포워딩 방식일때만 가능!!
			response.sendRedirect(request.getContextPath());


		}else {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			response.sendRedirect(request.getHeader("referer")); 
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
