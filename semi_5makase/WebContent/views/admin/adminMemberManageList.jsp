<%@page import="com.semi_5makase.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
%>    

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
        .table tr{
            text-align: center;
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
        .btn-toolbar{
            box-sizing: border-box;
        }
        .btn-group{
            margin-left: 30%;
            margin-right: 30%;
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
                                    <li class="list-group-item" style="text-align: center;"><a href="">회원 관리</a></li>
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
                <h4 style="font-weight: bold;" align="center">회원 관리</h4>
            </div>
            <div id="content_2"> 
                <div align="right" style="margin: 5px;">
                    <button type="button" class="btn btn-sm btn-secondary">회원등록</button>
                </div>
                <div>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">No</th>
                                <th scope="col">회원명</th>
                                <th scope="col">전화번호</th>
                                <th scope="col">지역</th>
                                <th scope="col">성별</th>
                                <th scope="col">회원등급</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<!-- case1. 공지글이 없을 경우 -->
			                <% if(list.isEmpty()) { %>
				                <tr>
				                    <td colspan="5">존재하는 회원이 없습니다.</td>
				                </tr>
							<% } else { %>
					            <!-- case2. 공지글이 있을 경우 -->
	                        	<% for(Member m : list) { %>
		                            <tr>
		                                <th scope="row"><%= m.getMemNo() %></th>
		                                <td><%= m.getMemName() %></td>
		                                <td><%= m.getPhone() %></td>
		                                <td><%= m.getAddress() %></td>
		                                <td><%= m.getGender() %></td>
		                            </tr>
                            	<% } %>
                            <% } %>
                    </table> 
                </div>
                <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                    <div class="btn-group me-2  btn-sm" role="group" aria-label="First group">
                      <button type="button" class="btn btn-primary"><</button>
                      <button type="button" class="btn btn-primary">1</button>
                      <button type="button" class="btn btn-primary">2</button>
                      <button type="button" class="btn btn-primary">3</button>
                      <button type="button" class="btn btn-primary">4</button>
                      <button type="button" class="btn btn-primary">5</button>
                      <button type="button" class="btn btn-primary">></button>
                </div>
            </div>
        </div>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
    	crossorigin="anonymous"></script>
</body>
</html>