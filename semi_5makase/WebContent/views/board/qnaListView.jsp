<%@page import="com.semi_5makase.common.model.vo.PageInfo"%>
<%@page import="com.semi_5makase.member.model.vo.Member"%>
<%@page import="com.semi_5makase.board.model.vo.Qna"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<Qna> list = (ArrayList<Qna>)request.getAttribute("list");
   PageInfo pi = (PageInfo)request.getAttribute("pi");
   
   int currentPage = pi.getCurrentPage();
   int startPage = pi.getStartPage();
   int endPage = pi.getEndPage();
   int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QNA</title>
	<link rel="icon" href="resources/img/favicon.ico" type="image/x-icon" sizes="16x16">
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
            height: 850px;
            margin: auto;
        }   
        .wrap>div{
            width: 100%;
        }

        #header{
            height: 35%
        }
        #header_1{
        	text-align : center;
            height: 75%;
        }
        #navi{
            height: 25%;
        }

        #content{
            height: 60%;
        }
        #footer{
            height: 5%;
        }

        #footer_1{
            margin-left: 800px;
        }
        .btnToNotice, .btnToFaq{
            width: 300px;
            height: 70px;
            font-size: 20px;
            background-color: transparent;
            border: 1px solid lightgray;
            
        }

        .btnToNotice:hover, .btnToFaq:hover{
            background-color: rgb(243, 241, 241);
        }

        .btnToFaq{
            margin-left: 50px;
        }

        .btnToNotice{
            margin-right: 50px;
        }

        #emrollBtn{
            border: transparent;
            border-radius: 5px;
            width: 100px;
            height: 40px;
            background-color: rgb(21, 98, 189);
            font-weight: 500;
            color: white;
        }

        .qna:hover{
            background-color: rgb(243, 241, 241);
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

        #lock{
            width: 17px;
            height: 17px;
            margin-bottom: 3px;
            margin-left: 3px;
        }

        #emrollBtn{
            float: right;
            margin-right: 90px;
        }


    </style>
</head>
<body>
<%@ include file="../common/menubar.jsp"%>
    <div class="wrap" >
        <div id="header">
            <div id="header_1">
                <img src="https://static.vecteezy.com/system/resources/previews/006/584/735/original/illustration-graphic-cartoon-character-of-qna-free-vector.jpg" width="30%" height="100%">
            </div>
            <br><br>
            <div id="navi" align="center">
                <button class="btnToNotice btn btn-outline-secondary" onclick="location.href='<%=contextPath%>/list.no?cpage=1'">공지사항</button>
                <button class="btnToFaq btn btn-outline-secondary" onclick="location.href='<%=contextPath%>/list.faq'">자주묻는 질문</button>
            </div>
        </div>
        <br><br><br>
        <div id="content">
            <div class="container">
                <table class="table" align="center" style="width: 85%;">
                  <thead>
                    <tr>
                        <th class="tableth">번호</th>
                        <th class="tableth">제목</th>
                        <th class="tableth">작성자</th>
                        <th class="tableth">작성일</th>
                        <th class="tableth">처리상태</th>
                        <th class="tableth">공개여부</th>
                    </tr>
                  </thead>
                  <tbody>
                  	<!-- case1. qna가 없을 경우 -->
                    <% if(list.isEmpty()) { %>
                    <tr>
                        <td colspan="6" align="center">존재하는 질문이 없습니다.</td>
                    </tr>
                    <% } else {%>
                    <!-- case2. qna가 있을 경우 -->
                    	<% int qnaListNo = 1; %>
	                    <% for(Qna q : list) { %>
	                    	<tr class="qna">
	                    		<td style="height: 55px; line-height: 40px;"><%= qnaListNo++ %></td>
	                    		<td style="display:none"><%= q.getQnaNo() %></td>
		                        <% if(q.getOpen().equals("공개")) { %>
		                        <td class="tabletd"><%= q.getBoardTitle() %></td>
	                        <% }else{  %>
	                        	<td class="tabletd">비공개 질문입니다.
                                    <img src="./resources/img/자물쇠.png" id="lock" alt="">
                                </td>
	                        <% } %>
		                        <td class="tabletd"><%= q.getBoardWriter() %></td>
		                        <td class="tabletd"><%= q.getCreateDate() %></td>
		                        <td class="tabletd"><%= q.getReply() %></td>
		                        <td class="tabletd"><%= q.getOpen()%></td>
	                    	</tr>
	                    <% } %>
                 	<% } %>
                  </tbody>
                </table>
			</div>
            <button type="submit" id="emrollBtn" onclick="enroll()">등록하기</button>
        </div>
        <div class="pageing-area" align="center">
            <ul class="pagination pagination-sm" style="margin-left: 450px;">
                <% if(currentPage != 1){ %>
                <li class="page-item"><a class="page-link" href="<%=contextPath%>/list.qna?cpage=<%=currentPage - 1%>">&lt;</a></li>
            <% } else {%>
                <li class="page-item disabled"><a class="page-link" href="<%=contextPath%>/list.qna?cpage=<%=currentPage - 1%>">&lt;</a></li>
            <% } %>
            <% for(int p = startPage; p<=endPage; p++) { %>
                <% if(p == currentPage) { %>
                    <li class="page-item disabled"><a class="page-link"><%= p %></a></li>
                <% } else {%>
                <li class="page-item"><a class="page-link" href="<%=contextPath%>/list.qna?cpage=<%= p %>"><%= p %></a></li>
                <% } %>
            <% } %>
            <% if(currentPage != maxPage) { %>
                <li class="page-item"><a class="page-link" href="<%=contextPath%>/list.qna?cpage=<%=currentPage + 1%>">&gt;</a></li>
            <% } else {%>    
                <li class="page-item disabled"><a class="page-link" href="<%=contextPath%>/list.qna?cpage=<%=currentPage + 1%>">&gt;</a></li>
            <% } %>
            </ul>
       </div>
            <script>
				$(function() {
                    $(document).on("click", ".qna", function() {
                        <% if (loginMember != null) { %>
                            const memberId = '<%= loginMember.getMemId() %>';
                            const isOpen = $(this).children().eq(6).text();
                            console.log(isOpen);
                            const boardWriter = $(this).children().eq(3).text();
                            if (isOpen === '공개' || memberId === boardWriter || memberId === 'admin') {
                                const num = $(this).children().eq(1).text();
                                location.href = '<%= contextPath %>/detail.qna?num=' + num;
                            } else {
                                alert("비공개 질문은 작성자만 열람할 수 있습니다.");
                            }
                        <% } else { %>
                            alert("로그인 후 이용바랍니다.");
                        <% } %>
					    });
					});
					</script>
            <script>
            function enroll() {
                <% if (loginMember != null) { %>
                    // 사용자가 로그인되어 있는 경우, 등록 진행
                    location.href = '<%=contextPath%>/insertview.qna';
                <% } else { %>
                    // 사용자가 로그인되어 있지 않은 경우, 알림 메시지 표시
                    alert("로그인 후 이용바랍니다.");
                <% } %>
            }
            </script>
            
    </div>
</body>
</html>