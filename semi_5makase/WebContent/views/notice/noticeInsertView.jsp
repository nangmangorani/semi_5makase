<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath(); 
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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

        #title{
            width: 300px;
        }

        textarea{
            resize: none;
            width: 300px;
        }

        #noticeBtn{
            margin-left: 345px;
        }
    </style>
</head>
<body>

    <div class="wrap">
        <div>
            <form action="<%= contextPath %>/insert.no" method="post">
                <span>공지사항 제목 </span>
                <input type="text" name="title" id="title"> <br><br>

                <span>공지사항 내용 </span>
                <textarea name="content" cols="30" rows="10"></textarea> <br><br>
                
                <input type="submit" name="" id="noticeBtn">
            </form>
        </div>
    </div>

</body>
</html>