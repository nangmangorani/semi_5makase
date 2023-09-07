package com.semi_5makase.restaurant.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.semi_5makase.common.model.vo.Attachment;
import com.semi_5makase.restaurant.model.service.RestaurantService;
import com.semi_5makase.restaurant.model.vo.Restaurant;

/**
 * Servlet implementation class RestOptionController
 */
@WebServlet("/restOption.do")
public class RestOptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestOptionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchVal = request.getParameter("searchVal");
		int ageVal = Integer.parseInt(request.getParameter("ageVal"));
		int ageVal2 = ageVal+9;
		int categoryVal = Integer.parseInt(request.getParameter("categoryVal"));
		String locationVal = request.getParameter("locationVal");
		int tvVal = Integer.parseInt(request.getParameter("tvVal"));
		
		ArrayList<Restaurant> optionList = new RestaurantService().selectOptionList(searchVal,ageVal,ageVal2,categoryVal,locationVal,tvVal);
		ArrayList<Attachment> atList = new RestaurantService().selectRestAttachment();
		ArrayList totalList = new ArrayList();
		totalList.add(optionList);
		totalList.add(atList);

		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(totalList,response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
