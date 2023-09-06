package com.semi_5makase.restaurant.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.restaurant.model.service.RestaurantService;
import com.semi_5makase.restaurant.model.vo.AdminRestaurant;
import com.semi_5makase.common.model.vo.Attachment;
import com.semi_5makase.restaurant.model.vo.Menu;

/**
 * Servlet implementation class AdminRestaurantDetail
 */
@WebServlet("/rtDetail.ad")
public class AdminRestaurantDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRestaurantDetail() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int restNo = Integer.parseInt(request.getParameter("num"));
		
		AdminRestaurant ar = new RestaurantService().adminSelectRestaurant(restNo);
		
		ArrayList<Menu> list = new RestaurantService().adminSelectRestaurantMenu(restNo);
		
		ArrayList<Attachment> alist = new RestaurantService().adminSelectAttatchment(restNo);
		
		if(ar != null) {
			request.setAttribute("ar", ar);
			request.setAttribute("list", list);
			request.setAttribute("alist", alist);
			request.getRequestDispatcher("views/admin/adminRestaurantDetail.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "조회를 실패했습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
