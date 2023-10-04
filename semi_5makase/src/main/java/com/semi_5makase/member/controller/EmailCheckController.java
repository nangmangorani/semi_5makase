package com.semi_5makase.member.controller;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;


import com.semi_5makase.member.model.service.MemberService;
import com.semi_5makase.member.model.vo.Member;

/**
 * Servlet implementation class EmailCheckController
 */
@WebServlet("/emailCheck.me")
public class EmailCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		Member m = new MemberService().emailcheckOne(email); 
		
		if(m==null || !m.getEmail().equals(email)) {
			request.setAttribute("erroeMsg", "이메일 정보가 맞지 않습니다");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}
		
		String host = "smtp.naver.com";
		String user = "@naver.com";
		String password = "";
		
		String to_email = m.getEmail();
		
		Properties props = new Properties();
		props.put("mail.smtp.host",host);
		props.put("mail.smtp.port", 465);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        
        StringBuffer temp =new StringBuffer();
        Random rnd = new Random();
        for(int i=0;i<10;i++)
        {
            int rIndex = rnd.nextInt(3);
            switch (rIndex) {
            case 0:
                // a-z
                temp.append((char) ((int) (rnd.nextInt(26)) + 97));
                break;
            case 1:
                // A-Z
                temp.append((char) ((int) (rnd.nextInt(26)) + 65));
                break;
            case 2:
                // 0-9
                temp.append((rnd.nextInt(10)));
                break;
            }
        }
        
        String AuthenticationKey = temp.toString();
        System.out.println(AuthenticationKey);
        
        HttpSession session1 = request.getSession();
        session1.setAttribute("AuthenticationKey", AuthenticationKey);
        
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user,password);
            }
        });
        
        MimeMessage msg = new MimeMessage(session);
        try {
			msg.setFrom(new InternetAddress(user, "이눔세끼"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
			
			msg.setSubject("안녕하세요 이눔세끼 인증 메일입니다.");
			msg.setText("인증 번호는 :"+temp);
			
			Transport.send(msg);
			System.out.println("이메일 전송");
			
			
		} catch (UnsupportedEncodingException | MessagingException e) {
			e.printStackTrace();
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
