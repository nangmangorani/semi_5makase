package com.semi_5makase.restaurant.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.member.model.vo.Member;
import com.semi_5makase.restaurant.model.dao.RestaurantDao;
import com.semi_5makase.restaurant.model.service.RestaurantService;

/**
 * Servlet implementation class FavoriteRestaurantController
 */
@WebServlet("/updateFavorite.rt")
public class FavoriteRestaurantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoriteRestaurantController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 로그인 멤버 세션에 올린거 받아오기
		int memNo = 0;
		if((request.getSession().getAttribute("loginMember")) != null) {
			memNo = ((Member)request.getSession().getAttribute("loginMember")).getMemNo();
		}
		
		int restNo = Integer.parseInt(request.getParameter("restNo"));
		
		if(memNo == 0) { // 로그인 안돼있다면
			response.getWriter().print("loginFirst");
		} else {
			int result = new RestaurantService().checkFavoriteRestaurant(memNo, restNo);
			
			if(result > 0) { // 이미 등록되어있음.
				int result2 = new RestaurantService().deleteFavoriteRestaurant(memNo, restNo);
				response.getWriter().print("delete");
			} else { // 등록 안되어있음.
				int result2 = new RestaurantService().insertFavoriteRestaurant(memNo, restNo);
				response.getWriter().print("insert");
			}
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
