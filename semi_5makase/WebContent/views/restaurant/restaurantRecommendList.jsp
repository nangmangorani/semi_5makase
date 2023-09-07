<%@page import="com.semi_5makase.restaurant.model.vo.Restaurant"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Restaurant> list = (ArrayList<Restaurant>)request.getAttribute("categoryList");
	ArrayList<Restaurant> lclist = (ArrayList<Restaurant>)request.getAttribute("locationList");

	String cateName = (String)request.getAttribute("categoryName");
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>

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
            height: 1500px;
            margin: auto;
        }

        #header {
            height: 5%;
        }

        .wrap>div {
            width: 100%;
        }

        #logo,
        #login {
            width: 20%;
        }

        #search {
            width: 60%;
        }


        #logo>img {
            width: 80px;
            height: 77px;
        }


        #searchTab {
            width: 500px;
            border-radius: 20px;
            margin-top: 25px;
            margin-left: 20px;
        }

        #header>div {
            height: 100%;
            float: left;
        }

        #content {
            width: 100%;
            height: 78%;
        }

        #content_1 {
            width: 100%;
            height: 15%;
            margin: auto;
            border-bottom: 1px solid gray;
            background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),url(resources/img/hansikrecommend.png);
            background-size: cover;
            background-position: 20% 20%;

        }

        #content_1>span {
            text-align: center;
        }

        #content_1>span>h2 {
        	color:white;
            line-height: 170px;
        }

        #content_2 {
            width: 70%;
            height: 85%;
            margin: auto;
        }

        .restaurant {
            height: 20%;
            width: 100%;
            border-bottom: 1px solid lightgray;
            padding: 10px;
            float: left;
        }



        .restaurant:hover {
            background-color: rgb(240, 240, 240);
        }

        .imgLine {
            width: 100%;
            height: 80%;
        }

        .imgLeft {
            width: 25%;
            height: 100%;
            float: left;
        }

        .imgRight {
            width: 100%;
            height: 100%
        }

        .textLine {
            width: 100%;
            height: 20%;
        }

        .restaurant_desc {
            height: 100%;
            width: 100%;
        }

        .restaurant_desc>span {
            float: left;
            margin-left: 15px;
            line-height: 30px;
        }



        .heart-container {
            cursor: pointer;
            box-sizing: border-box;
            display: inline-block;
            vertical-align: middle;
        }

        .heart {
            width: 35px;
            height: 35px;
            position: relative;
            display: inline-block;
            vertical-align: middle;

        }

        .heart::before,
        .heart::after {
            content: '';
            position: absolute;
            top: 0;
            width: 17.5px;
            height: 27.5px;
            margin-left: 370px;
            border-radius: 17.5px 17.5px 0 0;
            background: #ccc;
            /* Initial color: gray */
            transition: background 0.3s;
        }

        .heart::before {
            left: 17.5px;
            transform: rotate(-45deg);
            transform-origin: 0 100%;
        }

        .heart::after {
            left: 0;
            transform: rotate(45deg);
            transform-origin: 100% 100%;
        }

        .heart.filled::before,
        .heart.filled::after {
            background-color: rgb(215, 68, 62);
            /* Filled color: pink */
        }



        .bigHeart {
            float: right;
            height: 35px;
            width: 35px;
            margin-right: 15px;
            margin-top: 8px;
        }

        .imgRight_1 {
            font-size: 22px;
            line-height: 48px;
        }

        .imgLeft>img {
            width: 130px;
            height: 130px;
            margin-left: 15px;
            margin-top: 9px;
            border-radius: 10px;
        }

        .moreBtn {
            margin: auto;
            margin-top: 20px;
            border: transparent;
            width: 400px;
            height: 40px;
            background-color: rgb(21, 98, 189);
            color: white;
            border-radius: 10px;
            margin-bottom: 20px;
        }

        .imgRight_4>img {
            width: 20px;
        }



        #footer {
            width: 100%;
            height: 15%;
            display: inline-block;
        }

        #footer_1 {
            margin-top: 10px;
        }

        #footer * {
            margin-left: 20px;
        }

        #footer_1>a {
            text-decoration: none;
            color: black;
            font-weight: 600;
        }

        #footer_2 {
            margin-top: 20px;
        }

        #footer_3 {
            margin-top: 10px;
        }

        #footer_4 {
            margin-top: 10px;
        }

        .hidden {
            display: none;
        }
    </style>
</head>

<body>

	<%@ include file="../common/menubar.jsp" %>

    <div class="wrap">
        <div id="header">

        </div>
        <div id="content">
            <div id="content_1">
                <span>
                    <h2><%= cateName %></h2>
                </span>
            </div>
            <div id="content_2">
	           <% if(list != null) { %>
		            <% for (Restaurant cateList : list) { %>
		                <div class="restaurant" onclick="location.href='<%= contextPath %>/detail.rt?restNo=<%= cateList.getRestNo() %>'">
		                    <div class="imgLine">
		                        <div class="imgLeft">
		                            <img src="<%= cateList.getTitleImg() %>">
		                        </div>
		                        <div class="imgRight">
		                            <div class="imgRight_1">
		                                <span><%= cateList.getRestName() %></span>
		                            </div>
		                            <div class="imgRight_2">
		                                <strong><%= cateList.getMenu() %></strong>
		                            </div>
		                            <div class="imgRight_3">
		                           		<% if(!cateList.getTvName().equals("없음")) { %>
		                                	<span style="color:orange;">#<%= cateList.getTvName() %></span>,
		                                <% } %>
		                                <% if(cateList.getParking().equals("가능")) { %>
		                                	<span style="color:blue;">#주차가능</span>
		                                <% } else { %>
		                                	<span style="color:red;">#주차불가능</span>	
		                                <% } %>
		                            </div>
		                            <div class="imgRight_4" style="margin-top: 10px;">
		                                <img src="https://dcicons.s3.ap-northeast-1.amazonaws.com/new/images/mobile/react_m_common/card__score__star2.png">
		                                <%= cateList.getAvg2() %> (<%= cateList.getCount() %>명)
		                                &nbsp;&nbsp;
		                                <img src="./resources/img/heart.png" alt="">
		                                <%= cateList.getFcount() %>
		                                &nbsp;&nbsp;
		                                <img src="./resources/img/view1.png" alt="">
		                                <%= cateList.getRestViews() %>
		
		                            </div>
		                        </div>
		                    </div>
		                    <div class="textLine">
		                        <div class="restaurant_desc">
		                            <span>
		                                <% if (cateList.getIntro().length() > 53) { %>
		                                	<%= cateList.getIntro().substring(0, 53) %> ... 더보기		                            	
		                            	<% } else { %>
		                            		<%= cateList.getIntro() %>
		                            	<% } %> 
		                            </span>
		                        </div>
		                    </div>
		                </div>
		            <% } %>
	           <% } %>
	           
	           <% if (lclist != null) { %>
	           		<% for (Restaurant llist : lclist) { %>
		                <div class="restaurant" onclick="location.href='<%= contextPath %>/detail.rt?restNo=<%= llist.getRestNo() %>'">
		                    <div class="imgLine">
		                        <div class="imgLeft">
		                            <img src="<%= llist.getTitleImg() %>"
		                                alt="">
		                        </div>
		                        <div class="imgRight">
		                            <div class="imgRight_1">
		                                <span><%= llist.getRestName() %></span>
		                            </div>
		                            <div class="imgRight_2">
		                                <strong><%= llist.getMenu() %></strong>
		                            </div>
		                            <div class="imgRight_3">
		                           		<% if(!llist.getTvName().equals("없음")) { %>
		                                	<span style="color:orange;">#<%= llist.getTvName() %></span>,
		                                <% } %>
		                                <% if(llist.getParking().equals("가능")) { %>
		                                	<span style="color:blue;">#주차가능</span>
		                                <% } else { %>
		                                	<span style="color:red;">#주차불가능</span>	
		                                <% } %>
		                            </div>
		                            <div class="imgRight_4" style="margin-top: 10px;">
		                                <img src="https://dcicons.s3.ap-northeast-1.amazonaws.com/new/images/mobile/react_m_common/card__score__star2.png">
		                                <%= llist.getAvg2() %> (<%= llist.getCount() %>명)
		                                &nbsp;&nbsp;
		                                <img src="./resources/img/heart.png" alt="">
		                                <%= llist.getFcount() %>
		                                &nbsp;&nbsp;
		                                <img src="./resources/img/view1.png" alt="">
		                                <%= llist.getRestViews() %>
		
		                            </div>
		                        </div>
		                    </div>
		                    <div class="textLine">
		                        <div class="restaurant_desc">
		                            <span>
		                            	<% if (llist.getIntro().length() > 53) { %>
		                                	<%= llist.getIntro().substring(0, 53) %> ... 더보기		                            	
		                            	<% } else { %>
		                            		<%= llist.getIntro() %>
		                            	<% } %> 
		                            </span>
		                        </div>
		                    </div>
		                </div>
		            <% } %>
	           <% } %>
            </div>
        </div>

        <div class="btn_line" style="align-items: center; display: flex;">
            <button class="moreBtn">더보기</button>
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


    <script>
    
        $(function () {
            $(".moreBtn").click(function () {
                $(".restaurant.hidden").toggleClass("hidden");
            })
        })


        $(function () {
            $(".moreBtn").click(function () {
                const hiddenContent = $(".restaurant.hidden");
                const hiddenContentHeight = hiddenContent.outerHeight(true);

                hiddenContent.toggleClass("hidden");

                const originalFooterHeight = $("#footer").outerHeight(true);
                const adjustedFooterHeight = originalFooterHeight + hiddenContentHeight;

                // Calculate the maximum height the footer can have
                const maxHeight = originalFooterHeight + hiddenContentHeight * hiddenContent.length;
                const newFooterHeight = Math.min(adjustedFooterHeight, maxHeight);

                $("#footer").css('height', newFooterHeight + 'px');
            });
        })

        // 하트 토글 스크립트구문
        // const heartContainer = document.querySelector('.heart-container');
        // const heart = heartContainer.querySelector('.heart');

        // heart.addEventListener('click', (event) => {
        //     event.stopPropagation();
        //     heart.classList.toggle('filled');

        // });

        // heartContainer.addEventListener('click', (event) => {
        //     event.stopPropagation();
        // });

        const heartContainers = document.querySelectorAll('.heart-container');

        heartContainers.forEach(heartContainer => {
            const heart = heartContainer.querySelector('.heart');

            heart.addEventListener('click', (event) => {
                event.stopPropagation();
                heart.classList.toggle('filled');
            });

            heartContainer.addEventListener('click', (event) => {
                event.stopPropagation();
            });
        });
     </script>

</body>

</html>