<%@page import="java.sql.Date"%>
<%@page import="com.semi_5makase.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member m = (Member)request.getAttribute("m");
	String contextPath = request.getContextPath(); 
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <style>
        /* .wrap-area>*{border: 1px solid red;} */
        .wrap-area{
            /* border: 1px solid red; */
            width: 600px;
            height: 600px;
            padding: 30px;
            margin: auto;
        }

        .intro-area{
            font-size: xx-large;
            line-height: 100px;
        }

        #result-area{
            background-color: rgb(236, 232, 232);
            width: 530px;
            height: 70px;
        }

        #button a{
            color: white;
            text-decoration: none;
        }

        table td{padding: 0px 20px;}

        /* #result-area td{text-align: justify;} */

        #findById{margin-top: 50px;}
        
        @font-face {
            font-family: 'SUITE-Regular';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/SUITE-Regular.woff2') format('woff2');
            font-weight: 400;
            font-style: normal;
        }
        
        * {
        	font-family : 'SUITE-Regular';
        }
    </style>
</head>
<body>

    <div class="wrap-area">
        <div class="intro-area" align="center"> 아이디 찾기 결과 </div> <br><br>
            <h5 align="center">회원님의 휴대전화로 <br> 가입된 아이디가 있습니다.</h5><br>
            <div id="result-area"> <br>
                <table>
                    <tr>
                        <td width="280">아이디 : <b><%= m.getMemId()%></b></td>
                        <td>가입날짜 : <b><%=m.getEnrollDate() %></b></td>
                    </tr>
                </table>
            </div> <br><br>
            <div align="center">비밀번호가 기억나지 않으세요? <a href="<%=contextPath%>/searchPwdOne.me">비밀번호 찾기</a></div> <br>
            <div id="button">
                <button type="button" class="btn btn-primary btn-lg btn-block"><a href="<%=contextPath%>">로그인</a></button>
            </div>
    </div>