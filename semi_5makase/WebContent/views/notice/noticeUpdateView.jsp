<%@page import="com.semi_5makase.notice.model.vo.Notice"%>
<%@page import="com.semi_5makase.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member loginMember = (Member)session.getAttribute("loginMember");
	String contextPath = request.getContextPath();
	Notice n = (Notice)request.getAttribute("n");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>
    <link rel="icon" href="resources/img/favicon.ico" type="image/x-icon" sizes="16x16">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

    <style>
        @font-face {
        font-family: 'SUITE-Regular';
        src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/SUITE-Regular.woff2') format('woff2');
        font-weight: 400;
        font-style: normal;
        }
        div {
            /* border: 1px solid black; */
            box-sizing: border-box;
            font-family: 'SUITE-Regular';
        }
        .wrap {
            width: 1000px;
            height: 800px;
            margin: auto;
        }

        .insertNoImg{
            width: 100%;
            height: 200px;
            background-color: lightgray;
            padding-left: 370px;
            padding-top: 70px;
        }

        .insertNoForm{
            width: 70%;
            height: 600px;
            padding-left: 80px;
            padding-top: 20px;
            margin: auto;
        }

        .noTitle{
            width: 500px;
        }

        .noContent{
            width: 500px;
            height: 400px;
        }

        .btn1{
            margin-left: 350px;
            margin-right: 10px;
            border: transparent;
            border-radius: 5px;
            width: 100px;
            height: 40px;
            background-color: rgb(21, 98, 189);
            font-weight: 500;
            color: white;
        }

        .btn2{
            border: transparent;
            border-radius: 5px;
            width: 100px;
            height: 40px;
            background-color: rgb(21, 98, 189);
            font-weight: 500;
            color: white;
        }

        .btn1, .btn2{
            margin-top: 20px;
        }

        .btn:hover{
            background-color: lightgray;
        }

        .noTop{
            font-size: 35px;
        }
    </style>
</head>
<body>

	<div class="wrap">
	        <div class="insertNoImg">
	            <span class="noTop">
	                공지사항 수정하기
	            </span>
	        </div>
	            <div class="insertNoForm">
	                <form action="<%= contextPath %>/update.no" method="post">
	                    <input type="hidden" name="noticeWriter" id="title" value="<%=loginMember.getMemNo()%>">
	                    <input type="hidden" name="noticeNo" value="<%=n.getNoticeNo()%>">
	                    <span>제목</span> <br>
	                    <input type="text" name="title" id="title" class="noTitle" value="<%= n.getNoticeTitle() %>"> <br><br>
	
	                    <span>내용</span> <br>
	                    <textarea name="content" cols="30" rows="10"  class="noContent" ><%= n.getNoticeContent() %></textarea> <br><br>
	                    
	                    <button type="submit" class="btn1">수정하기</button>
	                    <button type="reset" class="btn2" onclick="location.href='<%=contextPath%>/list.no?cpage=1'">취소하기</button>
	                </form>
	            </div>
	        </div>
	    </div>

</body>
</html>