package com.semi_5makase.restaurant.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.restaurant.model.service.RestaurantService;
import com.semi_5makase.restaurant.model.vo.Restaurant;

/**
 * Servlet implementation class SelectMainRestaurantListController
 */
@WebServlet("/main.rt")
public class SelectMainRestaurantListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectMainRestaurantListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cateNo = Integer.parseInt(request.getParameter("value"));
		String cateName = request.getParameter("cateName");
		
		System.out.println("카테넘넘넘 : " + cateNo);
		System.out.println("갔나요?");

		ArrayList<Restaurant> list =  new ArrayList<Restaurant>();
				
		list = new RestaurantService().selectCategoryList(cateNo);
		
		System.out.println("리스트 : " + list);
		System.out.println("리렝 : " + list.get(1).getIntro().length());

		request.setAttribute("categoryList", list);
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
