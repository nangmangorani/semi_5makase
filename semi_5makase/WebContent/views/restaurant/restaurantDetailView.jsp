<%@page import="com.semi_5makase.common.model.vo.Attachment"%>
<%@page import="com.semi_5makase.restaurant.model.vo.Review"%>
<%@page import="com.semi_5makase.restaurant.model.vo.Favorite"%>
<%@page import="com.semi_5makase.restaurant.model.vo.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.semi_5makase.restaurant.model.vo.Restaurant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Restaurant rest = (Restaurant)request.getAttribute("rest");
	//음식점번호, 이름, 주소, 전화번호, 주차, 소개, 조회수, 영업시간 조회
	
	String restTime = (rest.getRestTime() == null) ? "" : rest.getRestTime();
	String breakTime = (rest.getBreakTime() == null) ? "" : rest.getBreakTime();
	
	ArrayList<Menu> list = (ArrayList<Menu>)request.getAttribute("list");
	// 음식점번호, 첨파번호, 메뉴, 가격, 메뉴등급번호
	
	int fCount = (int)request.getAttribute("favoriteCount");
	// 즐겨찾기 수
	
	/* Favorite checkFavorite = (Favorite)request.getAttribute("checkFavorite"); */
	// 로그인한 유저가 해당 음식점 즐겨찾기 되어있는지 확인
	
	int rCount = (int)request.getAttribute("reviewCount");
	// 리뷰 수
	
	double avg = (double)request.getAttribute("selectReviewRatingAvg");
	// 별점 평균점수
	
	ArrayList<Review> rvList = (ArrayList<Review>)request.getAttribute("rvList");
	// 리뷰번호, 리뷰내용, 파일경로, 별점, 유저넘버
	
	ArrayList<Attachment> rvPicList = (ArrayList<Attachment>)request.getAttribute("rvPicList");
	
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
        div{
            font-family: 'SUITE-Regular';
            box-sizing: border-box;
            border: 1px solid white;
        }
        button{
            background-color: white;
            border: 0;
            cursor: pointer;
        }
        .wrap{
            width: 1000px;
            height: 2000px;
            margin: auto;
        }
        #header{
            height: 5%;
            border-bottom: 1px solid lightgray;
        }
        #photo{
            width: 60%;
            height: 10%;
            margin: auto;
            margin-top: 10px;
        }
        #restaurent_title{
            width: 60%;
            height: 5%;
            margin: auto;
            border-bottom: 1px solid lightgray;
        }
        #restaurent_content{
            width: 60%;
            height: auto;
            margin: auto;
            padding-bottom: 30px;
            border-bottom: 1px solid lightgray;
        }
        #review{
            width: 60%;
            height: 53%;
            margin: auto;
        }

        /* ---------------------------- 사진 ---------------------------- */
        #photo{
            box-sizing: border-box;
            display: flex;
        }
        
        #photo>div{
        }
        
        #photo img:hover{
       		transition: all 0.2s linear;
        	transform: scale(1.4);
        }
        
        #photo>div{
            height: 100%;
        }
        .photo_1{
            width: 33%;
        }
        .photo_2{
            width: 33.3%;
        }
        .photo_3{
            width: 33.3%;
        }

        /* ---------------------------- 식당이름 ---------------------------- */
        #restaurent_title{
            box-sizing: border-box;
        }
        #restaurent_title>div{
            height: 100%;
            float: left;
        }
        #restaurent_name{
            width: 70%;   
        }
        #restaurent_name>div{
            width: 100%;
        }

        #nameAndGrade{
            height: 65%;
            box-sizing: border-box;
        }
        #nameAndGrade>div{
            height: 100%;
            float: left;
        }
        #name{
            font-size: 30px;
            margin-right: 10px;
            margin-left: 10px;
            line-height: 57px;
        }
        #grade{
            font-size: 27px;
            color: aqua;
        }
        #ass{
            height: 35%;
        }
        #ass>div{
            float: left;
            margin-left: 10px;
        }

        

        /* ---------------------------- 즐찾, 리뷰작성 ---------------------------- */
        #likeAndReview{
        	margin-top: 15px;
            width: 30%;
            box-sizing: border-box;
        }
        #likeAndReview>div{
            height: 100%;
            float: left;
        }
        #like-area{
            width: 50%;
            padding-right: 10px;
        }
        #writeReview{
            width: 50%;
            padding-left: 10px;
        }

        
        #likeAndReview p, #wirteReview p{
        	color : gray;
        	padding-top: 10px;
        } 

        /* ---------------------------- 음식점상세 ---------------------------- */
        #table{
            margin-top: 10px;
            margin-left: 20px;
        }

        /* ---------------------------- 리뷰 ---------------------------- */
        #review>div{
            width: 100%;
        }
        #reviewHeader{
            height: 5%;
            border-bottom: 1px solid lightgray;
        }
        
        #no_review{
        	text-decoration: none;
        }

        #reviewContent{
            height: 350px;
            margin-top: 10px;
            width: auto;
            /* border-bottom: 1px solid lightgray; */
        }

        #reviewHeader>div{
            height: 100%;
            float: left;
        }
        #reviewCount{
            width: 70%;
            padding-left: 20px;
        }
        #reviewCount>p{
            font-size: 18px;
            line-height: 57px;
        }
        
        #reviewSeq{
            width: 30%;
            line-height: 57px;
            padding-right: 20px;
        }
        
        #reviewSeq>a{
        	color:black;
        }

        #reviewContent>div{
            width: 100%;
        }
        .reviewContentHeader{
            width: 50%;
            height: 25%;
        }
        .reviewContentHeader>div{
            float: left;
            box-sizing: border-box;
        }
        .profile{
            width: 15%;
            height: 100%;
        }
        .nameStar{
            width: 25%;
            height: 100%;
        }
        .userName{
            height: 60%;
            padding-top: 12px;
        }
        
        #info_table td ul{
            list-style: none;
        }

        #info_table td{
            text-align: right;
        }


        /* #star{
            width: 100px;
            height: 40%;
            background: url(https://s3-ap-northeast-1.amazonaws.com/dcicons/new/images/web/common/rating-off@2x.png) repeat-x left;
            background-size: 20px;
            vertical-align: middle;
        } */

		/* 별점 매기기 */
        .star-rating {

        display:flex;
        font-size:1.5em;
        justify-content:space-around;
        padding:0 .2em;
        text-align:center;
        width:5em;
        }
        
		/*
        .star-rating input {
        display:none;
        }
        */

        .star-rating label {
        color:#ccc;
        }
		
		/*
        .star-rating :checked ~ label {
        color:#f90;
        }

        .star-rating label:hover,
        .star-rating label:hover ~ label {
        color:#fc0;
        }
        */

        .taste{
            width: 30%;
            height: 100%;
        }
        /* #tastePhoto{
            background-image: url(https://mp-seoul-image-production-s3.mangoplate.com/web/resources/2018022864551sprites_desktop.png);
            background-position: -714px -866px;
            width: 50px;
            height: 50px;
        } */

        .good{
            width: 30%;
            height: 100%;
        }
        .good>div{
            float: left;
            height: 100%;
        }
        .goodCount{
            width: 50%;
        }
        .goodbtn{
            width: 50%;
        }

        .review_content{
            height: auto;
            padding: 10px;
        }

        .reviewPhotoList{
            height: 45%;
        }
        .reviewPhotoList>ul{
            list-style: none;
        }
        .reviewPhotoList li{
            float: left;
        }
        .reviewPhotoList img{
        	height: 150px;
            width: 150px;
            padding:5px;
            transition: all 0.2s linear;
        }
        
        .reviewPhotoList img:hover{
        	transform: scale(1.4);
        }
        
        .detailReview{
        	text-decoration-line: none;
        	color : black;
        }
        
        #info_table td ul{
            list-style: none;
        }

        #info_table td:not(.rest_menu .rest_intro){
            text-align: right;
        }

        .menu_price{
            width: 30%;
            display: inline-block;
            text-align: right;
        }
        
        /* The Modal (background) */
        .restupdate_modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 6; /* Sit on top, menubar의 z-index : 5 */ 
            left: 0;
            top: 0;
            width: 100%; 
            height: 100%; 
            border-radius:10;
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
            
        }
    
        /* Modal Content/Box */
        .restupdate_modal-content {
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            padding: 15px;
            border: 1px solid #888;
            width: 30%; /* Could be more or less, depending on screen size */                          
        }
        #rest_close_modal{
            color: #222228;
            background-color: white;
            cursor: pointer;
            text-align: center;
            font-size: 14px;
            border: none;
        }
        #restupdate_modelText{
            width: 90%;
            padding: 10px;
        }

        .restupdate_modal-content{
            border-radius: 10px;
        }
        
        /* The Modal (background) */
        .report_modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 6; /* Sit on top, menubar의 z-index : 5 */ 
            left: 0;
            top: 0;
            width: 100%; 
            height: 100%; 
            border-radius:10;
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
            
        }
    
        /* Modal Content/Box */
        .report_modal-content {
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            padding: 15px;
            border: 1px solid #888;
            width: 30%; /* Could be more or less, depending on screen size */                          
        }
        .report_close_modal{
            color: #222228;
            background-color: white;
            cursor: pointer;
            text-align: center;
            font-size: 14px;
            border: none;
        }
        .report_modalText{
            width: 90%;
            padding: 10px;
        }

        .report_modal-content{
            border-radius: 10px;
        }

    </style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
    <div class="wrap">
        <!-- ---------------------------- 헤더 ---------------------------- -->
        <div id="header">

        </div>

        <!-- ---------------------------- 사진 ---------------------------- -->
        <div id="photo">
        	<% for(int i=1; i<4; i++) { %>
	            <div class="photo_<%=i %>">
	                <a href="<%= contextPath %>/detail.rv" style="padding: 0; border: 0;">
	                                     
	                </a>
	            </div>
        	<% } %>
        </div>

        <!-- ---------------------------- 음식점 이름 ---------------------------- -->
        <div id="restaurent_title">
            <div id="restaurent_name">
                <div id="nameAndGrade">
                        <strong id="name"><%= rest.getRestName() %></strong>
                        <strong id="grade"><%= avg %></strong>
                </div>
                <div id="ass">
                    <div id="hit">
                        <img src="resources/img/eye.png" alt="" width="25px" height="25px">
                        <span><%= rest.getRestViews() %></span>
                    </div>
                    <div id="favorite">
                        <img src="resources/img/heart.png" alt="" width="30px" height="25px">
                        <span><%= fCount %></span>
                    </div>
                </div>
            </div>    
            
            
            <div id="likeAndReview">
                <div id="like-area">
	                    <button type="button" style="padding: 0; border: 0;" id="restFavor" onclick="updateFavorite();">
	                        <img src="resources/img/noheart.png" id="favoriteImg" style="width: 50px; height: 40px;">
	                        <p id="like-content" style="margin: 0;">즐겨찾기</p>
	                    </button>
                </div>
            <div id="writeReview">
            	<% if(loginMember == null) { %>
	                 <a href="<%=contextPath %>/insertReviewForm.rv?restNo=<%= rest.getRestNo() %>">
	                     <button style="padding: 0; border: 0;" onclick="return writeReview();">
	                         <img src="resources/img/review.png" style="width: 50px; height: 40px;">
	                         <p id="review-content" style="margin: 0;">리뷰작성</p>
	                     </button>
	                 </a>
                 <% } else{ %>
                 	<a href="<%=contextPath %>/insertReviewForm.rv?restNo=<%= rest.getRestNo() %>">
	                     <button style="padding: 0; border: 0;">
	                         <img src="resources/img/review.png" style="width: 50px; height: 40px;">
	                         <p id="review-content" style="margin: 0;">리뷰작성</p>
	                     </button>
                 	</a>
                 <% } %>
             </div>
            </div>
        </div>
        <!-- ---------------------------- 음식점 상세 ---------------------------- -->
        <div id="restaurent_content">
            <table id="info_table">
                <tr>
                    <th style="width: 110px; height: 40px;">주소</th>
                    <td style="width: 480px;"><%= rest.getRestAddress() %></td>
                </tr>
                <tr>
                    <th style="width: 110px; height: 40px;">전화번호</th>
                    <td><%= rest.getRestPhone() %></td>
                </tr>
                <tr>
                    <th style="width: 110px; height: 40px;">메뉴</th>
                    <td class="rest_menu">
                        <ul>
	                        <% for(Menu m : list) { %>
	                        	<li><span><%= m.getMenu() %></span><span class="menu_price"><%= m.getPrice() %>원</span></li>
	                        <% } %>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <th style="width: 110px; height: 40px;">영업시간</th>
                    <td><%= rest.getOpeningTime() %></td>
                </tr>
             	<% if(!breakTime.equals("")) { %>
	            <tr>
	            	<th>브레이크 타임</th>
	            	<td><%= breakTime %></td>
	            </tr>        	
	            <% } %>
	            <% if(!restTime.equals("")) { %>
	            <tr>
	            	<th>휴무일</th>
	            	<td><%= restTime %></td>
	            </tr>        	
	            <% } %>
                <tr>
                    <th style="width: 110px; height: 40px;">주차가능 여부</th>
                    <td><%= rest.getParking() %></td>
                </tr>
                <tr>
                    <th style="width: 110px; height: 40px;">소개글</th>
                    <td class="rest_intro">
                    	<div><%= rest.getIntro() %></div>
                    <!-- <textarea style="resize: none; height:100px; width: 480px; border:none"><%= rest.getIntro() %></textarea> -->
                    </td>
                </tr>
                <tr>
                <% if(loginMember == null) { %>
                	<td colspan=2 style="text-align:center">
                        <button type="button" id="openModal" class="btn btn-sm btn-danger" style="width: 180px;" onclick="return writeReview();">수정 및 폐업 신고</button>
                	</td>
               	<% } else { %>
               		<td colspan=2 style="text-align:center">
                        <button type="button" id="openModal" class="btn btn-sm btn-danger" style="width: 180px;">수정 및 폐업 신고</button>
                	</td>
               	<% } %>
                </tr>
            </table>
            <!-- The Modal -->
		    <div id="myModal" class="restupdate_modal">
		 
		      <!-- Modal content -->
		      <div class="restupdate_modal-content">
		        <form action="update.rt">
		        	<input type="hidden" name="restNo" value="<%= rest.getRestNo() %>">
		            <p style="text-align: center;"><span style="font-size: 15pt;"><b><span style="font-size: 13pt;">폐업신고 - 신고</span></b></span></p>
		            <textarea name="updateRest" id="restupdate_modelText" cols="40" rows="10" style="resize: none;" placeholder="수정이 필요한 내용을 적어주세요.&#13;&#10;예)맛집이름,주소,전화번호 등"></textarea>
		            <br>
		            <input type="checkbox" name="closed"> 폐업신고
		            <p style="font-size: 12px; color: #888;">해당 음식점이 폐업이 되었을 경우 선택해 주세요</p>
		            <br>
		                
		        <hr>
		        <div align="center">
		            <button id="rest_close_modal" name="restaurantUpdate">보내기</button>
		        </div>
		        </form>
		        <!-- <div id ="close_modal" onClick="close_pop();">
		            <span class="pop_bt">
		                    보내기
		            </span>
		        </div> -->
		      </div>
		 
		    </div>
		        <!--End Modal-->
		        
	        <script type="text/javascript">

	        //팝업 Close 기능
	        function close_pop(flag) {
	             $('#myModal').hide();
	        };
	
	        $("#openModal").click(function(){
	            $('#myModal').show();
	        });
	        
	      </script>
	      
        </div>

        <!-- ---------------------------- 리뷰 ---------------------------- -->
        <div id="review">

            <div id="reviewHeader">
                <div id="reviewCount">
                    <p>
                        리뷰 수 (<span><%= rCount %></span>)
                    </p>
                </div>
                <div id="reviewSeq" align="right">
                    <a href="#">최신순</a>
                    <a href="#">추천순</a>
                </div>
            </div>

                <% if(rvList.isEmpty()) { %>
                	<% if(loginMember == null) { %>
                        <p align="center" style="color:blue" onclick="return writeReview();">아직 작성된 리뷰가 없습니다. 회원님의 리뷰를 남겨주세요! <br> 리뷰 남기러 가기 </p>	
                	<% } else { %>
	                	<a id="no_review" href="<%=contextPath %>/insertReviewForm.rv?restNo=<%= rest.getRestNo() %>">
	                		<p align="center">아직 작성된 리뷰가 없습니다. 회원님의 리뷰를 남겨주세요! <br> 리뷰 남기러 가기 </p>	
	                	</a>
                	<% } %>
                <% } else { %>
                	<% for(Review rv : rvList) { %>
            <div id="reviewContent">
	                <div class="reviewContentHeader">
	                    <div class="profile">
	                        <img src="resources/img/user.png" style="width: 70px; margin-top: 5px; margin-left: 15px;">
	                    </div>
	                    <div class="nameStar" style="line-height: 25px; padding-left: 10px;">
	                        <div class="userName">
	                            <strong style="font-size: 22px;"><%= rv.getNickName() %></strong>
	                        </div>
	                        
	                        <div class="star-rating">
		                        <% for(int i = 1; i<=5; i++) { %>
		                        	<% if(i<=rv.getRating()) { %>
		                        		<label class="star" style="color:#f90">&#9733;</label>
		                        	<% } else { %>
		                        		<label class="star">&#9733;</label>
		                        	<% } %>
		                        <% } %>
	                            
	                        </div>
	                        
	                        
	                    </div>
	                    <div class="taste" align="right" style="padding-right: 20px;">
	                    </div>
	               		 	<div class="good">
		                        <div class="goodCount" align="center" style="padding-top: 20px;">
		                            <p>
		                                추천수 (<span id="likesCount<%= rv.getReviewNo() %>"></span>)
		                            </p>
		                        </div>
		                        <div class="goodbtn" align="center" style="padding-top: 20px;">
                                    <button type="button" id="likes<%= rv.getReviewNo() %>" class="btn btn-sm btn-success" style="width: 70px;" onclick="updateLikes(<%= rv.getReviewNo() %>);">공감</button> <br>
		                            <button type="button" id="report<%= rv.getReviewNo() %>" class="btn btn-sm btn-danger" style="width: 70px;">신고</button>
		                        </div>
		                    </div>
		                    
            <!-- The Modal -->
		    <div id="report_modal<%= rv.getReviewNo() %>" class="report_modal">
		 
		      <!-- Modal content -->
		      <div class="report_modal-content">
		        <form action="report.rv">
		        	<input type="hidden" name="suspectNo" value="<%= rv.getMemNo() %>">
		        	<input type="hidden" name="restNo" value="<%= rest.getRestNo() %>">
		            <p style="text-align: center;"><span style="font-size: 15pt;"><b><span style="font-size: 13pt;">유저 신고</span></b></span></p>
		            <textarea name="reportContent" class="report_modalText" cols="40" rows="10" style="resize: none;" placeholder="<%= rv.getNickName() %>님을 신고하실 내용을 적어주세요."></textarea>
		            <br>
		                
		        <hr>
		        <div align="center">
		            <button class="report_close_modal" name="report">보내기</button>
		        </div>
		        </form>
		        <!-- <div id ="close_modal" onClick="close_pop();">
		            <span class="pop_bt">
		                    보내기
		            </span>
		        </div> -->
		      </div>
		 
		    </div>
		        <!--End Modal-->
		        
	        <script type="text/javascript">

	        //팝업 Close 기능
	        function close_pop(flag) {
	            $("#report_modal<%= rv.getReviewNo() %>").hide();
	        };
	
	        $("#report<%= rv.getReviewNo() %>").click(function(){
	            $("#report_modal<%= rv.getReviewNo() %>").show();
	        });
	        
	      </script>
	                
	                </div>
	                <div class="review_content">
	                    <div><%= rv.getReviewContent() %></div>
	                </div>
	                <div class="reviewPhotoList">
	             
	                    <ul>
	                        <li>
	                        	<% for(Attachment at : rvPicList) { %>
	                        		<a class="test1" href="<%= contextPath %>/detail.rv" style="text-decoration:none; color:black;" id="<%= rv.getReviewNo()%>">
	                        		<%if(rv.getReviewNo() == at.getRefBoardNo()) { %> 	
	                         			<img src="<%= contextPath %><%= at.getFilePath() %>">
	                        		<%} %>
	                         	</a>
	                        	<% } %>
	                        
	                         	<!-- 사진이 있는 경우 -->
	                         	
	                        </li>
	                    </ul>
	                </div>
	                <hr>
            </div>
                	<% } %>
                <% } %>
        </div>
    </div>
    
    
    
     <script>
     	
     	// 즐겨찾기 추가, 삭제 함수
		function updateFavorite(){
			$.ajax({
				url:"updateFavorite.rt",
				data:{restNo:<%= rest.getRestNo() %>},
				type:"post",
				success: function(result){
					console.log(result);
					if(result == "loginFirst"){
						alert("로그인을 먼저 해주세요.");
					}else if(result == "delete"){
						alert("즐겨찾기가 해제되었습니다.")
						checkFavorite();
						favorCount();
					}else if(result == "insert"){
						alert("즐겨찾기에 추가되었습니다.")
						checkFavorite();
						favorCount();
					}
				}
			})             			
		}
     	
		 // 즐겨찾기 되어있는지 확인하는 함수 생성, 선언
	 	function checkFavorite(){
		  console.log("zzz")
	 		$.ajax({
	 			url:"checkFavorite.rt",
	 			data:{restNo:<%= rest.getRestNo() %>},
	 			type:"post",
	 			success: function(result){
	 				if(result > 0){
	 	        		$("#favoriteImg").attr("src", "resources/img/heart.png");
	 	        	}else{
	 	        		$("#favoriteImg").attr("src", "resources/img/noheart.png");
	 	        	}
	 			}
	 		})	
	 	}	
     
			checkFavorite();

		  // 즐겨찾기 총 합 조회 함수
		  	function favorCount(){
		 	 $.ajax({
		 		 url:"favorCount.rt",
		 		 data:{restNo:<%= rest.getRestNo() %>},
					 type:"post",
					 success: function(result){
						 $("#favorite span").text(result);
					 }
		 	 })
		  }
		 
		// 리뷰 좋아요 되어있는지 확인하는 함수 생성, 선언
    	function checkLikes(CapReviewNo){
    		$.ajax({
    			url:"checkLikes.rv",
    			data:{reviewNo:CapReviewNo},
    			type:"post",
    			success: function(result){
    				if(result > 0){
    	        		$("#likes" + CapReviewNo).text("좋아요완료");
    	        	}else{
    	        		$("#likes" + CapReviewNo).text("좋아요해제완료");
    	        	}
    			}
    		})	
    	}	
		checkLikes();
   
     
      	// 좋아요 총 합 조회 함수
      	function LikesCount(CapReviewNo){
	     	 $.ajax({
	    		 url:"likesCount.rv",
	    		 data:{reviewNo:CapReviewNo},
				 type:"post",
				 success: function(result){
				 console.log("좋아요수" + result)
				 $("#likesCount" + CapReviewNo).text(result);
				 }
	     	 })
      	}
		
		 // 좋아요 추가, 삭제 함수
		function updateLikes(reviewNo){
			$.ajax({
				url:"updateLikes.rv",
				data:{reviewNo:reviewNo},
				type:"post",
				success: function(result){
					var CapReviewNo = reviewNo;
					console.log(result);
					if(result == "loginFirst"){
						alert("로그인을 먼저 해주세요.");
					}else if(result == "delete"){
						alert("좋아요가 해제되었습니다.")
						LikesCount(CapReviewNo);
						checkLikes(CapReviewNo);
					}else if(result == "insert"){
						alert("좋아요에 추가되었습니다.")
						LikesCount(CapReviewNo);
						checkLikes(CapReviewNo);
					}
				}
			})             			
		}
		
		function writeReview(){
				alert("로그인을 해주시기 바랍니다.");
				return false;
		}

		$("#writeReview").mouseover(function(){
			$("#review-content").css("color", "red");
		})
		$("#writeReview").mouseleave(function(){
			$("#review-content").css("color", "");
		})
		
		$("#like-area").mouseover(function(){
			$("#like-content").css("color", "red");
		})
		$("#like-area").mouseleave(function(){
			$("#like-content").css("color", "");
		})
		
		
     </script>
</body>
</html>