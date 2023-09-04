package com.semi_5makase.restaurant.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.member.model.vo.Member;
import com.semi_5makase.restaurant.model.service.RestaurantService;

/**
 * Servlet implementation class CheckLikes
 */
@WebServlet("/checkLikes.rv")
public class CheckLikes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLikes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int memNo = ((Member)request.getSession().getAttribute("loginMember")).getMemNo();
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		
		System.out.println("체크라잌 리뷰넘 : " + reviewNo);
		
		int likes = new RestaurantService().checkReviewLikes(memNo, reviewNo);

		response.getWriter().print(likes);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
