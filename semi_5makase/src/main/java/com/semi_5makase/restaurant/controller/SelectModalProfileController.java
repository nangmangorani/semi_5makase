package com.semi_5makase.restaurant.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.semi_5makase.common.model.vo.Attachment;
import com.semi_5makase.restaurant.model.service.RestaurantService;

/**
 * Servlet implementation class SelectModalProfileController
 */
@WebServlet("/profile.rv")
public class SelectModalProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectModalProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int refBno = Integer.parseInt(request.getParameter("refBno"));
		int memNo = new RestaurantService().selectMemNo(refBno);
		
		Attachment at = new RestaurantService().selectModalProfile(memNo);
		
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(at, response.getWriter());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
