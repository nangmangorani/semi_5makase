<%@page import="com.semi_5makase.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath(); 
	Member loginMember = (Member)session.getAttribute("loginMember");
	String alertMsg = (String)session.getAttribute("alertMsg");
%>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
		
 
    </head>
    <style>
        div { box-sizing: border-box; }
    
        .menubar-area {
            position: sticky;
            top: 0;
            height: 110px;
            width: 1100px;
            margin: auto;
            background-color: white;
            z-index: 5;
        }
    
        .logo-area>img {
            margin-left: 45px;
            max-width: 90%;
            max-height: 90%;
        }
    
        .logo-area,
        .searchbar-area,
        .member-area {
            height: 100px;
            float: left;
        }
    
        .logo-area,
        .member-area {
            width: 20%;
        }
    
        .member-area a {
            text-decoration: none;
            color: black;
            line-height: 90px;
            margin: 20px;
            font-size: 12px;
        }
    
        .searchbar-area {
            width: 60%;
            position: relative;
        }
    
        .searchbar-area input[type=text] {
            border-radius: 200px;
            width: 400px;
            height: 40px;
            margin: 25px 50px;
            background-color: rgb(240, 240, 240);
            border-color: white;
            padding-right: 30px;
        }
    
        .searchbar-area button {
            position: absolute;
            top: 50%;
            right: 200px;
            transform: translateY(-60%);
            border: 0;
            cursor: pointer;
        }
    
        .modal_wrap {
        display: none;
        width: 500px;
        height: 500px;
        position: fixed; /* Use fixed positioning */
        bottom: 100px; /* Adjust the bottom position to move it to the bottom */
        left: 50%;
        transform: translateX(-50%);
        background: #eee;
        z-index: 1;
    }
    
    
        .black_bg {
            display: none;
            position: absolute;
            content: "";
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            top: 0;
            left: 0;
            z-index: 2;
        }
    
        .modal_close {
            width: 26px;
            height: 26px;
            position: absolute;
            top: -30px;
            right: 0;
        }
    
        .modal_close> a {
            display: block;
            width: 100%;
            height: 100%;
            background: url(https://img.icons8.com/metro/26/000000/close-window.png);
            text-indent: -9999px;
        }
    
        #modal_btn {
            margin-top: 20px;
        }
    
        .form-control{
            width: 300px;
        }
        
    </style>
    <body>
    	<% if(alertMsg != null){ %>
	
		<script>
			alert("<%= alertMsg %>");
		</script>
		<% session.removeAttribute("alertMsg"); %>
		<% } %>
    
        <div class="menubar-area">
            <div class="logo-area">
                <img src="resources/img/logo.png">
            </div>
            <div class="searchbar-area">
                <form action="">
                    <input type="text" placeholder="     지역, 음식 또는 식당명을 입력해주세요. " style="border: 0px;">
                    <button type="submit"><img src="resources/img/searchIcon.png"></button>
                </form>
            </div>
            <div class="member-area" align="center" style="margin-top: 10px;">
			<%if(loginMember == null){ %>
          		<!-- case2. 로그인 전  -->
                <button type='button' id="modal_btn" data-target="#loginModal">로그인</button>
                <button type="button" onclick="enrollPage()">회원가입</button>
              <%}else{ %>
                <!-- case2. 로그인 후  -->
			        <div>
			            <b><%= loginMember.getMemName()%>님</b> 환영합니다. <br>
			            <div align="center">
			                <a href="<%=contextPath %>/myPage.me">마이페이지</a>
			                <a href="<%=contextPath %>/logout.me">로그아웃</a>
			            </div>
			        </div>
			     <%} %>
                
                
                
                <div class="black_bg"></div>
                <div class="modal_wrap">
                    <div class="modal_close"><a href="#">close</a></div>
                        <div>
                            <form action="<%=contextPath %>/login.me" method="post">
                                <div class="member_login_input" style="margin-top: 100px;">
                                    <input type="text" class="form-control" name="memId" placeholder="아이디" >
                                </div>
                    
                                <div class="member_login_input">
                                    <input type="password" class="form-control" name="memPwd" placeholder="비밀번호">
                                </div>
                                <br>
                                <div class="member_login_btn"> 
        
                                    <input type="submit" class="btn btn-secondary" id="btn-login" value="로그인">
                                    <input type="button" class="btn btn-secondary" value="회원가입" onclick="enrollPage()"> <br>
                                    <input type="button" class="btn btn-sm" value="아이디찾기" onclick="enrollPage1()">
                                    <input type="button" class="btn btn-sm" value="비밀번호 찿기" onclick="enrollPage2()">
                    				
                                </div>
                                
                                <script >
						            function enrollPage(){
						            	location.href = "<%=contextPath%>/agreement.me";
						            }
									function enrollPage1(){
						            	
						            	location.href = "<%=contextPath%>/searchId.me";
						            }
									function enrollPage2(){
						            	
						            	location.href = "<%=contextPath%>/searchPwdOne.me";
						            }
						        </script>
                            </form>
                        </div>
                </div>
            </div>
        </div>
    
        <script>

                function onClick() {
                    document.querySelector('.modal_wrap').style.display = 'block';
                    document.querySelector('.black_bg').style.display = 'block';
                }
                function offClick() {
                    document.querySelector('.modal_wrap').style.display = 'none';
                    document.querySelector('.black_bg').style.display = 'none';
                }
    
                document.getElementById('modal_btn').addEventListener('click', onClick);
                document.querySelector('.modal_close').addEventListener('click', offClick);

        </script>
    </body>
    </html>
    