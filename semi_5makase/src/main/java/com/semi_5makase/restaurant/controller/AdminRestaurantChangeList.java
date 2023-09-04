package com.semi_5makase.restaurant.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.common.model.vo.PageInfo;
import com.semi_5makase.restaurant.model.service.RestaurantService;
import com.semi_5makase.restaurant.model.vo.AdminUpdateRestaurant;

/**
 * Servlet implementation class AdminRestaurantChangeList
 */
@WebServlet("/rtChangeList.ad")
public class AdminRestaurantChangeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRestaurantChangeList() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;	
		
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new RestaurantService().selectChangeListCount();
		
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		pageLimit = 10;
		
		boardLimit = 10;
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<AdminUpdateRestaurant> list = new RestaurantService().adminSelectRestChange(pi);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/admin/adminRestaurantChangeList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
