package com.semi_5makase.restaurant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.member.model.vo.Member;
import com.semi_5makase.restaurant.model.service.RestaurantService;

/**
 * Servlet implementation class UpdateRestaurantController
 */
@WebServlet("/update.rt")
public class UpdateRestaurantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRestaurantController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int memNo = ((Member)request.getSession().getAttribute("loginMember")).getMemNo();
		int restNo = Integer.parseInt(request.getParameter("restNo"));
		String update = request.getParameter("updateRest");
		String closed = request.getParameter("closed");

		int result = new RestaurantService().updateRestaurant(memNo, update, restNo, closed);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "음식점 수정 제안이 성공적으로 작성되었습니다!");
			response.sendRedirect(request.getContextPath() + "/detail.rt?restNo=" + restNo);
		} else {
			request.setAttribute("errorMsg", "음식점 수정 제안 등록에 실패했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
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
