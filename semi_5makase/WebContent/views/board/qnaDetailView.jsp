<%@page import="com.semi_5makase.common.model.vo.Attachment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.semi_5makase.board.model.vo.Qna"%>
<%@page import="com.semi_5makase.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Qna q = (Qna)request.getAttribute("q");
	ArrayList<Attachment> list = (ArrayList<Attachment>)request.getAttribute("list");
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
            /* border: 1px solid red; */
            font-family: 'SUITE-Regular';
            box-sizing: border-box;
        }

        .wrap {
            width: 1000px;
            height: 1200px;
            margin: auto;
        }

        #header{
            width: 100%;
            height: 7%;
        }
        
        .wrap>div{
            width: 100%;
        }

        #header{
            height: 7%;
        }
        
        #logo, #login{
            width: 20%;
        }

        #search{
            width: 60%;
        }


        #logo>img{
            width: 80px;
            height: 77px;
        }

        
        #searchTab{
            width: 500px;
            border-radius: 20px;
            margin-top: 30px;
            margin-left: 20px;
        }

        #header>div{
            height: 100%;
            float: left;
        }

        #content{
            height: 78%;
        }

        #content_1{
            height: 100%;
        }

        #content_1_1{
            height: 25%;
        }

        #content_1_2{
            height: 75%;
        }

        #content_main1{
            width: 70%;
            height: 90%;
            margin: auto;
        }

        #content_main2{
            width: 70%;
            height: 10%;
            margin: auto;
        }

        #mainTitle{
            height: 10%;
            line-height: 60px;
            padding-left: 5px;
            border-bottom: 1px solid black;
        }

        #qnaDetail{
            height: 10%;
            border-bottom: 1px solid black;
        }

        #qnaDetail>div{
            height: 100%;
            float: left;
            line-height: 57px;
            padding-left: 5px;
        }

        #qnaDetail_1{width: 15%;}
        #qnaDetail_2{width: 20%;}
        #qnaDetail_3{width: 25%;}
        #qnaDetail_4{width: 20%;}
        #qnaDetail_4{width: 20%;}

        #qnaContent{
            height: 100%;
        }

        #qnaContent>div{
            padding-left: 5px;
            line-height: 45px;
        }



        #qnaContent_1{
            height: auto;
            border-bottom: 1px solid black;
        }

        #qnaContent_2{
            height: auto%;
            border-bottom: 1px solid black;
        }

        #qnaContent_3{
            width: 100%;
            height: auto;
            border-bottom: 1px solid black;
            float:left;
            
        }

        #listBtn{
            margin-top: 20px;
            margin-left: 600px;
        }

        #footer{
            height: 15%;
            width: 100%;
            display: inline-block;
        }



    </style>
    
</head>
<body>
<%@ include file="../common/menubar.jsp"%>
    <div class="wrap">
        <div id="content">
            <div id="content_1">
                <div id="content_1_1">
                    이미지자리
                </div>
                <div id="content_1_2">
                    <div id="content_main1">
                        <div id="mainTitle">
                            <span>제목 : </span>
                            <span><%= q.getBoardTitle() %></span>
                        </div>
                        <div id="qnaDetail">
                            <div id="qnaDetail_1">
                                <b>진행</b>
                                <span><%= q.getReply() %></span>
                            </div>
                            <div id="qnaDetail_2">
                                <b>작성자</b>
                                <span><%= q.getBoardWriter() %></span>
                            </div>
                            <div id="qnaDetail_3">
                                <b>날짜</b>
                                <span><%= q.getCreateDate() %></span>
                            </div>
                            <div id="qnaDetail_4">
                                <b>조회수</b>
                                <span><%= q.getQnaViews() %></span>
                            </div>
                            <div id="qnaDetail_4">
                                <b>공개여부</b>
                                <span><%= q.getOpen() %></span>
                            </div>
                        </div>
                        <div id="qnaContent">
                            <div id="qnaContent_1"><%= q.getBoardContent() %></div>
                            <div id="qnaContent_2">
                                <b>첨부파일</b>
                                <% for(Attachment at : list) {%>
                                	<a download="<%= at.getOriginName() %>" href="<%=contextPath%>/<%=at.getFilePath()%>/<%=at.getChangeName()%>"><%= at.getOriginName() %></a> &nbsp;
                                <% } %>
                            </div>
                            <div id="qnaContent_3">
                                <b>답변</b>
                                <span></span>
                            </div>
                        </div>
                    </div>
                    <div id="content_main2">
                        <button id="listBtn" onclick="location.href='<%=contextPath%>/list.qna?cpage=1'">목록가기</button>
                    </div>
                </div>
            </div>
            
        </div>
        <div id="footer">
            <div id="footer_1">
                <a href=""> 데이터 제휴 문의 </a>
                <a href=""> 개인정보처리방침 </a>
                <a href=""> 이용약관 </a>
                <a href=""> 위치기반 서비스 이용약관 </a>
            </div>
            <div id="footer_2">
                <b>(주)유소</b>
                <span>소재지 : 서울특별시 강남구 역삼동</span>
            </div>
            <div id="footer_3">
                <span>이메일 문의: 2num@enum.com</span>
            </div>
            <div id="footer_4">
                <span>전화 문의 : 02-457-1304 (평일 : 10:00 ~ 19:00, 주말/공휴일 제외)</span>
                <span style="margin-left: 260px;">Copyright Ⓒ 2023 Diningcode</span>
            </div>
        </div>
    </div>
</body>
</html>