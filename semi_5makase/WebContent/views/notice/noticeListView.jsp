<%@page import="com.semi_5makase.common.model.vo.PageInfo"%>
<%@page import="com.semi_5makase.notice.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	String searchNo = request.getParameter("searchNo");
	if(searchNo == null) {searchNo = "";}
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
        div{
            /* border: 1px solid red; */
            box-sizing: border-box;
        }
        .wrap{
            width: 1080px;
            height: 800px;
            margin: auto;
        }   
        .wrap>div{
            width: 100%;
        }

        #content{
            height: 80%;
        }

        #content_no{
            height: 25%;
            font-size: 30px;
        }
        
        #navi{
            height: 35%;
        }
        #content_1{
            height: 70%;
        }
        #footer{
            height: 10%;
        }

        #all>a{
            text-decoration-line: none;
            color: black;
            font-size: 20px;
            margin-top: 25px;
            margin-left: 75px;
            float: left;
        }

        #search{
            text-align: right;
        }
        .searchbtn{
            height: 40px;
            border: transparent;
            border-radius: 5px;
            width: 80px;
            height: 40px;
            background-color: rgb(55, 173, 44);
            font-weight: 500;
            color: white;
            margin:10px 80px 10px 0px;
        }

        #noticeSearch{
            height: 40px;
            border-radius: 5px;
            border: 1px solid black;
        }
        
        .enrollBtn {
            border: transparent;
            border-radius: 5px;
            width: 100px;
            height: 40px;
            background-color: rgb(21, 98, 189);
            font-weight: 500;
            color: white;
        }

        .tableLine:hover{
            background-color: rgb(243, 241, 241);
        }
        .tableLine{
            cursor: pointer;
        }

        .tableth{
            height: 55px;
            line-height: 35px;
        }
        .tabletd{
            height: 55px;
            line-height: 40px;
        }

        



    </style>
</head>
<body>
	<%@ include file = "../common/menubar.jsp" %>
    <div class="wrap"> 
        <div id="content">
            <div id="content_no" align="center" ><br>
                <b>이눔세끼 공지사항</b>
            </div>
            <form action="<%= contextPath %>/list.no">
                <div id="search">
                    <!-- 검색어 입력 필드 -->
                    <input type="text" id="noticeSearch" name="searchNo" value="<%= searchNo %>">
                    <!-- 현재 페이지 정보 유지 -->
                    <input type="hidden" name="cpage" value="1">
                    <button type="submit" id="searchbtn" class="searchbtn">검색</button>
                </div>
            </form>
            <div id="content_1">
                <table class="table" align="center" style="width: 85%;">
                    <thead>
                      <tr class="tabletr">
                          <th class="tableth">번호</th>
                          <th class="tableth">제목</th>
                          <th class="tableth">작성일</th>
                      </tr>
                    </thead>
                    <tbody>
                        <!-- case1. 공지글이 없을 경우 -->
                        <% if(list.isEmpty()) {%>
                        <tr class="tabletr">
                          <td colspan="3" class="tabletd">존재하는 공지사항이 없습니다.</td>
                        </tr>
                        <% } else { %>
                            <!-- case2. 글지글이 있을 경우 -->
                            <% int listNum = 1; %>
                            <% for(Notice n : list) { %>
                               <tr class="tableLine">
                                 <td style="display:none" class="tabletd"><%= n.getNoticeNo() %></td>
                                 <td class="tabletd"><%= listNum++ %></td>
                                 <td class="tabletd"><%= n.getNoticeTitle() %></td>
                                 <td class="tabletd"><%= n.getCreateDate() %></td>
                             </tr>
                            <% } %>
                           <% } %>
                    </tbody>
                  </table>
                  <% if(loginMember != null && loginMember.getMemId().equals("admin")) {  %>
                      <button class="enrollBtn" style="margin-left: 900px;" onclick="location.href='<%=contextPath%>/insertView.no'">등록하기</button>
                  <% } %>
            </div>
            <div class="pageing-area" align="center">
                <ul class="pagination pagination-sm" style="margin-left: 460px;">
                 <% if(currentPage != 1) { %>
		            <li class="page-item"><a class="page-link" href="<%= contextPath %>/list.no?cpage=<%= currentPage - 1 %>&searchNo=<%= searchNo %>"><</a></li>
		        <% } else { %>
		            <li class="page-item disabled"><a class="page-link"><</a></li>
		        <% } %>
		        
		        <% for(int p = startPage; p <= endPage; p++) { %>
		        	<% if(p == currentPage) { %>
		        		<li class="page-item disabled"><a class="page-link"><%= p %></a></li>
		        	<% } else {%>
		            <li class="page-item">
		                <a class="page-link" href="<%= contextPath %>/list.no?cpage=<%= p %>&searchNo=<%= searchNo %>"><%= p %></a>
		            </li>
		        	<% } %>
		        <% } %>
		        
		        <% if(currentPage != maxPage) { %>
		            <li class="page-item"><a class="page-link" href="<%= contextPath %>/list.no?cpage=<%= currentPage + 1 %>&searchNo=<%= searchNo %>">></a></li>
		        <% } else { %>
		            <li class="page-item disabled"><a class="page-link">></a></li>
		        <% } %>
                </ul>
            </div>
        </div>
    </div>

    <script>
        $(function() {
            $(".table>tbody>tr").click(function(){
                const num = $(this).children().eq(0).text();
                location.href = '<%= contextPath %>/detail.no?num='+num;
            }) 
        })
        </script>
</body>

