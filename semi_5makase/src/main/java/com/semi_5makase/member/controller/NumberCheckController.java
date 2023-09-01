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
 * Servlet implementation class NumberCheckController
 */
@WebServlet("/numCheck.me")
public class NumberCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NumberCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String AuthenticationKey = (String)request.getSession().getAttribute("AuthenticationKey");
        String AuthenticationUser = request.getParameter("checkNumber");
        
        System.out.println(AuthenticationKey);
        System.out.println(AuthenticationUser);
        
        if(!AuthenticationKey.equals(AuthenticationUser))
        {
            System.out.println("인증번호 일치하지 않음");
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "인증번호 일치하지 않습니다");
			response.sendRedirect(request.getContextPath()+"/searchId.me");

        }else {
        	System.out.println("인증번호 일치");
    		HttpSession session = request.getSession();
    		session.setAttribute("alertMsg", "인증번호 일치하지 않습니다");
    		response.sendRedirect(request.getContextPath()+"/searchIdResult.me");
			
			
			
//    		RequestDispatcher view = request.getRequestDispatcher("views/member/searchIdResult.jsp");
//    		view.forward(request, response);

			request.getSession().setAttribute("AuthenticationKey", AuthenticationKey);
			response.sendRedirect(request.getContextPath() + "/searchId.me");
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
