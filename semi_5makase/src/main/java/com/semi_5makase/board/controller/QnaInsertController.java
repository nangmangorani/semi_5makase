package com.semi_5makase.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.semi_5makase.board.model.service.FaqService;
import com.semi_5makase.board.model.service.QnaService;
import com.semi_5makase.board.model.vo.Faq;
import com.semi_5makase.board.model.vo.Qna;
import com.semi_5makase.common.MyFileRenamePolicy;
import com.semi_5makase.common.model.vo.Attachment;

/**
 * Servlet implementation class QnaInsertController
 */
@WebServlet("/insert.qna")
public class QnaInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaInsertController() {
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
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/qnaAttachment/");
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			String userNo = multiRequest.getParameter("userNo");
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			String open = multiRequest.getParameter("open");
			
			Qna q = new Qna();
			q.setBoardTitle(title);
			q.setBoardContent(content);
			q.setBoardWriter(userNo);
			q.setOpen(open);
			
			System.out.println("q: " + q);
			
			ArrayList<Attachment> list = new ArrayList<Attachment>();
			
			
			for(int i =1; i<=5; i++) {
				String key = "upfile" + i;
				
				if(multiRequest.getOriginalFileName(key) != null) {
					Attachment at = new Attachment();
					at.setOriginName(multiRequest.getOriginalFileName(key));
					at.setChangeName(multiRequest.getFilesystemName(key));
					at.setFilePath("resources/qnaAttachment");
					list.add(at);
					
				}
				
			}
			
			int result = new QnaService().insertBoard(q, list);
			if(result > 0) {
				// 성공 => /jsp/list.bo?cpage=1 url 재요청 => 목록페이지
				
				response.sendRedirect(request.getContextPath() + "/list.qna?cpage=1");
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
