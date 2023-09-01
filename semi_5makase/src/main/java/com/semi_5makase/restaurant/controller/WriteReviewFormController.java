package com.semi_5makase.restaurant.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.member.model.vo.Member;
import com.semi_5makase.restaurant.model.service.RestaurantService;
import com.semi_5makase.restaurant.model.vo.Restaurant;

/**
 * Servlet implementation class WriteReviewController
 */
@WebServlet("/insertReviewForm.rv")
public class WriteReviewFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteReviewFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memNo = ((Member)request.getSession().getAttribute("loginMember")).getMemNo();
		int restNo = Integer.parseInt(request.getParameter("restNo"));
		
		Restaurant rest = new RestaurantService().selectRestaurantDetail(restNo);
		String nickName =new RestaurantService().selectNickName(memNo);
		
		request.setAttribute("memNo", memNo);
		request.setAttribute("nickName", nickName);
		request.setAttribute("rest", rest);
		
		request.getRequestDispatcher("views/restaurant/ReviewWritePage.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
