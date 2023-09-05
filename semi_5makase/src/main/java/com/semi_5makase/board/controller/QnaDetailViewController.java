package com.semi_5makase.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi_5makase.board.model.service.QnaService;
import com.semi_5makase.board.model.vo.Qna;
import com.semi_5makase.common.model.vo.Attachment;

/**
 * Servlet implementation class QnaDetailViewController
 */
@WebServlet("/detail.qna")
public class QnaDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaDetailViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 1. NUM받고
		// 2. q에서는 게시글
		// 3. Attachment list 만들고 배열 받아서 setAttribute
		// 4. jsp에서 받아서 맨위에 list째로 올리고 for문으로 첨부파일란에 뿌리기
		
		int qnaNo = Integer.parseInt(request.getParameter("num"));
		
		int result = new QnaService().increaseQnaViews(qnaNo);
		
		
		if(result > 0) {
			Qna q = new QnaService().selectQna(qnaNo);
			if(q.getReply().equals("Y")) {
				q.setReply("답변완료");
			} else {
				q.setReply("진행중");
			}
			
			if(q.getOpen().equals("Y")) {
				q.setOpen("공개");
			} else {
				q.setOpen("비공개");
			}
			
			Attachment at = new QnaService().selectAttachment(qnaNo);
			
			System.out.println(q.getReplyContent());
			
			request.setAttribute("q", q);
			request.setAttribute("at", at);
			request.getRequestDispatcher("views/board/qnaDetailView.jsp").forward(request, response);
			
			
			
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
