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
import com.semi_5makase.common.MyFileRenamePolicy;
import com.semi_5makase.restaurant.model.service.RestaurantService;
import com.semi_5makase.restaurant.model.vo.AdminRestaurant;
import com.semi_5makase.restaurant.model.vo.Attachment;
import com.semi_5makase.restaurant.model.vo.Category;
import com.semi_5makase.restaurant.model.vo.Menu;
import com.semi_5makase.restaurant.model.vo.TV;
import com.semi_5makase.restaurant.model.vo.Time;

/**
 * Servlet implementation class AdminRestaurantAdd
 */
@WebServlet("/rtAdd.ad")
public class AdminRestaurantAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRestaurantAdd() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 10*1024*1024;
			String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");
			
			MultipartRequest multiRequest= new MultipartRequest(request, savePath, maxSize, "utf-8", new MyFileRenamePolicy());
			
			String restName = multiRequest.getParameter("restName");
			String restAddress = multiRequest.getParameter("restAddress");
			String phone = multiRequest.getParameter("phone");
			String parking = multiRequest.getParameter("parking");
			String category = multiRequest.getParameter("category");
			String tv = multiRequest.getParameter("tv");
			String menu1 = multiRequest.getParameter("menu1");
			String menu2 = multiRequest.getParameter("menu2");
			String menu3 = multiRequest.getParameter("menu3");
			int price1 = Integer.parseInt(multiRequest.getParameter("price1"));
			int price2 = Integer.parseInt(multiRequest.getParameter("price2"));
			int price3 = Integer.parseInt(multiRequest.getParameter("price3"));
			int menuGrade1 = Integer.parseInt(multiRequest.getParameter("menuGrade1"));
			int menuGrade2 = Integer.parseInt(multiRequest.getParameter("menuGrade2"));
			int menuGrade3 = Integer.parseInt(multiRequest.getParameter("menuGrade3"));
			String openTime = multiRequest.getParameter("openTime");
			String restTime = multiRequest.getParameter("restTime");
			String breakTime = multiRequest.getParameter("breakTime");
			String intro = multiRequest.getParameter("intro");
			String status = multiRequest.getParameter("status");
			
			AdminRestaurant ar = new AdminRestaurant();
			ar.setRestName(restName);
			ar.setRestAddress(restAddress);
			ar.setRestPhone(phone);
			ar.setParking(parking);
			ar.setIntro(intro);
			ar.setStatus(status);
			ar.setCategory(category);
			ar.setTv(tv);
			
			Menu m1 = new Menu();
			m1.setMenu(menu1);
			m1.setPrice(price1);
			m1.setMenuGrade(menuGrade1);
			
			Menu m2 = new Menu();
			m2.setMenu(menu2);
			m2.setPrice(price2);
			m2.setMenuGrade(menuGrade2);
			
			Menu m3 = new Menu();
			m3.setMenu(menu3);
			m3.setPrice(price3);
			m3.setMenuGrade(menuGrade3);
			
			Time t = new Time();
			t.setOpenTime(openTime);
			t.setRestTime(restTime);
			t.setBreakTime(breakTime);
			
			Attachment at = new Attachment();
			at.setOriginName(multiRequest.getOriginalFileName("file1"));
			at.setChangeName(multiRequest.getFilesystemName("file1"));
			at.setFilePath("resources/board_upfiles");
			System.out.println(at + "????????");
			
			
			ArrayList<Attachment> list = new ArrayList<Attachment>();
			for(int i=1; i<4; i++) {
				
				String key = "file" + i;
				
				if(multiRequest.getOriginalFileName(key)!=null) {
					
					Attachment at2 = new Attachment();
					at.setOriginName(multiRequest.getOriginalFileName(key));
					at.setChangeName(multiRequest.getFilesystemName(key));
					at.setFilePath("resources/board_upfiles");
					
					list.add(at2);
				}
			}
			System.out.println(list + "!!!!!!!!!!!!!!");
			
			int result = new RestaurantService().adminInsertRestaurant(ar, m1, m2, m3, t, list);
			
			
			if(result > 0) {
				response.sendRedirect(request.getContextPath() + "/rtList.ad?cpage=1");
			}else {
				request.setAttribute("errorMsg", "음식점 등록에 실패했습니다.");
				RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
				view.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
