 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
    	crossorigin="anonymous">
    <style>
        a{
            text-decoration: none;
            color: black;
        }
        div{
            /* border: 1px solid red; */
            padding: 0%;
            margin: 0%;
        }
        .accordion-body{
            padding: 0;
            margin:0;
        }
        .accordion-button {
            font-weight: bold;
            background-color: rgb(230, 230, 230);
        }
        .list-group-item>a{
            font-size: 14px;
        }

        .outline{ 
            border: 1px solid rgb(230, 230, 230);
            width: 800px; height: 600px; margin: auto;
        }
        .outline>div{
            /* border: 1px solid red; */
            box-sizing: border-box;
            float: left;
        }

        .header{
            height: 15%;
            width: 78%;
            background-color: rgb(230, 230, 230);
        }
        .menu{
            height: 100%;
            width: 22%;
            background-color: rgb(230, 230, 230);
        }
        .content{
            height: 85%;
            width: 78%;
        }

        /* -------------헤더------------- */
        .header>div{
            box-sizing: border-box;
            float: left;
            height: 100%;
        }

        #header_1{
            width: 60%;
            margin: auto;
            display: flex;
        }
        #header_2{
            width: 40%;
            box-sizing: border-box;
        }
        #header_2>*{
            float: left;
            margin-top: 30px;
            margin-left: 15px;
        }


        /* -------------메뉴------------- */
        #menu>div{
            width: 100%;
        }
        #logo{
            height: 20%;
            background-image: url(resources/img/logo.png);
            background-repeat: no-repeat;
            background-size: 80%;
            background-position: center;
        }
        #service{
            height: 80%;
        }

        /* -------------컨텐츠------------- */
        .content>div{
            width: 100%;
        }
        #content_1{
            height: 15%;
            padding: 25px;
            border-bottom: 1px solid rgb(230, 230, 230);
        }
        #content_2{
            height: 90%;
            padding: 50px;
        }
        #content_2 strong{
            font-size: 16px;
        }
        #content_2 div{
            font-size: 16px;
        }
        
    </style>
</head>
<body>
    <div class="outline">
        <!-- -------------메뉴------------- -->
        <div class="menu">
            <div id="logo">
                
            </div>
            <div class="accordion accordion-flush" id="accordionFlushExample">
                <div class="accordion-item">
                  <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                        서비스 관리
                    </button>
                  </h2>
                  <div id="flush-collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
                    <div class="accordion-body">
                                <ul class="list-group">
                                
                                	<!-- ==================== 회원 리스트 페이지로 이동 ==================== -->
                                    <li class="list-group-item" style="text-align: center;"><a href="/5makase/memberlist.ad">회원 관리</a></li>
                                    
                                    
                                    <li class="list-group-item" style="text-align: center;"><a href="">리뷰 관리</a></li>
                                    
                                    
                                    <li class="list-group-item" style="text-align: center;"><a href="">신고 현황 관리</a></li>
                                    
                                </ul>
                    </div>
                  </div>
                </div>
                <div class="accordion-item">
                  <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
                      게시판 관리
                    </button>
                  </h2>
                  <div id="flush-collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
                    <div class="accordion-body">
                        <ul class="list-group">
                            <li class="list-group-item" style="text-align: center;"><a href="">1:1 문의 관리</a></li>
                            <li class="list-group-item" style="text-align: center;"><a href="">공지사항 관리</a></li>
                            <li class="list-group-item" style="text-align: center;"><a href="">자주 묻는 질문 관리</a></li>
                        </ul>
                    </div>
                  </div>
                </div>
                <div class="accordion-item">
                    <h2 class="accordion-header">
                      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree">
                        음식점 관리
                      </button>
                    </h2>
                    <div id="flush-collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
                      <div class="accordion-body">
                          <ul class="list-group">
                              <li class="list-group-item" style="text-align: center;"><a href="">음식점 등록</a></li>
                              <li class="list-group-item" style="text-align: center;"><a href="">음식점 리스트</a></li>
                              <li class="list-group-item" style="text-align: center;"><a href="">등록 요청 리스트</a></li>
                              <li class="list-group-item" style="text-align: center;"><a href="">수정 요청 리스트</a></li>
                          </ul>
                      </div>
                    </div>
                </div>
              </div>
        </div>
        
        <!-- -------------헤더------------- -->
        <div class="header">
            
            <div id="header_1">
                <h2 style="margin: auto; font-weight: bold;">관리자 페이지</h2>
            </div>
            <div id="header_2">
                <img src="resources/img/user.png" style="width: 45px; margin-top: 18px;"">
                <div>관리자님</div>
                <a href="">로그아웃</a>
            </div>
        </div>

        <!-- -------------컨텐츠 헤더------------- -->
        <div class="content">
            <div id="content_1">
                <h4 style="font-weight: bold;" align="center">기본 정보</h4>
            </div>
            <div id="content_2" align="center">
                <table>
                    <tr style="height: 50px;">
                        <td style="width: 300px;">
                            <strong style="vertical-align: middle;">사이트 이름</strong>
                        </td>
                        <td style="width: 1000px;">
                            <div id="siteName" style="background-color: rgb(230, 230, 230);">이눔세끼 - 가성비 좋은 음식을 찾고있는 당신을 위해</div>
                        </td>
                    </tr>
                    <tr style="height: 50px;">
                        <td>
                            <strong style="vertical-align: middle;">최고 관리자</strong>
                        <td>
                            <div id="name" style="background-color: rgb(230, 230, 230);">관리자요</div>
                        </td>
                    </tr>
                    <tr style="height: 50px;">
                        <td>
                            <strong style="vertical-align: middle;" >관리자 메일주소</strong>
                        </td>
                        <td>
                            <div id="email" style="background-color: rgb(230, 230, 230);">이메일이요</div>
                        </td>
                    </tr>
                </table> 
            </div>
        </div>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
    	crossorigin="anonymous"></script>
</body>
</html>