package com.semi_5makase.member.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi_5makase.member.model.service.MemberService;
import com.semi_5makase.member.model.vo.Member;

/**
 * Servlet implementation class EmailCheckPwdController
 */
@WebServlet("/emailCheckPwd.me")
public class EmailCheckPwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailCheckPwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String memId = request.getParameter("memId");
		String email = request.getParameter("email");
		System.out.println(memId + "여기!~~~~");
		System.out.println(email + "여기!~~~~");
		
		
		Member m = new MemberService().emailcheck(memId); 
		
		System.out.println(m+"~~~~~~~~~~~~~~~~");
		if(!m.getEmail().equals(email)) {
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "아이디나 이메일 정보가 맞지 않습니다");
			response.sendRedirect(request.getContextPath()+"/searchId.me");
		}
		
		String host = "smtp.naver.com";
		String user = "kjw970208@naver.com";
		String password = "wndnjs5602@";
		
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
