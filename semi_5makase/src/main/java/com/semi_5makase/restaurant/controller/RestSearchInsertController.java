package com.semi_5makase.restaurant.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.semi_5makase.common.model.vo.Attachment;
import com.semi_5makase.common.model.vo.MyFileRenamePolicy;
import com.semi_5makase.restTemp.RestaurantTemp;
import com.semi_5makase.restaurant.model.service.RestaurantService;

/**
 * Servlet implementation class RestSearchInsertController
 */
@WebServlet("/restSearchInsertRest.re")
public class RestSearchInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestSearchInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("이거되나?");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 10*1024*1024;
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/rest_upfiles/");
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			String restName = multiRequest.getParameter("restName");
			String restInfo = multiRequest.getParameter("restInfo");
			
			RestaurantTemp r = new RestaurantTemp();
			r.setRestName(restName);
			r.setRestInfo(restInfo);
			
			ArrayList<Attachment> list = new ArrayList<Attachment>();
			
			for(int i=1; i<=5; i++) {
				String key = "file" + i;
				
				if(multiRequest.getOriginalFileName(key) != null) {
					Attachment at = new Attachment();
					at.setOriginName(multiRequest.getOriginalFileName(key));
					at.setChangeName(multiRequest.getFilesystemName(key));
					at.setFilePath("resources/rest_upfiles");
					list.add(at);
					
					
				}
			}
			
			int result = new RestaurantService().insertRestTemp(r, list);
			HttpSession session = request.getSession();
			
			if(result > 0) {
				System.out.println("성공한건가");
				session.setAttribute("alertMsg", "성공적으로 등록요청 되었습니다.");
				response.sendRedirect(request.getContextPath());
			}else {
				session.setAttribute("alertMsg", "등록요청 실패했습니다.");
				response.sendRedirect(request.getContextPath() + "/restSearch.do");
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
