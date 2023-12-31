package com.semi_5makase.restaurant.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.common.model.vo.Attachment;
import com.semi_5makase.restaurant.model.service.RestaurantService;
import com.semi_5makase.restaurant.model.vo.Menu;
import com.semi_5makase.restaurant.model.vo.Restaurant;
import com.semi_5makase.restaurant.model.vo.Review;
import com.semi_5makase.restaurant.model.vo.ReviewNo;

/**
 * Servlet implementation class RestaurantDetailView
 */
@WebServlet("/detail.rt")
public class RestaurantDetailView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantDetailView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int restNo = Integer.parseInt(request.getParameter("restNo"));
		
		RestaurantService rSer = new RestaurantService();
		
		int restaurantViewCount = rSer.increaseRestaurantView(restNo);
		
		if(restaurantViewCount > 0) {
			
			Restaurant rest = rSer.selectRestaurantDetail(restNo); // 음식점 상세정보
			ArrayList<Menu> list = rSer.selectMenuList(restNo); // 음식점 메뉴
			int favoriteCount = rSer.selectFavoriteCount(restNo); // 즐겨찾기 수
			double selectReviewRatingAvg = Math.round(rSer.selectReviewRatingAvg(restNo) * 10) / 10; // 별점 평균
			ArrayList<Review> rvList = rSer.selectReviewList(restNo);
			ArrayList<Review> rvNoList = rSer.selectReviewNoList(restNo);		
			ArrayList<Attachment> rvPicList = rSer.selectReviewAttachment(restNo);
			ArrayList<Attachment> profileList = rSer.selectProfileAttachment();
			
			int[] rvNo = new int[rvNoList.size()];
			for(int i=0; i<rvNoList.size(); i++) {
				rvNo[i] = rvNoList.get(i).getReviewNo();
			}
			
			ArrayList rvNo2 = new ArrayList();
			
			 for (int i = 0; i < rvNoList.size(); i++) {
	      	        rvNo2.add(rvNoList.get(i).getReviewNo());
	      	        
			 }
			 
			 System.out.println(rvNo2);
			
			
			System.out.println("rvNoList : " + rvNoList);
 
			request.getSession().setAttribute("rest", rest);
			request.getSession().setAttribute("selectReviewRatingAvg", selectReviewRatingAvg);
			
			request.setAttribute("list", list);
			request.setAttribute("rvNo", rvNo);			
			request.setAttribute("rvNo2", rvNo2);			
			request.setAttribute("favoriteCount", favoriteCount);		
			request.setAttribute("rvList", rvList);
			request.setAttribute("rvNoList", rvNoList);
			request.setAttribute("rvPicList", rvPicList);
			request.setAttribute("profileList", profileList);

			request.getRequestDispatcher("views/restaurant/restaurantDetailView.jsp").forward(request, response);	
		} else {
			request.setAttribute("errorMsg", "음식점 상세페이지 조회에 실패하였습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		}
			
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
