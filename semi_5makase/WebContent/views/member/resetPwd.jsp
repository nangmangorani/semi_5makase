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

    </style>
</head>
<body>
    <div class="wrap-area">
        <div class="intro-area" align="center"> 비밀번호 재설정 </div> <br><br>
        <form action="" method="post" class="searchBy-area">
        	<!-- 	<input type="hidden" name="memPwd" value="">  -->
                <div class="searchByPhone"> <br><br>
                    <h5>새로운 비밀번호를 입력해주세요.</h5> <br>
                    <div id="inputNewPwd-area">아이디 : <b>아이디값 받아오기</b>
                        <input type="text" id="newPwd" class="form-control form-control-lg" placeholder="새 비밀번호">
                        <span id="X1" onclick="cleanPwd();"><b>X</b></span>
                        <br>
                        <input type="text" id="checkPwd" class="form-control form-control-lg" placeholder="새 비밀번호 확인">
                        <span id="X2" onclick="cleanPwd2();"><b>X</b></span>
                    </div> <br>
                </div>
                <button type="submit" id="resetPwd" class="btn btn-primary btn-lg btn-block" disabled>비밀번호 재설정하기</button>
        </form>
    </div>
    <script>
            $("#newPwd, #checkPwd").keyup(function(){
                switch(!($("#newPwd").val() && $("#checkPwd").val())){
                    case false : $("#resetPwd").attr("disabled", false); break;
                    case true : $("#resetPwd").attr("disabled", true); break;
                }
            })

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