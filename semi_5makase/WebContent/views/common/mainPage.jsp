<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.css" rel="stylesheet">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.css" rel="stylesheet">
    <link href="resources/css/mainbody.css" rel="stylesheet">
    
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
    .header-area{
    position: relative;
    width: 100%;
    height: 15%;
    background-image: url("resources/img/pork-cutlet2.jpg");
    background-size: cover;
    
}
</style>
<body>

	<%@ include file="menubar.jsp" %>
	
    <div class="outer">
        <div class="navbar" align="center">
            <div class="menu"><a href="">HOME</a></div>
            <div class="menu"><a href="<%= contextPath %>/list.no?cpage=1">공지사항</a></div>
            <div class="menu"><a href="<%=contextPath%>/list.faq">자주묻는 질문</a></div>
            <div class="menu"><a href="">Q&A</a></div>
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
                                <img src="resources/img/bibimbap.jpg">
                            </div>
                            <figcaption>
                                <div class="list-pic-comment">
                                    <span>비빔맛 맛집 TOP 10</span>
                                    <p>"이것은 한국의 혼"</p>
                                </div>
                            </figcaption>
                        </figure>
                    </a>
                </li>
            </ul>
            <ul>
                <li class="fl">
                    <a href="#해당 이미지 상세정보창">
                        <figure class="top-list-info">
                            <div>                              
                                <img src="resources/img/chinese.jpg">
                            </div>
                            <figcaption>
                                <div class="list-pic-comment">
                                    <span class="title">중식 맛집 TOP 5</span>
                                    <p>"짜장면 짬뽕 난 짬짜면"</p>
                                </div>
                            </figcaption>
                        </figure>
                    </a>
                </li>
            </ul>
            <ul>
                <li class="fl">
                    <a href="#해당 이미지 상세정보창">
                        <figure class="top-list-info">
                            <div>                              
                                <img src="resources/img/cooking.jpg">
                            </div>
                            <figcaption>
                                <div class="list-pic-comment">
                                    <span class="title">김치찌개 맛집 TOP3</span>
                                    <p>"스팸 돼지고기 꽁치"</p>
                                </div>
                            </figcaption>
                        </figure>
                    </a>
                </li>
            </ul>
            <ul>
                <li class="fl">
                    <a href="#해당 이미지 상세정보창">
                        <figure class="top-list-info">
                            <div>                              
                                <img src="resources/img/pasta.jpg">
                            </div>
                            <figcaption>
                                <div class="list-pic-comment">
                                    <span class="title">서양 국시 TOP 5</span>
                                    <p>"난 토마토"</p>
                                </div>
                            </figcaption>
                        </figure>
                    </a>
                </li>
            </ul>
            <ul>
                <li class="fl">
                    <a href="#해당 이미지 상세정보창">
                        <figure class="top-list-info">
                            <div>                              
                                <img src="resources/img/ramen.jpg">
                            </div>
                            <figcaption>
                                <div class="list-pic-comment">
                                    <span class="title">라멘 맛집 TOP 5</span>
                                    <p>"매장안에 원피스 피규어 필수"</p>
                                </div>
                            </figcaption>
                        </figure>
                    </a>
                </li>
            </ul>
            <ul>
                <li class="fl">
                    <a href="#해당 이미지 상세정보창">
                        <figure class="top-list-info">
                            <div>                              
                                <img src="resources/img/soup.jpg">
                            </div>
                            <figcaption>
                                <div class="list-pic-comment">
                                    <span class="title">분식 맛집 TOP 3</span>
                                    <p>"라면 돈까스 김밥 국룰"</p>
                                </div>
                            </figcaption>
                        </figure>
                    </a>
                </li>
            </ul>
            <ul>
                <li class="fl">
                    <a href="#해당 이미지 상세정보창">
                        <figure class="top-list-info">
                            <div>                              
                                <img src="resources/img/tteokbokki.jpg">
                            </div>
                            <figcaption>
                                <div class="list-pic-comment">
                                    <span class="title">국밥류 TOP 3</span>
                                    <p>"이 돈이면 국밥이 몇그릇.."</p>
                                </div>
                            </figcaption>
                        </figure>
                    </a>
                </li>
            </ul>
            <ul>
                <li class="fl">
                    <a href="#해당 이미지 상세정보창">
                        <figure class="top-list-info">
                            <div>                              
                                <img src="resources/img/pasta.jpg">
                            </div>
                            <figcaption>
                                <div class="list-pic-comment">
                                    <span class="title">한식 맛집 TOP 3</span>
                                    <p>"주모 샤따내려"</p>
                                </div>
                            </figcaption>
                        </figure>
                    </a>
                </li>
            </ul>
        </div>
        <br>
        <hr>
        <section class="main_most_popular_restaurant">
            <h2 id="editor-select">에디터가 선정한 식당</h2>
            <div class="popular_restaurant_container">
                <ul>
                    <li class="fl">
                        <a href="<%= contextPath %>/detail.rt?restNo=1">
                            <img src="resources/img/bibimbap.jpg">
                                <div class="info">
                                    <span class="title">래언 예시</span>
                                    <strong>3.8</strong>
                                    <p>서울 역삼동 - 고기 / 제육</p>
                                </div>
                        </a>
                    </li>
                    <li class="fl">
                        <a href="#해당 이미지 상세정보창">
                            <img src="resources/img/bibimbap.jpg">
                                <div class="info">
                                    <span class="title">새마을 식당</span>
                                    <strong>3.8</strong>
                                    <p>서울 역삼동 - 고기 / 제육</p>
                                </div>
                        </a>
                    </li>
                    <li class="fl">
                        <a href="#해당 이미지 상세정보창">
                            <img src="resources/img/bibimbap.jpg">
                                <div class="info">
                                    <span class="title">새마을 식당</span>
                                    <strong>3.8</strong>
                                    <p>서울 역삼동 - 고기 / 제육</p>
                                </div>
                        </a>
                    </li>
                </ul>
                <ul>
                    <li class="fl">
                        <a href="#해당 이미지 상세정보창">
                            <img src="resources/img/bibimbap.jpg">
                                <div class="info">
                                    <span class="title">새마을 식당</span>
                                    <strong>3.8</strong>
                                    <p>서울 역삼동 - 고기 / 제육</p>
                                </div>
                        </a>
                    </li>
                    <li class="fl">
                        <a href="#해당 이미지 상세정보창">
                            <img src="resources/img/bibimbap.jpg">
                                <div class="info">
                                    <span class="title">새마을 식당</span>
                                    <strong>3.8</strong>
                                    <p>서울 역삼동 - 고기 / 제육</p>
                                </div>
                        </a>
                    </li>
                    <li class="fl">
                        <a href="#해당 이미지 상세정보창">
                            <img src="resources/img/bibimbap.jpg">
                                <div class="info">
                                    <span class="title">새마을 식당</span>
                                    <strong>3.8</strong>
                                    <p>서울 역삼동 - 고기 / 제육</p>
                                </div>
                        </a>
                    </li>
                </ul>
            </div>
        </section>
       <hr>
       <section class="main_most_popular_restaurant">
        <h2 id="editor-select">지금 날씨에 먹기좋은 음식</h2>
        <div class="popular_restaurant_container">
            <ul>
                <li class="fl">
                    <a href="#해당 이미지 상세정보창">
                        <img src="resources/img/bibimbap.jpg">
                            <div class="info">
                                <span class="title">새마을 식당</span>
                                <strong>3.8</strong>
                                <p>서울 역삼동 - 고기 / 제육</p>
                            </div>
                    </a>
                </li>
                <li class="fl">
                    <a href="#해당 이미지 상세정보창">
                        <img src="resources/img/bibimbap.jpg">
                            <div class="info">
                                <span class="title">새마을 식당</span>
                                <strong>3.8</strong>
                                <p>서울 역삼동 - 고기 / 제육</p>
                            </div>
                    </a>
                </li>
                <li class="fl">
                    <a href="#해당 이미지 상세정보창">
                        <img src="resources/img/bibimbap.jpg">
                            <div class="info">
                                <span class="title">새마을 식당</span>
                                <strong>3.8</strong>
                                <p>서울 역삼동 - 고기 / 제육</p>
                            </div>
                    </a>
                </li>
            </ul>
            <ul>
                <li class="fl">
                    <a href="#해당 이미지 상세정보창">
                        <img src="resources/img/bibimbap.jpg">
                            <div class="info">
                                <span class="title">새마을 식당</span>
                                <strong>3.8</strong>
                                <p>서울 역삼동 - 고기 / 제육</p>
                            </div>
                    </a>
                </li>
                <li class="fl">
                    <a href="#해당 이미지 상세정보창">
                        <img src="resources/img/bibimbap.jpg">
                            <div class="info">
                                <span class="title">새마을 식당</span>
                                <strong>3.8</strong>
                                <p>서울 역삼동 - 고기 / 제육</p>
                            </div>
                    </a>
                </li>
                <li class="fl">
                    <a href="#해당 이미지 상세정보창">
                        <img src="resources/img/bibimbap.jpg">
                            <div class="info">
                                <span class="title">새마을 식당</span>
                                <strong>3.8</strong>
                                <p>서울 역삼동 - 고기 / 제육</p>
                            </div>
                    </a>
                </li>
            </ul>
        </div>
    </section>
    <hr>
    <section class="main_most_popular_restaurant">
        <h2 id="editor-select">점메추</h2>
        <div class="popular_restaurant_container">
            <ul>
                <li class="fl">
                     <figure class="restaurant-item">
                         <div>                              
                   			 <a href="#해당 이미지 상세정보창">
                             <img class="restaurant-item-image" src="resources/img/bibimbap.jpg">
                             </a>
                         </div>
                         <figcaption>
                             <div class="info tv_info">
                                 <span class="title">뭐시구 top 10</span>
                                 <p>"뭐시구 뭐시구 뭐시구 뭐시구"</p>
                             </div>
                         </figcaption>
                     </figure> 
                </li>
                <li class="fl">
                    <figure class="restaurant-item">
                        <div>                              
                   			<a href="#해당 이미지 상세정보창">
                            <img src="resources/img/bibimbap.jpg">
                            </a>
                        </div>
                        <figcaption>
                            <div class="info tv_info">
                                <span class="title">뭐시구 top 10</span>
                                <p>"뭐시구 뭐시구 뭐시구 뭐시구"</p>
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
                            <img src="resources/img/bibimbap.jpg">
                            </a>
                        </div>
                        <figcaption>
                            <div class="info tv_info">
                                <span class="title">뭐시구 top 10</span>
                                <p>"뭐시구 뭐시구 뭐시구 뭐시구"</p>
                            </div>
                        </figcaption>
                    </figure>
                </li>
                <li class="fl">
                    <figure class="restaurant-item">
                        <div>                              
              			    <a href="#해당 이미지 상세정보창">
                            <img src="resources/img/bibimbap.jpg">
                            </a>
                        </div>
                        <figcaption>
                            <div class="info tv_info">
                                <span class="title">뭐시구 top 10</span>
                                <p>"뭐시구 뭐시구 뭐시구 뭐시구"</p>
                            </div>
                        </figcaption>
                    </figure>
                </li>
            </ul>
        </div>
    </section>
    </div>
</body>
</html>