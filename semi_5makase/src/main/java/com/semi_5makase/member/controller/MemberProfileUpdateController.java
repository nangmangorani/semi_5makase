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
import com.semi_5makase.common.model.vo.Attachment;
import com.semi_5makase.common.model.vo.MyFileRenamePolicy;
import com.semi_5makase.member.model.service.MemberService;
import com.semi_5makase.member.model.vo.Member;

/**
 * Servlet implementation class MemberProfileUpdateController
 */
@WebServlet("/updateProfile.me")
public class MemberProfileUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberProfileUpdateController() {
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
			
			Attachment at = null;
			System.out.println(multiRequest.getParameter("originFileNo")+"여기여기~~~~");
			
			if(multiRequest.getOriginalFileName("upfile") !=null) { // 넘어온 첨부파일이 있다
				
				
				at = new Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("upfile"));
				at.setChangeName(multiRequest.getFilesystemName("upfile"));
				at.setFilePath("resources/profile");
				
				System.out.println("오리진파일넘 이전전" + at);
				
				if(multiRequest.getParameter("originFileNo") != null) {
					// 기존에 첨부파일이 있었을 경우 => Update Attachment (기존의 첨부파일 번호 필요)
					at.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo")));
					System.out.println("오리진파일넘 이후" + at);
					
				}else {
					// 기존에 첨부파일이 없었을 경우 => Insert Attachment (현제 게시글 번호 필요)
					at.setRefBno(memNo);
				}
				
			
			}
			
			int result = new MemberService().updateProfile(at,memNo);
			
			if(result >0) {
				// 성공 
				request.getSession().setAttribute("alertMsg", "성공적으로 수정되었습니다");
				response.sendRedirect(request.getContextPath()+"/myPage.me");
				
			}else {
				// 실패
				request.getSession().setAttribute("alertMsg", "프로필 수정 실패!");
				response.sendRedirect(request.getContextPath()+"/myPage.me");

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
