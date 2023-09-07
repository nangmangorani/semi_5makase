<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int qnaNo = (int)request.getAttribute("qnaNo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA</title>
	<link rel="icon" href="resources/img/favicon.ico" type="image/x-icon" sizes="16x16">
<style>
    @font-face {
            font-family: 'SUITE-Regular';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/SUITE-Regular.woff2') format('woff2');
            font-weight: 400;
            font-style: normal;
        }

        div {
            /* border: 1px solid red; */
            font-family: 'SUITE-Regular';
            box-sizing: border-box;
        }

        span {
            box-sizing: border-box;
        }

        .wrap {
            width: 1000px;
            height: 800px;
            margin: auto;
        }

        .insertQnaImg{
            width: 100%;
            height: 200px;
            background-color: lightgray;
            padding-left: 330px;
            padding-top: 70px;
        }

        .insertQnaForm{
            width: 70%;
            height: 600px;
            padding-left: 80px;
            padding-top: 20px;
            margin: auto;
        }

        .qnaTitle{
            width: 500px;
        }

        .qnaContent{
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

        .qnaTop{
        	padding-left: 60px;
            font-size: 35px;
        }

</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>
    
    <div class="wrap">
        <div class="insertQnaImg">
            <span class="qnaTop">
                Q&A 답변하기
            </span>
        </div>
        <div class="insertQnaForm">
            <form action="<%= contextPath %>/insertReply.qna">
            	<input type="hidden" name="qnaWriter" method="post" value="<%=loginMember.getMemNo()%>">
            	<input type="hidden" name="qnaNo" value="<%=qnaNo%>"> 
                답변 <br>
                <textarea name="qnaContent" cols="30" rows="10" class="qnaContent" method="post"></textarea> <br>
                <button type="submit" class="btn1">작성하기</button>
                <button type="reset" class="btn2" onclick="location.href='<%=contextPath%>/detail.qna?num='<%=qnaNo%>">취소하기</button>
            </form>
        </div>
        
	</div>    
    
</body>
</html>