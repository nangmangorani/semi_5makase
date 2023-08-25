<%@page import="com.semi_5makase.notice.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
	String contextPath = request.getContextPath();
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
        #header{
            height: 20%;
        }
        #header_1{
            height: 65%;
            font-size: 30px;
        }
        #navi{
            height: 35%;
        }
        #content_1{
            height: 70%;
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
            margin-left: 750px;
            margin-top: 20px;

        }
        #searchbtn{
            margin-bottom: 5px;
        }

    </style>
</head>
<body>
    <div class="wrap"> 
        <div id="header">
            <div id="header_1" align="center" ><br>
                <b>이눔세끼 공지사항</b>
            </div>
            


            <div id="search">
                <input type="text">
                <button type="submit" id="searchbtn" class="btn btn-sm btn-success">검색</button>

            </div>

            
        </div>
        <div id="content_1">
            <table class="table" align="center" style="width: 85%;">
                <thead>
                  <tr>
                      <th>번호</th>
                      <th>제목</th>
                      <th>작성자</th>
                  </tr>
                </thead>
                <tbody>
                	<!-- case1. 공지글이 없을 경우 -->
                	<% if(list.isEmpty()) {%>
                	<tr>
                      <td colspan="3">존재하는 공지사항이 없습니다.</td>
                  </tr>
                	<% } else { %>
                		<!-- case2. 글지글이 있을 경우 -->
                		<% for(Notice n : list) { %>
               			<tr>
		                     <td><%= n.getNoticeNo() %></td>
		                     <td><%= n.getNoticeTitle() %></td>
		                     <td><%= n.getCreateDate() %></td>
		                 </tr>
                		<% } %>
           			<% } %>
                </tbody>
              </table>
              
              <script>
		    	$(function() {
		    		$(".table>tbody>tr").click(function(){
						const num = $(this).children().eq(0).text();
						// console.log(num);
						
						// 요청할 url?키=벨류&키=벨류
						// 요청시 전달값 (키=벨류) => 쿼리스트링!!
						
						// /jsp/detail.no?num=클릭한글번호
						location.href = '<%= contextPath %>/detail.no?num=' + num;
		    		}) 
		    	})
    
			</script>
              
              

              <div class="pageing-area" align="center">

                <ul class="pagination pagination-sm" style="margin-left: 460px;">
                    <li class="page-item"><a class="page-link" href="#">&lt;</a></li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">&gt;</a></li>
                </ul>
            </div>
        </div>
        <div id="footer"></div>
    </div>
</body>
