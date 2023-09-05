package com.semi_5makase.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.common.model.vo.PageInfo;
import com.semi_5makase.member.model.service.MemberService;
import com.semi_5makase.member.model.vo.Member;

/**
 * Servlet implementation class AdminMemberListController
 */
@WebServlet("/memberList.ad")
public class AdminMemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberListController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;	
		
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new MemberService().selectListCount();
		
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		pageLimit = 10;
		
		boardLimit = 10;
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Member> list = new MemberService().selectAdminMemberList();
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/admin/adminMemberList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
