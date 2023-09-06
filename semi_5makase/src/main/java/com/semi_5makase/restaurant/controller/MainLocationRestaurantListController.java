package com.semi_5makase.restaurant.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.restaurant.model.service.RestaurantService;
import com.semi_5makase.restaurant.model.vo.Restaurant;

/**
 * Servlet implementation class MainLocationRestaurantListController
 */
@WebServlet("/mainLc.rt")
public class MainLocationRestaurantListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainLocationRestaurantListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sVal = request.getParameter("value");
		String cateName = request.getParameter("cateName");
		
		ArrayList<Restaurant> list = new RestaurantService().selectLocationRcList(sVal);
		
		System.out.println("sval : " + sVal);
		System.out.println("cateName : " + cateName);
		System.out.println("lcList : " + list);
		
		request.setAttribute("locationList", list);
		request.setAttribute("categoryName", cateName);
		request.getRequestDispatcher("views/restaurant/restaurantRecommendList.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
