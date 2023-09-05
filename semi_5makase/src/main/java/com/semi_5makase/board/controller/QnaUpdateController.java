package com.semi_5makase.board.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.semi_5makase.board.model.service.QnaService;
import com.semi_5makase.board.model.vo.Qna;
import com.semi_5makase.common.MyFileRenamePolicy;
import com.semi_5makase.common.model.vo.Attachment;

/**
 * Servlet implementation class QnaUpdateController
 */
@WebServlet("/update.qna")
public class QnaUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaUpdateController() {
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
			
			String boardWriter = multiRequest.getParameter("boardWriter");
			String boardTitle = multiRequest.getParameter("title");
			String boardContent = multiRequest.getParameter("content");
			int qnaNo = Integer.parseInt(multiRequest.getParameter("qnaNo"));
			Qna q = new Qna();
			
			q.setBoardWriter(boardWriter);
			q.setBoardTitle(boardTitle);
			q.setBoardContent(boardContent);
			q.setQnaNo(qnaNo);
			
			Attachment at = null;
			
				if(multiRequest.getOriginalFileName("upfile") != null) {
					at = new Attachment();
					at.setRefBno(qnaNo);
					at.setOriginName(multiRequest.getOriginalFileName("upfile"));
					at.setChangeName(multiRequest.getFilesystemName("upfile"));
					at.setFilePath("resources/qnaAttachment");
					
					if(multiRequest.getParameter("originFileNo") != null) {
						// 기존에 첨부파일이 있었을 경우 => Update Attachment (기존의 첨부파일 번호 필요)
						at.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo")));
					} else {
						// 기존에 첨부파일이 없었을 경우 => Insert Attachment (현재 게시글 번호 필요)
						at.setRefBno(qnaNo);
					}
					System.out.println("여기도 컨트롤러" + multiRequest.getParameter("originFileNo"));
				}
			
			
			int result = new QnaService().updateQna(q, at);
			
			if(result > 0) {
				request.getSession().setAttribute("alertMsg", "성공적으로 수정되었습니다.");
				response.sendRedirect(request.getContextPath() + "/detail.qna?num=" + qnaNo);
			} else {
				// 실패
				request.setAttribute("errorMsg", "Q&A 수정에 실패했습니다.");
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
