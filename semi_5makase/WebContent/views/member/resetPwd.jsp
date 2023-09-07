<%@page import="com.semi_5makase.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Member m = (Member)request.getAttribute("m");
	String contextPath = request.getContextPath(); 
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 재설정</title>
	<link rel="icon" href="resources/img/favicon.ico" type="image/x-icon" sizes="16x16">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <style>
        /* .wrap-area>*{border: 1px solid red;} */
        .wrap-area{
            /* border: 1px solid red; */
            width: 600px;
            height: 600px;
            padding: 30px;
            margin: auto;
        }

        .intro-area{
            font-size: xx-large;
            line-height: 100px;
        }

        .selectMethod-area a:hover{
            color: rgb(5, 243, 243);
        }
        
        .selectId, .selectPwd{
            display: table-cell;
            /* background-color: rgb(192, 186, 186); */
        }

        .selectId{
            width: 50%;
            background-color: rgb(211, 203, 203);
        }
        .selectPwd{
            width: 300px;
            height: 50px;
            border: 1px solid rgb(204, 194, 194);
        }

        .selectId>a{color: gray;}

        .intro-area{height: 13%;}

        .searchBy-area{height: 80%;}

        #resetPwd{margin-top: 50px;}

        #inputNewPwd-area{position: relative;}

        #X1{
            position: absolute;
            top: 25%;
            right: 20px;
            border: none;
            border-radius: 100px;
            cursor: pointer;
        }

        #X2{
            position: absolute;
            top: 75%;
            right: 20px;
            border: none;
            border-radius: 100px;
            cursor: pointer;
        }
        
        @font-face {
            font-family: 'SUITE-Regular';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/SUITE-Regular.woff2') format('woff2');
            font-weight: 400;
            font-style: normal;
        }
        
        * {
        	font-family : 'SUITE-Regular';
        }

    </style>
</head>
<body>
    <div class="wrap-area">
        <div class="intro-area" align="center"> 비밀번호 재설정 </div> <br><br>
        <form action="<%=contextPath %>/checkEmailResetPwd.me" method="post" class="searchBy-area">
        	 <input type="hidden" name="memId" id="memId" value="<%=m.getMemId()%>">
        	 <input type="hidden" name="memPwd" id="memPwd" value="<%=m.getMemPwd()%>">
                <div class="searchByPhone"> <br><br>
                    <h5>새로운 비밀번호를 입력해주세요.</h5> <br>
                    <div id="inputNewPwd-area">아이디 : <b><%=m.getMemId() %></b>
                        <input type="password" name="newPwd" id="newPwd" class="form-control form-control-lg" placeholder="새 비밀번호">
                        <span id="X1" onclick="cleanPwd();"><b>X</b></span>
                        <br>
                        <input type="password" name="checkPwd" id="checkPwd" class="form-control form-control-lg" placeholder="새 비밀번호 확인">
                        <span id="X2" onclick="cleanPwd2();"><b>X</b></span>
                    </div> <br>
                </div>
                <button type="submit" id="resetPwd" class="btn btn-primary btn-lg btn-block" onclick="checkNum();" disabled>비밀번호 재설정하기</button>
        </form>
    </div>
  
    
    
    
    <script>
    	
		
			function checkNum() {
			 var inputValueOne = $("#newPwd").val();
			 var inputValueTwo = $("#checkPwd").val();
			$("#checkNumber").keyup(checkNum);
			
			 if (inputValueOne == inputValueTwo) {
			     $("#resetPwd").prop("disabled", false);
			 } else {
			     $("#resetPwd").prop("disabled", true);
			 }
			}
			  $("#newPwd").keyup(checkNum);
			  $("#checkPwd").keyup(checkNum);
			
			

            function cleanPwd(){
                $("#newPwd").val('').focus();
                $("#resetPwd").attr("disabled", true)
            }

            function cleanPwd2(){
                $("#checkPwd").val('').focus();
                $("#resetPwd").attr("disabled", true)
            }


            
    </script>
</body>
</html>