<%@page import="com.semi_5makase.restaurant.model.vo.Menu"%>
<%@page import="com.semi_5makase.common.model.vo.PageInfo"%>
<%@page import="com.semi_5makase.common.model.vo.Attachment"%>
<%@page import="com.semi_5makase.restaurant.model.vo.AdminRestaurant"%>
<%@page import="com.semi_5makase.restaurant.model.vo.TV"%>
<%@page import="com.semi_5makase.restaurant.model.vo.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	AdminRestaurant ar = (AdminRestaurant)request.getAttribute("ar");
	ArrayList<Menu> list = (ArrayList<Menu>)request.getAttribute("list");
	ArrayList<Attachment> alist = (ArrayList<Attachment>)request.getAttribute("alist");
%>    

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>음식점 상세</title>
	<link rel="icon" href="resources/img/favicon.ico" type="image/x-icon" sizes="16x16">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
    	crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
    	crossorigin="anonymous"></script>
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
            width: 1000px; height: 850px; margin: auto;
        }
        .outline>div{
            /* border: 1px solid red; */
            box-sizing: border-box;
            float: left;
        }

        .header{
            height: 15%;
            width: 100%;
            background-color: rgb(230, 230, 230);
        }
        .menu{
            height: 85%;
            width: 20%;
            background-color: rgb(230, 230, 230);
        }
        .content{
            height: 85%;
            width: 80%;
        }

        /* -------------헤더------------- */
        .header>div{
            box-sizing: border-box;
            float: left;
            height: 100%;
        }

        #header_1{
            width: 100%;
            margin: auto;
            display: flex;
        }


        /* -------------메뉴------------- */
        #menu>div{
            width: 100%;
        }
        #service{
            height: 80%;
        }

        /* -------------컨텐츠------------- */
        .content>div{
            width: 100%;
        }
        #content_1{
            height: 50px;
            padding: 15px;
            border-bottom: 1px solid rgb(230, 230, 230);
        }
        .btn-toolbar{
            box-sizing: border-box;
        }
        .btn-group{
            margin-left: 35%;
            margin-right: 35%;
        }

        .restImg{
        width: 100px;
        height: 100px;
        cursor: pointer;
        background-image: url("../../resources//img/plus.png");
        background-repeat: no-repeat;
        background-position: center;
        background-size: 50%;
        }

        .imgBtn{
            display: none;
        }
        
        
    </style>
</head>
<body>

	<%@ include file ="../common/menubar.jsp" %>

    <div class="outline">
        
        <!-- -------------헤더------------- -->
        <div class="header">
            
            <div id="header_1">
                <h2 style="margin: auto; font-weight: bold;">관리자 페이지</h2>
            </div>
            
        </div>

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
                                    <li class="list-group-item" style="text-align: center;"><a href="<%= contextPath %>/memberList.ad?cpage=1">회원 관리</a></li>
                                    
                                    <li class="list-group-item" style="text-align: center;"><a href="<%= contextPath %>/reportList.ad?cpage=1">신고 현황 관리</a></li>
                                    
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
                            <li class="list-group-item" style="text-align: center;"><a href="<%= contextPath %>/list.qna?cpage=1">Q&A 문의 관리</a></li>
                            <li class="list-group-item" style="text-align: center;"><a href="<%= contextPath %>/list.no?cpage=1">공지사항 관리</a></li>
                            <li class="list-group-item" style="text-align: center;"><a href="<%= contextPath %>/list.faq">자주 묻는 질문 관리</a></li>
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
                              <!-- ==================== 음식점 리스트 페이지로 이동 ==================== -->
                              <li class="list-group-item" style="text-align: center;"><a href="<%= contextPath %>/rtList.ad?cpage=1">음식점 리스트</a></li>
                              
                              <li class="list-group-item" style="text-align: center;"><a href="<%= contextPath %>/rtRequestList.ad?cpage=1">등록 요청 리스트</a></li>
                              
                              <li class="list-group-item" style="text-align: center;"><a href="<%= contextPath %>/rtChangeList.ad?cpage=1">수정 요청 리스트</a></li>
                          </ul>
                      </div>
                    </div>
                </div>
              </div>
        </div>

        <!-- -------------컨텐츠 헤더------------- -->
        <div class="content">
            
                <div id="content_1">
                    <h4 style="font-weight: bold;" align="center">음식점 상세</h4>
                </div>
                
                <div id="content_2" style="margin-top: 30px;">  
             
                    <div align="center">   
                        <table>
                            <tr>
                                <td>사진</td>
                                <td colspan="3">
                                    <% for(int i=0; i<alist.size(); i++) { %>
                        				<img class="restImg" src="<%= contextPath %>/<%= alist.get(i).getFilePath() %>/<%= alist.get(i).getChangeName() %>" width="200" height="150">
                        			<% } %>
                                </td>
                            </tr>
                
                            <tr>
                                <td style="width:150px;">음식점명</td>
                                <td><%= ar.getRestName() %></td>
                            </tr>

                            <tr>
                                <td>주소</td>
                                <td><%= ar.getRestAddress() %></td>
                            </tr>
                            
                            <tr>
                                <td>전화번호</td>
                                <td><%= ar.getRestPhone() %></td>
                            </tr>
                
                            <tr>
                                <td>주차가능여부</td>
                                <td><%= ar.getParking() %></td>
                            </tr>

                            <tr>
                                <td>카테고리</td>
                                <td id="categoryTd"><%= ar.getCategory() %></td>
                            </tr>
                                                        
                            <tr>
                                <td>TV맛집</td>
                                <td><%= ar.getTv() %></td>
                            </tr>
							
                            <tr>
                                <td>메뉴/가격</td>
                                <td id="menuTd">
	                                <% for(Menu m : list) { %>
	                                	<%= m.getMenuGrade() %>번 메뉴 : <%= m.getMenu() %> / <%= m.getPrice() %>원<br>
	                                <% } %>
                                </td>
                            </tr>
                            
                            
                            <tr>
                                <td>영업시간</td>
                                <td><%= ar.getOpeningTime() %></td>
                            </tr>
                            
                            <% if(ar.getRestTime() != null) { %>
	                            <tr>
	                                <td>휴무일</td>
	                                <td><%= ar.getRestTime() %></td>
	                            </tr>
	                        <% } %>
                            
                            <% if(ar.getBreakTime() != null) { %>
	                            <tr>
	                                <td>브레이크타임</td>
	                                <td><%= ar.getBreakTime() %></td>
	                            </tr>
	                        <% } %>    
	                        
                            <tr>
                                <td>식당소개</td>
                                <td colspan="2">
                                	<textarea name="intro" style="resize: none; width: 320px;" readonly ><%= ar.getIntro() %></textarea>
                                </td>
                            </tr>

                            <tr>
                                <td>공개여부(Y/N)</td>
                                <td><%= ar.getStatus() %></td>
                            </tr>
                        </table>
                        <script>
                            function chooseFile(num){
                                $("#file"+num).click()
                            }
                            
                            function loadImg(inputFile, num){
                                
                                if(inputFile.files.length == 1){
                                    
                                    const reader = new FileReader();

                                    reader.readAsDataURL(inputFile.files[0]);
                                    
                                    reader.onload = function(e){
                                        switch(num){
                                        case 1: $("#rtImg1").attr("src", e.target.result); break;
                                        case 2: $("#rtImg2").attr("src", e.target.result); break;
                                        case 3: $("#rtImg3").attr("src", e.target.result); break;
                                        }
                                    }
                                } else {
                                    switch(num){
                                    case 1: $("#rtImg1").attr("src", null); break;
                                    case 2: $("#rtImg2").attr("src", null); break;
                                    case 3: $("#rtImg3").attr("src", null); break;
                                    }
                                }
                            }

                        </script>
                    </div>
                </div>
            
                <div align="right" style="padding-right: 50px">
                    <a type="button" class="btn btn-sm btn-secondary" href="<%= contextPath %>/rtList.ad?cpage=1">뒤로가기</a>
                    <a type="submit" class="btn btn-sm btn-primary" href="<%= contextPath %>/rtUpdateForm.ad?num=<%= ar.getRestNo() %>">수정하기</a>
                </div>
        </div> 
    </div>
    <%@ include file ="../common/footer.jsp" %>
</body>
</html>