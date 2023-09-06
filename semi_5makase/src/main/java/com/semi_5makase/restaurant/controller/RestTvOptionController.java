package com.semi_5makase.restaurant.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.semi_5makase.common.model.vo.Attachment;
import com.semi_5makase.restaurant.model.service.RestaurantService;
import com.semi_5makase.restaurant.model.vo.Restaurant;

/**
 * Servlet implementation class RestTvOptionController
 */
@WebServlet("/restTvOption.do")
public class RestTvOptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestTvOptionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryVal = Integer.parseInt(request.getParameter("category"));
		ArrayList<Restaurant> categoryList= new RestaurantService().selectCategory(categoryVal);
		
		ArrayList<Attachment> atList = new RestaurantService().selectRestAttachment();
		
//		request.setAttribute("atList", atList);
		
		ArrayList totalList = new ArrayList<>();
		totalList.add(categoryList);
		totalList.add(atList);
		

		
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(totalList, response.getWriter());

//		JsonObject responseJson = new JsonObject();
//		responseJson.add("categoryList", new Gson().toJsonTree(categoryList));
//		responseJson.add("atList", new Gson().toJsonTree(atList));
//		response.getWriter().write(responseJson.toString()); 이렇게하면 안됨ㅋ
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
