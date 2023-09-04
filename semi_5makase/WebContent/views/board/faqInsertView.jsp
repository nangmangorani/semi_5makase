<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

        .insertFaqImg{
            width: 100%;
            height: 200px;
            background-color: lightgray;
            padding-left: 330px;
            padding-top: 70px;
        }

        .insertFaqForm{
            width: 70%;
            height: 600px;
            padding-left: 80px;
            padding-top: 20px;
            margin: auto;
        }

        .faqTitle{
            width: 500px;
        }

        .faqContent{
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

        .faqTop{
            font-size: 35px;
        }

</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>
    
    <div class="wrap">
        <div class="insertFaqImg">
            <span class="faqTop">
                자주묻는질문 추가하기
            </span>
        </div>
        <div class="insertFaqForm">
            <form action="<%= contextPath %>/insert.faq">
            	<input type="hidden" name="faqWriter" method="post" value="<%=loginMember.getMemNo()%>"> 
                제목 <br>
                <input type="text" name="faqTitle" method="post" class="faqTitle"> <br><br>
                내용 <br>
                <textarea name="faqContent" cols="30" rows="10" class="faqContent" method="post"></textarea> <br>
                <button type="submit" class="btn1">작성하기</button>
                <button type="reset" class="btn2" onclick="location.href='<%=contextPath%>/list.faq'">취소하기</button>
            </form>
        </div>
        
	</div>    
    
</body>
</html>