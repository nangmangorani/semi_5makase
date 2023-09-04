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
import com.semi_5makase.restaurant.model.vo.Category;
import com.semi_5makase.restaurant.model.vo.Menu;
import com.semi_5makase.restaurant.model.vo.TV;

/**
 * Servlet implementation class AdminRestaurantUpdateForm
 */
@WebServlet("/rtUpdateForm.ad")
public class AdminRestaurantUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRestaurantUpdateForm() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int restNo = Integer.parseInt(request.getParameter("num"));
		
		AdminRestaurant ar = new RestaurantService().adminSelectRestaurant(restNo);
		ArrayList<Menu> mlist = new RestaurantService().adminSelectRestaurantMenu(restNo);
		ArrayList<Category> clist = new RestaurantService().adminSelectCategory();
		ArrayList<TV> tlist = new RestaurantService().adminSelectTv();
		ArrayList<Attachment> alist = new RestaurantService().adminSelectAttatchment(restNo);
		
		request.setAttribute("ar", ar);
		request.setAttribute("mlist", mlist);
		request.setAttribute("clist", clist);
		request.setAttribute("tlist", tlist);
		request.setAttribute("alist", alist);
		request.getRequestDispatcher("views/admin/adminRestaurantUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
