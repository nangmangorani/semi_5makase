<%@page import="java.util.ArrayList"%>
<%@page import="com.semi_5makase.common.model.vo.Attachment"%>
<%@page import="com.semi_5makase.board.model.vo.Qna"%>
<%@page import="com.semi_5makase.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member loginMember = (Member)session.getAttribute("loginMember");
	String contextPath = request.getContextPath();
	Qna q = (Qna)request.getAttribute("q");
	Attachment at = (Attachment)request.getAttribute("at");
%>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QNA</title>
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
            padding-left: 330px;
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
        
        .noContent{
        	resize: none;
        }
    </style>
</head>
<body>

	<div class="wrap">
	        <div class="insertNoImg">
	            <span class="noTop">
	                Q&A 수정하기
	            </span>
	        </div>
	            <div class="insertNoForm">
	                <form action="<%= contextPath %>/update.qna" method="post" enctype="multipart/form-data">
	                    <input type="hidden" name="boardWriter" id="title" value="<%=loginMember.getMemNo()%>">
	                    <input type="hidden" name="qnaNo" value="<%=q.getQnaNo()%>">
	                    <span>제목</span> <br>
	                    <input type="text" name="title" id="title" class="noTitle" value="<%= q.getBoardTitle() %>"> <br><br>
	
	                    <span>내용</span> <br>
	                    <textarea name="content" cols="30" rows="10"  class="noContent"><%= q.getBoardContent() %></textarea> <br><br>
	                    
	                    <input type="radio" name="open" value="Y"> 공개
		          		<input type="radio" name="open" value="N" checked> 비공개 <br><br>
                  
                  		<div id='image_preview'>
	                      <b id="picture">사진</b>  <br>    
	                      <% if(at != null) { %>
		                      <!-- 현재 이 게시글에 딸린 첨부파일이 있을 경우 -->
		                      <input type="hidden" name="originFileNo" value="<%=at.getFileNo()%>">
		                      <%= at.getOriginName() %>
							<% } %>
		                      <input type="file" name="upfile">
	                      <div id='att_zone'></div>
	                  	</div>
	                    
	                    
	                    <button type="submit" class="btn1">수정하기</button>
	                    <button type="reset" class="btn2" onclick="location.href='<%=contextPath%>/list.qna?cpage=1'">취소하기</button>
	                    
	                </form>
	            </div>
	        </div>

</body>
</html>