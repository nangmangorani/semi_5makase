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
import com.semi_5makase.restaurant.model.vo.Review;

/**
 * Servlet implementation class ReviewPictureController
 */
@WebServlet("/picture.rv")
public class ReviewPictureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewPictureController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int restNo = Integer.parseInt(request.getParameter("restNo"));
		
		System.out.println("ajax restNo : " + restNo);
		
		ArrayList<Review> revList = new ArrayList<Review>();
		ArrayList<Attachment> picList = new ArrayList<Attachment>();
		ArrayList totalList = new ArrayList<>();
		
		revList = new RestaurantService().selectReviewList(restNo);
		picList = new RestaurantService().selectReviewAttachment();
		
		totalList.add(revList);
		totalList.add(picList);
		
		
		System.out.println("서블렛 totalList : " + totalList);
		
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(totalList, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
