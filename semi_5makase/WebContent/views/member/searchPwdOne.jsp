<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%    
	String contextPath = request.getContextPath(); 
	String alertMsg = (String)session.getAttribute("alertMsg");
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
        
        
        .selectMethod-area{
            height: 7%;
            width: 100%;
        }
        
        .selectMethod-area a{
            width: 100%;
            height: 100%;
            display: block;
            text-decoration: none;
            color: black;
            font-size: 20px;
            text-align: center;
            line-height: 56px;
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

        #findByPwd{margin-top: 50px;}

        .searchByPhone{
            position: relative;
        }

        #X{
            position: absolute;
            top: 70%;
            right: 20px;
            border: none;
            border-radius: 100px;
            cursor: pointer;
        }

    </style>
</head>
<body>

    <div class="wrap-area">
        <div class="intro-area" align="center"> 비밀번호 찾기 </div> <br><br>
        <div class="selectMethod-area">
            <div class="selectId"><a href="<%=contextPath%>/searchId.me">아이디 찾기</a></div>
            <div class="selectPwd"><a href="location:reload()">비밀번호 찾기</a></div>
        </div>
        <form action="<%=contextPath %>/searchPwdTwo.me" method="get" class="searchBy-area">
                <div class="searchByPhone"> <br><br>
                    <h5>비밀번호를 찾으려는 아이디</h5>
                        <input type="text" name="memId" id="inputId" class="form-control form-control-lg" placeholder="아이디 입력">
                        <span id="X" onclick="clean();"><b>X</b></span>
                </div>
                <button type="submit" id="findByPwd" class="btn btn-primary btn-lg btn-block" disabled>다음</button>
        </form>
    </div>
    <script>

            $("#inputId").keyup(function(){
                $("#findByPwd").attr("disabled", !$("#inputId").val());
            })


            // $("#inputId").keyup(function(){
            //     switch(!($("#inputId").val())){
            //         case false : $("#findByPwd").attr("disabled", false); break;
            //         case true : $("#findByPwd").attr("disabled", true); break;
            //     }
            // })
            
            function clean(){
                $("#inputId").val('').focus();
                $("#findByPwd").attr("disabled", true)
            }


    </script>
</body>
</html>