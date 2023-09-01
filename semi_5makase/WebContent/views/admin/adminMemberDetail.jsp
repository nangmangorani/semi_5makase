<%@page import="com.semi_5makase.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member m = (Member)request.getAttribute("m");
%>    

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
                                    <li class="list-group-item" style="text-align: center;"><a href="<%= contextPath %>/memberList.ad">회원 관리</a></li>
                                    
                                    
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
                            <li class="list-group-item" style="text-align: center;"><a href="">Q&A 문의 관리</a></li>
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
                              <!-- ==================== 음식점 리스트 페이지로 이동 ==================== -->
                              <li class="list-group-item" style="text-align: center;"><a href="<%= contextPath %>/rtList.ad?cpage=1">음식점 리스트</a></li>
                              
                              <li class="list-group-item" style="text-align: center;"><a href="<%= contextPath %>/rtRequestList.ad">등록 요청 리스트</a></li>
                              
                              <li class="list-group-item" style="text-align: center;"><a href="<%= contextPath %>/rtChangeList.ad">수정 요청 리스트</a></li>
                          </ul>
                      </div>
                    </div>
                </div>
              </div>
        </div>

        <!-- -------------컨텐츠 헤더------------- -->
        <div class="content">
            <div id="content_1">
                <h4 style="font-weight: bold;" align="center">회원 정보 상세</h4>
            </div>
            <div id="content_2" style="margin-top: 30px;"> 
                <div align="center">
                    <img src="../../resources/img/rdetail_user.png" style="width: 45px;">
                    <table class="table" style="width: 350px;">
                            <tr>
                                <th scope="col">회원명</th>
                                <td><%= m.getMemName() %></td>
                            </tr>
                            <tr>
                                <th scope="col">아이디</th>
                                <td><%= m.getMemId() %></td>
                            </tr>
                            <tr>
                                <th scope="col">비밀번호</th>
                                <td><input type="password" value="<%= m.getMemPwd() %>" disabled></td>
                            </tr>
                            <tr>
                                <th scope="col">주소</th>
                                <td><%= m.getAddress() %></td>
                            </tr>
                            <tr>
                                <th scope="col">전화번호</th>
                                <td><%= m.getPhone() %></td>
                            </tr>
                            <tr>
                                <th scope="col">이메일</th>
                                <td><%= m.getEmail() %></td>
                            </tr>
                            <tr>
                                <th scope="col">회원등급</th>
                                <td><%= m.getMemGrade() %></td>
                            </tr>
                            <tr>
                                <th scope="col">회원상태</th>
                                <td><%= m.getStatus() %></td>
                            </tr>
                            
                    </table> 
                </div>
                <div align="right" style="padding-right: 30px;">
                    <a href="<%= contextPath %>/memberDelete.ad?num=<%= m.getMemNo() %>" class="btn btn-sm btn-danger">회원삭제</a>
                    <a href="<%= contextPath %>/memberUpdateForm.ad?num=<%= m.getMemNo() %>" class="btn btn-sm btn-primary">회원수정</a>
                    <button class="btn btn-sm btn-secondary" onclick="history.go(-1);">뒤로가기</button>
                </div>
            </div>
            
        </div>
    </div>
</body>
</html>