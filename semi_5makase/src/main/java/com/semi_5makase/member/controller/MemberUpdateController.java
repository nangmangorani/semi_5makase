package com.semi_5makase.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.semi_5makase.member.model.service.MemberService;
import com.semi_5makase.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

			
		String memId = request.getParameter("memId");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String selfIntroduction = request.getParameter("selfIntroduction");
		
		Member m = new Member(memId, nickname, email, phone, address, selfIntroduction);
		
		Member updateMem = new MemberService().updateMember(m); // 프로필제외하고 수정
		
		if(updateMem != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", updateMem);
			session.setAttribute("alertMsg", "수정되었습니다");
			
			response.sendRedirect(request.getContextPath()+"/myPage.me");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", updateMem);
			session.setAttribute("alertMsg", "수정실패했습니다");
			
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
