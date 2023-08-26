package com.semi_5makase.restaurant.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.restaurant.model.dao.RestaurantDao;
import com.semi_5makase.restaurant.model.service.RestaurantService;
import com.semi_5makase.restaurant.model.vo.Menu;
import com.semi_5makase.restaurant.model.vo.Restaurant;

/**
 * Servlet implementation class RestaurantDetailView
 */
@WebServlet("/detail.rt")
public class RestaurantDetailView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantDetailView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		int restNo = Integer.parseInt(request.getParameter("restNo"));
		
		RestaurantService rSer = new RestaurantService();
		
		Restaurant rest = rSer.selectRestaurantDetail(restNo);
		ArrayList<Menu> list = rSer.selectMenuList(restNo);
		int favoriteCount = rSer.selectFavoriteCount(restNo);
		int reviewCount = rSer.selectReviewCount(restNo);
		double selectReviewRatingAvg = rSer.selectReviewRatingAvg(restNo);
		
		request.setAttribute("rest", rest);
		request.setAttribute("list", list);
		request.setAttribute("favoriteCount", favoriteCount);
		request.setAttribute("reviewCount", reviewCount);
		request.setAttribute("selectReviewRatingAvg", selectReviewRatingAvg);
		
		request.getRequestDispatcher("views/restaurant/restaurantDetailView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
