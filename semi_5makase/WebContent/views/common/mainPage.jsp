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
	
	.inputuse{
		border:none;
		background-color:white;
	}

</style>
<body>

	<%@ include file="menubar.jsp" %>
	
    <div class="outer">
        <div class="navbar" align="center">
            <div class="menu"><a href="<%= contextPath %>/list.no?cpage=1">공지사항</a></div>
            <div class="menu"><a href="<%=contextPath%>/list.faq">자주묻는 질문</a></div>
            <div class="menu"><a href="<%= contextPath %>/list.qna?cpage=1">QNA</a></div>
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
                	<form action="<%= contextPath %>/main.rt">
                		<input type="hidden" name="value" value="1">
                		<input type="hidden" name="cateName" value="한식 맛집 TOP 11">
	                    <div>
	                        <figure class="top-list-info">
	                            <div>
	                            <button class="inputuse">
	                                <img src="resources/img/hansik.jpg">
	                            </button>                              
	                                <div class="list-pic-comment">
	                                    <span class="title">한식 맛집 TOP 11</span>
	                                    <p>"이것은 한국의 혼"</p>
	                                </div>
	                            </div>
	                        </figure>
	                    </div>
                	</form>
                </li>
            </ul>
            <ul>
                <li class="fl">
                	<form action="<%= contextPath %>/main.rt">
                		<input type="hidden" name="value" value="2">
                		<input type="hidden" name="cateName" value="중식 맛집 TOP 5">
	                    <div>
	                        <figure class="top-list-info">
	                            <div>
	                            <button class="inputuse">
	                                <img src="resources/img/jungsik.jpg">
	                            </button>                              
	                                <div class="list-pic-comment">
	                                    <span class="title">중식 맛집 TOP 5</span>
	                                    <p>"짜장면 짬뽕 난 짬짜면"</p>
	                                </div>
	                            </div>
	                        </figure>
	                    </div>
                	</form>
                </li>
            </ul>
            <ul>
                <li class="fl">
                	<form action="<%= contextPath %>/main.rt">
                		<input type="hidden" name="value" value="3">
                		<input type="hidden" name="cateName" value="일식 맛집 TOP 4">
	                    <div>
	                        <figure class="top-list-info">
	                            <div>
	                            <button class="inputuse">
	                                <img src="resources/img/ilsik.jpg">
	                            </button>                              
	                                <div class="list-pic-comment">
	                                    <span class="title">일식 맛집 TOP 4</span>
	                                    <p>"벌써부터 느껴지는 장인정신"</p>
	                                </div>
	                            </div>
	                        </figure>
	                    </div>
                	</form>
                </li>
            </ul>
            <ul>
                <li class="fl">
                	<form action="<%= contextPath %>/main.rt">
                		<input type="hidden" name="value" value="4">
                		<input type="hidden" name="cateName" value="양식 맛집 TOP 7">
	                    <div>
	                        <figure class="top-list-info">
	                            <div>
	                            <button class="inputuse">
	                                <img src="resources/img/yangsik.jpg">
	                            </button>                              
	                                <div class="list-pic-comment">
	                                    <span class="title">양식 맛집 TOP 7</span>
	                                    <p>"오늘은 치즈가 땡긴다"</p>
	                                </div>
	                            </div>
	                        </figure>
	                    </div>
                	</form>
                </li>
            </ul>
            <ul>
                 <li class="fl">
                	<form action="<%= contextPath %>/main.rt">
                		<input type="hidden" name="value" value="6">
                		<input type="hidden" name="cateName" value="면요리 맛집 TOP 8">
	                    <div>
	                        <figure class="top-list-info">
	                            <div>
	                            <button class="inputuse">
	                                <img src="resources/img/myunyori.jpg">
	                            </button>                              
	                                <div class="list-pic-comment">
	                                    <span class="title">면요리 맛집 TOP 8</span>
	                                    <p>"면치기 금지"</p>
	                                </div>
	                            </div>
	                        </figure>
	                    </div>
                	</form>
                </li>
            </ul>
            <ul>
                <li class="fl">
                	<form action="<%= contextPath %>/main.rt">
                		<input type="hidden" name="value" value="7">
                		<input type="hidden" name="cateName" value="국밥류 맛집 TOP 6">
	                    <div>
	                        <figure class="top-list-info">
	                            <div>
	                            <button class="inputuse">
	                                <img src="resources/img/sundaesoup.jpg">
	                            </button>                              
	                                <div class="list-pic-comment">
	                                    <span class="title">국밥류 맛집 TOP 6</span>
	                                    <p>"이 돈이면 국밥이 몇그릇.."</p>
	                                </div>
	                            </div>
	                        </figure>
	                    </div>
                	</form>
                </li>
            </ul>
            <ul>
                <li class="fl">
                	<form action="<%= contextPath %>/main.rt">
                		<input type="hidden" name="value" value="8">
                		<input type="hidden" name="cateName" value="분식 맛집 TOP 6">
	                    <div>
	                        <figure class="top-list-info">
	                            <div>
	                            <button class="inputuse">
	                                <img src="resources/img/tteokbokki.jpg">
	                            </button>                              
	                                <div class="list-pic-comment">
	                                    <span class="title">분식 맛집 TOP 6</span>
	                                    <p>"사장님 여기 떡튀순 세트요"</p>
	                                </div>
	                            </div>
	                        </figure>
	                    </div>
                	</form>
                </li>
            </ul>
            <ul>
                <li class="fl">
                	<form action="<%= contextPath %>/main.rt">
                		<input type="hidden" name="value" value="9">
                		<input type="hidden" name="cateName" value="돈카츠 맛집 TOP 2">
	                    <div>
	                        <figure class="top-list-info">
	                            <div>
	                            <button class="inputuse">
	                                <img src="resources/img/piggas.jpg">
	                            </button>                              
	                                <div class="list-pic-comment">
	                                    <span class="title">돈카츠 맛집 TOP 2</span>
	                                    <p>"바사삭 치이이이이즈"</p>
	                                </div>
	                            </div>
	                        </figure>
	                    </div>
                	</form>
                </li>
            </ul>
        </div>
        <script>
        /*
        	$(".top-list-info img").click(function(){
        		var cateNo = $(this).attr("value")
        		var cateName = $(this).closest("figure").find("span").text();   
        		console.log(cateNo);
        		location.href="<%= contextPath %>/main.rt?value=" + cateNo + "&&cateName=" + cateName;
        	})
        */
        </script>
        
        <hr>
        <section class="main_most_popular_restaurant">
            <h2 id="editor-select">TV에 나온 음식점</h2>
            <div class="popular_restaurant_container">
                <ul>
                	<% for(int i=0; i<3; i++) { %>
                    <li class="fl">
                    	<div class="tvinfo-area">
                    		<form action="<%= contextPath %>/detail.rt">
                    			<input type="hidden" name="restNo" value="<%= tvList.get(i).getRestNo() %>">
                    			<button class="inputuse">
		                            <img src="<%= tvList.get(i).getTitleImg() %>"  style="width:320px; height:210px; margin:10px;">
                    			</button>
	                                <div class="info" style="margin:5px 20px;">
	                                    <span class="title1"><%= tvList.get(i).getRestName() %></span>
	                                    <strong><%= tvList.get(i).getAvg2() %></strong>
	                                    <p><%= tvList.get(i).getMainAddress() %> - <%= tvList.get(i).getCategoryName() %></p>
	                                </div>
                    		</form>
                    	</div>
                    </li>          
               		<% } %>
                </ul>
                <ul>
                	<% for(int i=3; i<6; i++) { %>
                    <li class="fl">
                    	<div class="tvinfo-area">
                    		<form action="<%= contextPath %>/detail.rt">
                    			<input type="hidden" name="restNo" value="<%= tvList.get(i).getRestNo() %>">
                    			<button class="inputuse">
		                            <img src="<%= tvList.get(i).getTitleImg() %>"  style="width:320px; height:210px; margin:10px;">
                    			</button>
	                                <div class="info" style="margin:5px 20px;">
	                                    <span class="title1"><%= tvList.get(i).getRestName() %></span>
	                                    <strong><%= tvList.get(i).getAvg2() %></strong>
	                                    <p><%= tvList.get(i).getMainAddress() %> - <%= tvList.get(i).getCategoryName() %></p>
	                                </div>
                    		</form>
                    	</div>
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
                    	<div class="tvinfo-area">
                    		<form action="<%= contextPath %>/detail.rt">
                    			<input type="hidden" name="restNo" value="<%= editorList.get(i).getRestNo() %>">
                    			<button class="inputuse">
		                            <img src="<%= editorList.get(i).getTitleImg() %>"  style="width:320px; height:210px; margin:10px;">
                    			</button>
	                                <div class="info" style="margin:5px 20px;">
	                                    <span class="title1"><%= editorList.get(i).getRestName() %></span>
	                                    <strong><%= editorList.get(i).getAvg2() %></strong>
	                                    <p><%= editorList.get(i).getMainAddress() %> - <%= editorList.get(i).getCategoryName() %></p>
	                                </div>
                    		</form>
                    	</div>
                    </li>  
                <% } %>
                </ul>
                <ul>
                	<% for(int i=3; i<6; i++) { %>
                    <li class="fl">
                    	<div class="tvinfo-area">
                    		<form action="<%= contextPath %>/detail.rt">
                    			<input type="hidden" name="restNo" value="<%= editorList.get(i).getRestNo() %>">
                    			<button class="inputuse">
		                            <img src="<%= editorList.get(i).getTitleImg() %>"  style="width:320px; height:210px; margin:10px;">
                    			</button>
	                                <div class="info" style="margin:5px 20px;">
	                                    <span class="title1"><%= editorList.get(i).getRestName() %></span>
	                                    <strong><%= editorList.get(i).getAvg2() %></strong>
	                                    <p><%= editorList.get(i).getMainAddress() %> - <%= editorList.get(i).getCategoryName() %></p>
	                                </div>
                    		</form>
                    	</div>
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
                	<form action="<%= contextPath %>/mainLc.rt">
                		<input type="hidden" name="value" value="구로구">
                		<input type="hidden" name="cateName" value="구로구 맛집 top 10">
                        <div>                              
		                     <figure class="restaurant-item">
		                     	<div>
		                     	<button class="inputuse">
		                             <img class="restaurant-item-image" src="resources/img/guro.jpg">
		                     	</button>
	                         </div>
	                             <div class="info tv_info">
	                                 <span class="title">구로구 top 10</span>
	                                 <p>"구로구 맛집 뽑았다!! 모여라!!"</p>
                             	</div>
	                     	</figure> 
                     	</div>
                	</form>
                </li>
                <li class="fl">
                	<form action="<%= contextPath %>/mainLc.rt">
                		<input type="hidden" name="value" value="강남구">
                		<input type="hidden" name="cateName" value="강남구 맛집 top10">
                        <div>                              
		                     <figure class="restaurant-item">
		                     	<div>
		                     	<button class="inputuse">
		                             <img class="restaurant-item-image" src="resources/img/gangnam.jpg">
		                     	</button>
	                         </div>
	                             <div class="info tv_info">
	                                 <span class="title">강남구 top10</span>
	                                 <p>"맛집의 메카 강남에서 볼래?"</p>
                             	</div>
	                     	</figure> 
                     	</div>
                	</form>
                </li>
            </ul>
            <ul>
                <li class="fl">
                	<form action="<%= contextPath %>/mainLc.rt">
                		<input type="hidden" name="value" value="영등포">
                		<input type="hidden" name="cateName" value="영등포 맛집 top10">
                        <div>                              
		                     <figure class="restaurant-item">
		                     	<div>
		                     	<button class="inputuse">
		                             <img class="restaurant-item-image" src="resources/img/yeongdeungpo.jpg">
		                     	</button>
	                         </div>
	                             <div class="info tv_info">
	                                 <span class="title">영등포 top10</span>
	                                 <p>"영등포에 맛 없는게 없다! 인정?"</p>
                             	</div>
	                     	</figure> 
                     	</div>
                	</form>
                </li>
                <li class="fl">
                	<form action="<%= contextPath %>/mainLc.rt">
                		<input type="hidden" name="value" value="마포구">
                		<input type="hidden" name="cateName" value="마포구 맛집 top10">
                        <div>                              
		                     <figure class="restaurant-item">
		                     	<div>
		                     	<button class="inputuse">
		                             <img class="restaurant-item-image" src="resources/img/mapo.jpg">
		                     	</button>
	                         </div>
	                             <div class="info tv_info">
	                                 <span class="title">마포구 top10</span>
	                                 <p>"마포구에 어딜가나 맛집이라며?"</p>
                             	</div>
	                     	</figure> 
                     	</div>
                	</form>
                </li>
            </ul>
        </div>
         <script>
         /*
        	$(".restaurant-item img").click(function(){
        		var locaNo = $(this).attr("value")
        		console.log(locaNo);
        		var cateName = $(this).closest("figure").find("span").text();   
        		location.href="<%= contextPath %>/mainLc.rt?value=" + locaNo + "&&cateName=" + cateName;
        	})
     	*/
        </script>
    </section>
    </div>
    
    <%@ include file="footer.jsp" %>
    
</body>
</html>