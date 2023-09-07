package com.semi_5makase.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NumberCheckPwdController
 */
@WebServlet("/numberCheckPwd.me")
public class NumberCheckPwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NumberCheckPwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String AuthenticationKey = (String)request.getSession().getAttribute("AuthenticationKey");
        String AuthenticationUser = request.getParameter("checkNumber");
        String email = request.getParameter("email");
        
        
        System.out.println(AuthenticationKey);
        System.out.println(AuthenticationUser +"222");
        
        if(!AuthenticationKey.equals(AuthenticationUser))
        {
            System.out.println("인증번호 일치하지 않음");
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "인증번호 일치하지 않습니다");
			response.sendRedirect(request.getContextPath()+"/searchId.me");

        }else {
        	System.out.println("인증번호 일치");
    		HttpSession session = request.getSession();
    		
    		session.setAttribute("email", email);
    		
    		request.getSession().setAttribute("AuthenticationKey", AuthenticationKey);
    		response.sendRedirect(request.getContextPath()+"/checkNumPwd.me");
			
			

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
