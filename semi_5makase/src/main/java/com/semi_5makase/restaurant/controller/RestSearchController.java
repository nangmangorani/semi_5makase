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
 * Servlet implementation class RestSearchController
 */
@WebServlet("/restSearch.do")
public class RestSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchVal = request.getParameter("searchVal");
		
		ArrayList<Restaurant> locationList = new RestaurantService().selectRestSearch(searchVal);
		//ArrayList<Restaurant> reviewList = new RestaurantService().reviewList(searchVal);
		
		request.setAttribute("locationList", locationList);
		request.setAttribute("searchVal", searchVal);
		
		
		if(locationList != null) {
			System.out.println("실행되나");
			//ArrayList<Attachment> list = new RestaurantService().selectRestThumbnail();
		}
		
		
		
		

				
		
		//	즐겨찾기순,평점순, 조회수순 #@!#!@#!@#
			if(request.getParameter("val") != null) { // ajax 요청했을 경우
				int num = Integer.parseInt(request.getParameter("val"));
				
				switch(num) {
					case 1: System.out.println("조회수순내놔"); 
						ArrayList<Restaurant> viewList = new RestaurantService().viewList(searchVal);
						ArrayList<Attachment> atList1 = new RestaurantService().selectRestAttachment();
						ArrayList totalList1 = new ArrayList();
						totalList1.add(viewList);
						totalList1.add(atList1);
						response.setContentType("application/json; charset=utf-8");
						new Gson().toJson(totalList1, response.getWriter());
						break;
					
					case 2: System.out.println("평점순내놔");
						ArrayList<Restaurant> ratingList = new RestaurantService().ratingList(searchVal);
						ArrayList<Attachment> atList2 = new RestaurantService().selectRestAttachment();
						ArrayList totalList2 = new ArrayList();
						totalList2.add(ratingList);
						totalList2.add(atList2);						
						response.setContentType("application/json; charset=utf-8");
						new Gson().toJson(totalList2, response.getWriter());
						break;
					
					case 3: System.out.println("즐겨찾기순내놔"); 
						ArrayList<Restaurant> favoritList = new RestaurantService().favoritList(searchVal);
						ArrayList<Attachment> atList3 = new RestaurantService().selectRestAttachment();
						ArrayList totalList3 = new ArrayList();
						totalList3.add(favoritList);
						totalList3.add(atList3);		
						response.setContentType("application/json; charset=utf-8");
						new Gson().toJson(totalList3, response.getWriter());
						break;
						
						//큰의ㅏ미없어서 시간남으면 ㄱㄱㄱ
					case 4: System.out.println("리뷰순내놔"); break;
				}
				
			
		}else { // 동기식임 => 검색 시
			request.getRequestDispatcher("/views/restaurant/restaurantSearchPage.jsp").forward(request, response);
		}
		
		
		//지역,음식 또는 식당명
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
