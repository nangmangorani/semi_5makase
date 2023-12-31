<%@page import="com.semi_5makase.board.model.vo.Faq"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	ArrayList<Faq> list = (ArrayList<Faq>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>자주묻는질문</title>
	<link rel="icon" href="resources/img/favicon.ico" type="image/x-icon" sizes="16x16">	
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <style>
        @font-face {
            font-family: 'SUITE-Regular';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/SUITE-Regular.woff2') format('woff2');
            font-weight: 400;
            font-style: normal;
        }
        div{
            /*border: 1px solid red;*/
            box-sizing: border-box;
            font-family: 'SUITE-Regular';
        }
        
        .wrap {
            width: 1000px;
            height: 1200px;
            margin: auto;
            min-height: 100%;
            position: relative;
        }

        #header{
            height: 7%;
        }

        .wrap>div{
            width: 100%;
        }

        #logo, #login{
            width: 20%;
        }

        #search{
            width: 60%;
        }

        #logo>img{
            width: 80px;
            height: 77px;
        }

        #searchTab{
            width: 500px;
            border-radius: 20px;
            margin-top: 25px;
            margin-left: 20px;
        }

        #header>div{
            height: 100%;
            float: left;
        }
        
        #content{
            height: 78%;
            width: 100%;
        }

        #picture{
            height: 20%;
            width: 100%;
            border-bottom: 1px solid black;
        }
        
        #faqMain{
            /*width: 70%;
            height: 80%;
            margin: auto;
            */
            width: 70%;
		    min-width: 800px; /* Set a minimum width to prevent narrowing */
		    height: auto; /* Let the height adjust based on content */
		    margin: auto;
		    overflow-y: auto;

            /* border-top: 2px solid black;/ */
        }

        #footer{
            height: 15%;
        }
        

        #picture>img{
            width: 100%;
            height: 100%;
            position: relative;
        }
        
        .main_image_text {
            position: absolute;
            top: 8%;
            left: 50%;
            transform: translate( -50%, -50% );
            color: white;
        }
        

        #footer_1{
            margin-top: 10px;
        }

        #footer *{
            margin-left: 20px;
        }

        #footer_1>a{
            text-decoration: none;
            color: black;
            font-weight: 600;
        }

        #footer_2{
            margin-top: 20px;
        }

        #footer_3{
            margin-top: 10px;
        }

        #footer_4{
            margin-top: 10px;
        }

        #searchBtn{
            border: transparent;
            border-radius: 5px;
            float: right;
            width: 100px;
            height: 40px;
            background-color: rgb(21, 98, 189);
            font-weight: 500;
            color: white;
        }

        #searchFaq{
            width: 200px;
            height: 40px;
            border-radius: 5px;
            border: 1px solid black;
        }


        .CFaqTableItem__list {
            display: flex;
            box-sizing: border-box;
            height: 70px;
            cursor: pointer;
            align-items: center
        }

        .CFaqTableItem__category{
            width: 160px;
            font-size: 15px;
            font-weight: 500;
            text-align: center
        }

        .CFaqTableItem__question {
            padding: 0 10px;
            font-size: 15px;
            flex: 1;
            margin-top: 15px;
        }


        .CFaqTableItem {
            width: 100%;
            border-bottom: 1px solid #b9b9b994;
        }

        .CFaqTableItem__contents {
            padding: 24px 10px;
            font-size: 15px;
            color: #363535
        }

        .CFaqTableItem__contents-box {
            display: flex;
            overflow: hidden;
            height: 0;
            background-color: #f5f5f5
        }

        .CFaqTableItem--active .CFaqTableItem__contents-box {
            height: auto;
        }

        .CFaqTableItem__contents img {
            max-width: 100%
        }

        .CFaqTableItem__answer {
            display: flex;
            width: 160px;
            font-size: 14px;
            color: #6e6e6e;
            align-items: center;
            justify-content: center;
        }

        #searchTab2 {
            margin-top: 11px;
            float: right;
        }
        
        #searchTab2>input {
            margin-left: 10px; 
            height: 40px;
            border-radius: 10px;
            border: 1px solid gray;
        }

        #searchBtn{
            margin-left: 5px;
            background-color: rgb(21, 98, 189);
            color: white;
            width: 80px;
        }
        
        .arrow{
            width: 18px;
            margin-right: 10px;
        }

        .hidden {
            display: none;
        }

        #enrollBtn{
            border: transparent;
            border-radius: 5px;
            margin-top: 11px;
            float: left;
            width: 100px;
            height: 40px;
            background-color: rgb(21, 98, 189);
            font-weight: 500;
            color: white;
        }
        
        #deleteBtn{
        	margin-top: 11px;
        	border: transparent;
            border-radius: 5px;
            width: 100px;
            height: 40px;
            background-color: rgb(206, 1, 1);
            font-weight: 500;
            color: white;
            margin-left:10px;
        }
        
    </style>
</head>


<body>
	<%@ include file = "../common/menubar.jsp" %>
    <div class="wrap">
                <div id="content">
            <div id="picture">
                <img src="resources/img/faq4.png" alt="">
                <h2 class="main_image_text" style="font-size:40px">자주 묻는 질문</h2>
            </div>
            
                <% int listNum = 1; %>       
	            <% for(Faq f : list) {%>
	            <div id="faqMain">
	                <div class="CFaqTableItem">
	                    <div class="CFaqTableItem__list">
	                    <% if(loginMember != null && loginMember.getMemId().equals("admin")) {  %>
		                    <form action="<%=contextPath%>/delete.faq" id="deleteAction">
	                            <input type="checkbox" name="deleteFaq" id="deleteChkBox" value="<%= f.getFaqNo() %>">
	                            <input type="hidden" name="faqNo" value="<%= f.getFaqNo() %>">
	                        </form>
                        <% } %>
	                        <em class="CFaqTableItem__category"><%= listNum++ %></em>
	                        <p class="CFaqTableItem__question"><%= f.getFaqTitle() %></p>
	                        <img class="arrow down" src="resources/img/아래쪽.png" alt="">
	                        <img class="arrow up hidden" src="resources/img/up.png">
	                    </div>
	                    <div class="CFaqTableItem__contents-box">
	                        <em class="CFaqTableItem__answer">답변</em>
	                        <div class="CFaqTableItem__contents">
	                            <% String s = f.getFaqContent().replaceAll("\\\\n", "<br>");%>
	                            <% out.println(s); %>
	                        </div>
	                    </div>
	                </div>


	                <% } %>
	                	<% if(loginMember != null && loginMember.getMemId().equals("admin")) {  %>
		                	<button id="enrollBtn" onclick="location.href='<%=contextPath%>/insertview.faq'">작성하기</button>
		                	<button id="deleteBtn" onclick="submitForm()">삭제하기</button>
		                	
	                <% } %>

                    <script>
	                    function submitForm() {
	                    	
	                    	var checkedCheckboxes = document.querySelectorAll("input[name='deleteFaq']:checked");
	                        var faqNos = [];

	                        checkedCheckboxes.forEach(function(checkbox) {
	                            var faqNo = $(checkbox).closest(".CFaqTableItem__list").find("input[name='faqNo']").val();
	                            faqNos.push(faqNo);
	                            console.log(faqNo);
	                            console.log(faqNos);
	                            console.log('여긴 submitform');
	                        });

	                        // Check if at least one checkbox is selected.
	                        if (faqNos.length > 0) {
	                            // Serialize the array and set it as a hidden input field value.
	                            var faqNosString = faqNos.join(",");
	                            var form = document.getElementById("deleteAction");
	                            var input = document.createElement("input");
	                            input.type = "hidden";
	                            input.name = "faqNos"; // This should match the parameter name in your controller
	                            input.value = faqNosString;
	                            form.appendChild(input);
	                            console.log(faqNos);
	                            console.log('여긴 form')
	                            

	                            // Submit the form.
	                            form.submit();
	                        } else {
	                            alert("삭제할 게시글을 한 개 이상 선택해주세요.");
	                        }
	                    }
                    </script>
                <div id="searchTab2">
				    <form id="searchForm" action="<%=contextPath%>/list.faq" method="get">
				        <input type="text" id="searchFaq" name="searchFaq">
				        <input type="submit" value="검색" id="searchBtn">
				    </form>
				</div>
            </div>
            
        </div>
        
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        <div id="footer">
            <div id="footer_1">
                <a href=""> 데이터 제휴 문의 </a>
                <a href=""> 개인정보처리방침 </a>
                <a href=""> 이용약관 </a>
                <a href=""> 위치기반 서비스 이용약관 </a>
            </div>
            <div id="footer_2">
                <b>(주)이눔세끼</b>
                <span>소재지 : 서울특별시 강남구 역삼동</span>
            </div>
            <div id="footer_3">
                <span>이메일 문의: 2num@inum.com</span>
            </div>
            <div id="footer_4">
                <span>전화 문의 : 02-457-1304 (평일 : 10:00 ~ 19:00, 주말/공휴일 제외)</span>
                <span style="margin-left: 160px;">Copyright Ⓒ 2023 inummsekki</span>
            </div>
        </div>
    

    <script>

    window.onload = function() {
        $(".CFaqTableItem").on("click", function(event) {
            var clickedItem = $(event.currentTarget);

            if (!$(event.target).is("input[type='checkbox']")) {
                // Clicking outside of the checkbox area
                if (clickedItem.hasClass("CFaqTableItem--active")) {
                    clickedItem.removeClass("CFaqTableItem--active");

                    // Reset the arrow images
                    clickedItem.find(".arrow.down").removeClass("hidden");
                    clickedItem.find(".arrow.up").addClass("hidden");

                    // Reset the margin-top of the footer
                    $("#footer").css("margin-top", "0");
                } else {
                    $(".CFaqTableItem--active").each(function(index, item) {
                        item.classList.remove("CFaqTableItem--active");

                        // Reset the arrow images
                        $(item).find(".arrow.down").removeClass("hidden");
                        $(item).find(".arrow.up").addClass("hidden");
                    });

                    clickedItem.addClass("CFaqTableItem--active");

                    // Change the arrow images
                    clickedItem.find(".arrow.down").addClass("hidden");
                    clickedItem.find(".arrow.up").removeClass("hidden");

                    // Calculate and set the margin-top of the footer
                    var contentsBoxHeight = clickedItem.find(".CFaqTableItem__contents-box").height();
                    $("#footer").css("margin-top", contentsBoxHeight + "px");
                }
            }
        });
    };
        



    </script>
</body>
</html>