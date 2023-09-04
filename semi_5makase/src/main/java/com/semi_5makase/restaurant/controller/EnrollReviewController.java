package com.semi_5makase.restaurant.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.semi_5makase.common.model.vo.MyFileRenamePolicy;
import com.semi_5makase.common.model.vo.Attachment;
import com.semi_5makase.member.model.vo.Member;
import com.semi_5makase.restaurant.model.service.RestaurantService;
import com.semi_5makase.restaurant.model.vo.Review;

/**
 * Servlet implementation class EnrollReviewController
 */
@WebServlet("/insertReview.rv")
public class EnrollReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollReviewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
					
			int maxSize = 10 * 1024 * 1024;
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/review_upfiles/");
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			int restNo = Integer.parseInt(multiRequest.getParameter("restNo"));

			Review rv = new Review();
			
			rv.setRating(Integer.parseInt(multiRequest.getParameter("rating")));
			rv.setMemNo(((Member)request.getSession().getAttribute("loginMember")).getMemNo());
			rv.setRestNo(restNo);
			rv.setReviewContent(multiRequest.getParameter("reviewContent"));
			
			ArrayList<Attachment> list = new ArrayList<Attachment>();
			Attachment at = null;
			
			for(int i=1; i<=4; i++) {
				
				String key = "file" + i;
				
				if(multiRequest.getOriginalFileName(key) != null) {
					at = new Attachment();
					
					at.setOriginName(multiRequest.getOriginalFileName(key));
					at.setChangeName(multiRequest.getFilesystemName(key));
					at.setFilePath("resources/review_upfiles");
					at.setCategory("REV");
					
					list.add(at);
				}
			}
			
//			for(int j=1; j<=3; j++) {
//				System.out.println("첨파 담긴거" + list.get(j).getOriginName());						
//			}

			int result = new RestaurantService().insertReview(rv, list);

			
			if(result > 0) {
				request.getSession().setAttribute("alertMsg", "리뷰가 성공적으로 작성되었습니다!");
				response.sendRedirect(request.getContextPath() + "/detail.rt?restNo=" + restNo);
			} else {
				request.setAttribute("errorMsg", "리뷰 등록에 실패했습니다.");
				RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
				view.forward(request, response);
			}
			
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
