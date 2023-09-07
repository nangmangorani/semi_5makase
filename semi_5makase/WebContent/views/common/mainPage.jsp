<%@page import="com.semi_5makase.restaurant.model.service.RestaurantService"%>
<%@page import="com.semi_5makase.restaurant.model.vo.Restaurant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Restaurant> tvList = new RestaurantService().selectMainTvRestInfo();
	ArrayList<Restaurant> editorList = new RestaurantService().selectEditorRestInfo();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.css" rel="stylesheet">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.css" rel="stylesheet">
    <link href="resources/css/mainbody.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.js"></script>
    
    <script>
        $(document).ready(function(){
	          $('.slick').slick({
                rows: 2,
                slidesToShow:2,
                slidesToScroll:2,
                dots: true,
	          }) 
	       });
    </script>
</head>
<style>
	@font-face {
        font-family: 'SUITE-Regular';
        src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/SUITE-Regular.woff2') format('woff2');
        font-weight: 400;
        font-style: normal;
        }

    .header-area{
    position: relative;
    width: 100%;
    height: 15%;
    background-image: url("resources/img/pork-cutlet2.jpg");
    background-size: cover;
	}

	.navbar{
	    background-color: rgb(240, 240, 240);
	    width: 100%;
	    height: 2%;
	}
	
	.restaurant-item img{
		width: 470px;
		height: 270px;
		margin: 20px;
	}

</style>
<body>

	<%@ include file="menubar.jsp" %>
	
    <div class="outer">
        <div class="navbar" align="center">
            <div class="menu"><a href="<%= contextPath %>/list.no?cpage=1">공지사항</a></div>
            <div class="menu"><a href="<%=contextPath%>/list.faq">자주묻는 질문</a></div>
            <div class="menu"><a href="<%= contextPath %>/list.qna?cpage=1">Q&A</a></div>
        </div>
        <div class="header-area">
            <div class="bg">솔직한 리뷰, 믿을 수 있는 평점 <br> <b>이눔세끼</b> </div>
        </div>
        <div class="best-area">
            <h2>믿고 보는 맛집 리스트</h2>
        </div>
        
        <div class="top-list slick slider" id="wrapper">
            <ul>
                <li class="fl">
                    <a href="#해당 이미지 상세정보창">
                        <figure class="top-list-info">
                            <div>                              
                                <img src="resources/img/hansik.jpg" value="1">
                            <figcaption>
                                <div class="list-pic-comment">
                                    <span class="title">한식 맛집 TOP 11</span>
                                    <p>"이것은 한국의 혼"</p>
                                </div>
                            </figcaption>
                            </div>
                        </figure>
                    </a>
                </li>
            </ul>
            <ul>
                <li class="fl">
                    <a href="#해당 이미지 상세정보창">
                        <figure class="top-list-info">
                            <div>                              
                                <img src="resources/img/jungsik.jpg" value="2">
                            <figcaption>
                                <div class="list-pic-comment">
                                    <span class="title">중식 맛집 TOP 5</span>
                                    <p>"짜장면 짬뽕 난 짬짜면"</p>
                                </div>
                            </figcaption>
                            </div>
                        </figure>
                    </a>
                </li>
            </ul>
            <ul>
                <li class="fl">
                    <a href="#해당 이미지 상세정보창">
                        <figure class="top-list-info">
                            <div>                              
                                <img src="resources/img/ilsik.jpg" value="3">
                            <figcaption>
                                <div class="list-pic-comment">
                                    <span class="title">일식 맛집 TOP 4</span>
                                    <p>"벌써부터 느껴지는 장인정신"</p>
                                </div>
                            </figcaption>
                            </div>
                        </figure>
                    </a>
                </li>
            </ul>
            <ul>
                <li class="fl">
                    <a href="#해당 이미지 상세정보창">
                        <figure class="top-list-info">
                            <div>                              
                                <img src="resources/img/yangsik.jpg" value="4">
                            <figcaption>
                                <div class="list-pic-comment">
                                    <span class="title">양식 맛집 TOP 7</span>
                                    <p>"오늘은 치즈가 땡긴다"</p>
                                    <input type="hidden" value="토마토" class="zz">
                                </div>
                            </figcaption>
                            </div>
                        </figure>
                    </a>
                </li>
            </ul>
            <ul>
                <li class="fl">
                    <a href="#해당 이미지 상세정보창">
                        <figure class="top-list-info">
                            <div>                              
                                <img src="resources/img/myunyori.jpg"  value="6">
                            <figcaption>
                                <div class="list-pic-comment">
                                    <span class="title">면요리 맛집 TOP 7</span>
                                    <p>"면치기 금지"</p>
                                </div>
                            </figcaption>
                            </div>
                        </figure>
                    </a>
                </li>
            </ul>
            <ul>
                <li class="fl">
                    <a href="#해당 이미지 상세정보창">
                        <figure class="top-list-info">
                            <div>                              
                                <img src="resources/img/sundaesoup.jpg" value="7">
                            <figcaption>
                                <div class="list-pic-comment">
                                    <span class="title">국밥류 맛집 TOP 6</span>
                                    <p>"이 돈이면 국밥이 몇그릇.."</p>
                                </div>
                            </figcaption>
                            </div>
                        </figure>
                    </a>
                </li>
            </ul>
            <ul>
                <li class="fl">
                    <a href="#해당 이미지 상세정보창">
                        <figure class="top-list-info">
                            <div>                              
                                <img src="resources/img/tteokbokki.jpg" value="8">
                            <figcaption>
                                <div class="list-pic-comment">
                                    <span class="title">분식 TOP 6</span>
                                    <p>"떡튀순 세트 하나주세요"</p>
                                </div>
                            </figcaption>
                            </div>
                        </figure>
                    </a>
                </li>
            </ul>
            <ul>
                <li class="fl">
                    <a href="#해당 이미지 상세정보창">
                        <figure class="top-list-info">
                            <div>                              
                                <img src="resources/img/piggas.jpg" value="9">
                            <figcaption>
	                            <div class="list-pic-comment">
	                                <span class="title">돈카츠 맛집 TOP 2</span>
	                                <p>"바사삭 바사삭"</p>
	                            </div>
                            </figcaption>
                            </div>
                        </figure>
                    </a>
                </li>
            </ul>
        </div>
        <script>
        	$(".top-list-info img").click(function(){
        		var cateNo = $(this).attr("value")
        		var cateName = $(this).closest("figure").find("span").text();   
        		console.log(cateNo);
        		location.href="<%= contextPath %>/main.rt?value=" + cateNo + "&&cateName=" + cateName;
        	})
        </script>
        
        <hr>
        <section class="main_most_popular_restaurant">
            <h2 id="editor-select">TV에 나온 음식점</h2>
            <div class="popular_restaurant_container">
                <ul>
                	<% for(int i=0; i<3; i++) { %>
                    <li class="fl">
                    	<div class="tvinfo-container">
	                    	<div class="tvinfo-area">
		                        <a href="<%= contextPath %>/detail.rt?restNo=<%= tvList.get(i).getRestNo() %>">
		                            <img src="<%= tvList.get(i).getTitleImg() %>"  style="width:320px; height:210px; margin:10px;">
		                                <div class="info" style="margin:10px;">
		                                    <span class="title1"><%= tvList.get(i).getRestName() %></span>
		                                    <strong><%= tvList.get(i).getAvg2() %></strong>
		                                    <p><%= tvList.get(i).getMainAddress() %> - <%= tvList.get(i).getCategoryName() %></p>
		                                </div>
		                        </a>
	                    	</div>
                    	</div>
                    </li>          
                <% } %>
                </ul>
                <ul>
                	<% for(int i=3; i<6; i++) { %>
                    <li class="fl">
                        <a href="<%= contextPath %>/detail.rt?restNo=<%= tvList.get(i).getRestNo() %>">
                            <img src="<%= tvList.get(i).getTitleImg() %>"  style="width:320px; height:210px; margin:10px;">
                                <div class="info" style="margin:10px;">
                                    <span class="title1"><%= tvList.get(i).getRestName() %></span>
                                    <strong><%= tvList.get(i).getAvg2() %></strong>
                                    <p><%= tvList.get(i).getMainAddress() %> - <%= tvList.get(i).getCategoryName() %></p>
                                </div>
                        </a>
                    </li>          
                <% } %>
                
                </ul>
                        <!-- 
                        <script>
                        	$.ajax({
                        		url:"mainInfo.rv",
                        		data:{restNo:2},
                        		success:function(result){
                        			const rn = result.restName
                        			$(".title1").text(rn);
                        			
                        			console.log(rn);
                        		}, error:function(){
                        			console.log("실패");
                        		}
                        	})	

                        </script>
                         -->
                </ul>
            </div>
        </section>
       <hr>
       <section class="main_most_popular_restaurant">
        <h2 id="editor-select">에디터가 선정한 식당</h2>
        <div class="popular_restaurant_container">
            <ul>
                <% for(int i=0; i<3; i++) { %>
                    <li class="fl">
                        <a href="<%= contextPath %>/detail.rt?restNo=<%= editorList.get(i).getRestNo() %>">
                            <img src="<%= editorList.get(i).getTitleImg() %>" style="width:320px; height:210px; margin:10px;" >
                                <div class="info" style="margin:10px;">
                                    <span class="title1"><%= editorList.get(i).getRestName() %></span>
                                    <strong><%= editorList.get(i).getAvg2() %></strong>
                                    <p><%= editorList.get(i).getMainAddress() %> - <%= editorList.get(i).getCategoryName() %></p>
                                </div>
                        </a>
                    </li>          
                <% } %>
                </ul>
                <ul>
                	<% for(int i=3; i<6; i++) { %>
                    <li class="fl">
                        <a href="<%= contextPath %>/detail.rt?restNo=<%= editorList.get(i).getRestNo() %>">
                            <img src="<%= editorList.get(i).getTitleImg() %>" style="width:320px; height:210px; margin:10px;">
                                <div class="info" style="margin:10px;">
                                    <span class="title1"><%= editorList.get(i).getRestName() %></span>
                                    <strong><%= editorList.get(i).getAvg2() %></strong>
                                    <p><%= editorList.get(i).getMainAddress() %> - <%= editorList.get(i).getCategoryName() %></p>
                                </div>
                        </a>
                    </li>          
                <% } %>
            </ul>
        </div>
    </section>
    <hr>
    <section class="main_most_popular_restaurant">
        <h2 id="editor-select">지역별 맛집 추천</h2>
        <div class="popular_restaurant_container">
            <ul>
                <li class="fl">
                 	<a href="#해당 이미지 상세정보창">
                     <figure class="restaurant-item">
                         <div>                              
                             <img class="restaurant-item-image" src="resources/img/guro.jpg" value="구로구">
                         <figcaption>
                             <div class="info tv_info">
                                 <span class="title">구로구 top 7</span>
                                 <p>"구로구 맛집 뽑았다!! 모여라!!"</p>
                             </div>
                         </figcaption>
                         </div>
                     </figure> 
                     </a>
                </li>
                <li class="fl">
                    <figure class="restaurant-item">
                        <div>                              
                   			<a href="#해당 이미지 상세정보창">
                            <img class="restaurant-item-image" src="resources/img/gangnam.jpg" value="강남구">
                            </a>
                        </div>
                        <figcaption>
                            <div class="info tv_info">
                                <span class="title">강남구 top 7</span>
                                <p>"맛집의 메카 강남에서 볼래?"</p>
                            </div>
                        </figcaption>
                    </figure>
                </li>
            </ul>
            <ul>
                <li class="fl">
                    <figure class="restaurant-item">
                        <div>                              
                			<a href="#해당 이미지 상세정보창">
                            <img class="restaurant-item-image" src="resources/img/yeongdeungpo.jpg" value="영등포구">
                            </a>
                        </div>
                        <figcaption>
                            <div class="info tv_info">
                                <span class="title">영등포 top 7</span>
                                <p>"영등포에 맛 없는게 없다! 인정?"</p>
                            </div>
                        </figcaption>
                    </figure>
                </li>
                <li class="fl">
                    <figure class="restaurant-item">
                        <div>                              
              			    <a href="#해당 이미지 상세정보창">
                            <img class="restaurant-item-image" src="resources/img/mapo.jpg" value="마포구">
                            </a>
                        </div>
                        <figcaption>
                            <div class="info tv_info">
                                <span class="title">마포구 top 7</span>
                                <p>"마포구 어딜가나 맛집이라며?"</p>
                            </div>
                        </figcaption>
                    </figure>
                </li>
            </ul>
        </div>
         <script>
        	$(".restaurant-item img").click(function(){
        		var locaNo = $(this).attr("value")
        		console.log(locaNo);
        		var cateName = $(this).closest("figure").find("span").text();   
        		location.href="<%= contextPath %>/mainLc.rt?value=" + locaNo + "&&cateName=" + cateName;
        	})
        </script>
    </section>
    </div>
    
    <%@ include file="footer.jsp" %>
    
</body>
</html>