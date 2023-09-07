<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String alertMsg = (String)session.getAttribute("alertMsg");
	String authenticationKey = (String) session.getAttribute("AuthenticationKey");
	String contextPath = request.getContextPath(); 
	
%>    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
    
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
            border: 1px solid rgb(204, 194, 194);
        }
        .selectPwd{
            width: 300px;
            height: 50px;
            background-color: rgb(211, 203, 203);
        }

        .selectPwd>a{color: gray;}

        .intro-area{height: 13%;}

        .searchBy-area{height: 80%;}

        #findById{margin-top: 50px;}

        .name{position: relative;}
        .email{position: relative;}

        #X1{
            position: absolute;
            top: 70%;
            right: 20px;
            border: none;
            border-radius: 100px;
            cursor: pointer;
        }

        #X2{
            position: absolute;
            top: 10%;
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

   	<% if(alertMsg != null){ %>

	<script>
		alert("<%= alertMsg %>");
	</script>
	<% session.removeAttribute("alertMsg"); %>
	<% } %>
		
		
    <div class="wrap-area">
        <div class="intro-area" align="center"> 아이디 찾기 </div> <br><br>
        <div class="selectMethod-area">
            <div class="selectId"><a href="location:reload()">아이디 찾기</a></div>
            <div class="selectPwd"><a href="<%=contextPath%>/searchPwdOne.me">비밀번호 찾기</a></div>
        </div>
        <form action="<%=contextPath%>/numCheck.me" method="post" class="searchBy-area">
                <div class="searchByEmail"> <br><br>
                    <span style="width: 15px; height: 15px;" class="radio-value" name="select" value="email">&nbsp;<b style="font-size: 20px;">이메일 인증</b></span><br><br>
                    <div style="font-size: small;">회원정보에 등록한 휴대전화 번호와 입력한 휴대전화 번호가 같아야, 인증번호를 받을 수 있습니다.</div><br>
                    <div class="email" > 
                    
                        <input type="text" name="email" id="email" class="form-control form-control-lg" placeholder="이메일">
                        <span id="X2" onclick="cleanEmail();"><b>X</b></span>
                        
              		    <button type="button" id="" class="btn btn-sm" onclick="emailCheck()" style="margin-left: 430px;">인증번호 받기</button>
                        <br>
                        
                        <input type="text" name="checkNumber" id="checkNumber" class="form-control form-control-lg" placeholder="인증번호">
                        <span id="X1" onclick="cleanName();"><b>X</b></span>
                    </div>
                    <br><br>
                </div>
 				
				
                <button type="submit" id="findById"  class="btn btn-primary btn-lg btn-block"  onclick="checkNum();" >아이디 찾기</button>
        </form>

        
    </div>
    
    <script>
			
        function emailCheck(){
            $.ajax({
                url:"emailCheck.me",
                data:{
                	email:$("#email").val()
                },
                type:"post"
            })
        }  
        

			




            function cleanName(){
                $("#checkNumber").val('').focus();
                $("#findById").attr("disabled", true)
            }

            function cleanEmail(){
                $("#email").val('').focus();
                $("#findById").attr("disabled", true)
            }

    </script>
</body>
</html>