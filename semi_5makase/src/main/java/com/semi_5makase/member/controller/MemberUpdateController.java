package com.semi_5makase.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.semi_5makase.common.MyFileRenamePolicy;
import com.semi_5makase.member.model.service.MemberService;
import com.semi_5makase.member.model.vo.Attachment;
import com.semi_5makase.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		if(ServletFileUpload.isMultipartContent(request)) {

			int maxSize = 10*1024*1024;
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/profile/");
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			int memNo = Integer.parseInt(multiRequest.getParameter("memNo"));
			String memId = multiRequest.getParameter("memId");
			String nickname = multiRequest.getParameter("nickname");
			String email = multiRequest.getParameter("email");
			String phone = multiRequest.getParameter("phone");
			String address = multiRequest.getParameter("address");
			String selfIntroduction = multiRequest.getParameter("selfIntroduction");
			
			Member m = new Member(memId, nickname, email, phone, address, selfIntroduction);
			
			
			
			
			Attachment at = null;
			
			if(multiRequest.getOriginalFileName("upfile") !=null) { // 넘어온 첨부파일이 있다
				
				
				at = new Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("upfile"));
				at.setChangeName(multiRequest.getFilesystemName("upfile"));
				at.setFilePath("resources/profile");
				

				int result = new MemberService().updateProfile(at,memNo);
				
				Attachment pf = new MemberService().selectAttachment(memNo);
//				response.sendRedirect(request.getContextPath() + "/myPage.me");
				
				System.out.println(pf+"마지막");

				
			
				Member updateMem = new MemberService().updateMember(m); // 프로필제외하고 수정
				if(updateMem != null) {
					HttpSession session = request.getSession();
					session.setAttribute("loginMember", updateMem);
					session.setAttribute("alertMsg", "수정되었습니다");
					
					response.sendRedirect(request.getContextPath()+"/myPage.me");
				}else {
					HttpSession session = request.getSession();
					session.setAttribute("loginMember", updateMem);
					session.setAttribute("alertMsg", "수정실패했습니다");
					
					response.sendRedirect(request.getContextPath()+"/myPage.me");
				}
			}else {  // 넘어온 첨부파일이 없을때
				
				Member updateMem = new MemberService().updateMember(m);
				if(updateMem != null) {
					HttpSession session = request.getSession();
					session.setAttribute("loginMember", updateMem);
					session.setAttribute("alertMsg", "수정되었습니다");
					
					response.sendRedirect(request.getContextPath()+"/myPage.me");
				}else {
					HttpSession session = request.getSession();
					session.setAttribute("loginMember", updateMem);
					session.setAttribute("alertMsg", "수정실패했습니다");
					
					response.sendRedirect(request.getContextPath()+"/myPage.me");
				}
				
			}
			
<<<<<<< HEAD
			int result = new MemberService().updateProfile(at,memNo);
			
			Attachment pf = new MemberService().selectAttachment(memNo);
			System.out.println(pf+"마지막");
			
			request.setAttribute("pf", pf);
			RequestDispatcher view = request.getRequestDispatcher("views/member/clientMyPage.jsp");
			view.forward(request, response);
			
=======
	
>>>>>>> 28bb964da677beb3d3b4b66ee62018bd8d241e85

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
