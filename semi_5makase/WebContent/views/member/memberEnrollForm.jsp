<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
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
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	
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
            height: 15%;
        }
        #content{
            height: 85%;
        }
        #header>div{
            height: 100%;
            float: left;
        }
        #header_1{
            width: 40%;
            text-align: right;
        }
        #login td{
            text-align: left;
            height: 60px;
        }

        .input{
            width: 310px;
        }

        #next{
            width: 400px;
        }
		.home{
    		cursor:pointer;
    	}
    
    </style>
</head>

<body>
    <div class="wrap">
        <div id="header">
            <div id="header_1"><img src="resources/img/logo.png" style="width: 35%; height: 100%;" class="home"></div>
        </div>
        <div id="content">
            <form id="enroll-form" action="<%=contextPath %>/insert.me" align="center" method="post">
                <table border="0" align="center" id="login">
                    <tr>
                        <td><b>아이디 : </b></td>
                        <td><input type="text" class="input" name="memId" placeholder="아이디" required ></td>
                        <td><button type="button" onclick="idCheck();">중복확인</button></td>
                    </tr>
                    <tr>
                        <td><b>비밀번호 : </b></td>
                        <td><input type="password" class="input" name="memPwd" placeholder="비밀번호" required></td>
                    </tr>
                    <tr>
                        <td><b>비밀번호확인 : </b></td>
                        <td><input type="password" class="input" placeholder="비밀번호확인" required></td>
                    </tr>
                    <tr>
                        <td><b>이름 : </b></td>
                        <td><input type="text" class="input" name="memName" placeholder="이름" required ></td>
                    </tr>
                    <tr>
                        <td><b>성별 : </b> </td>
                        <td>
                        <input type="checkbox" style="width: 15px; height: 15px;" name="gender" id="gender1" value="남" class="text1" onclick='checkOnlyOne(this)'>
                        <label for="gender1"><b>남자</b></label>
                        <input type="checkbox" style="width: 15px; height: 15px;" name="gender" id="gender2" value="여" class="text1" onclick='checkOnlyOne(this)'>
                        <label for="gender2"><b>여자</b></label><br>
                        </td>
                    </tr>
                    <tr>
                        <td><b>나이 : </b> </td>
                        <td>
                        <input type="checkbox" style="width: 15px; height: 15px;" name="age" id="age1" value="10" class="text1" onclick='checkOnlyOne2(this)'>
                        <label for="age1"><b>10대</b></label>
                        <input type="checkbox" style="width: 15px; height: 15px;" name="age" id="age2" value="20" class="text1" onclick='checkOnlyOne2(this)'>
                        <label for="age2"><b>20대</b></label>
                        <input type="checkbox" style="width: 15px; height: 15px;" name="age" id="age3" value="30" class="text1" onclick='checkOnlyOne2(this)'>
                        <label for="age3"><b>30대</b></label>
                        <input type="checkbox" style="width: 15px; height: 15px;" name="age" id="age4" value="40" class="text1" onclick='checkOnlyOne2(this)'>
                        <label for="age4"><b>40대</b></label><br>
                        </td>
                        
                    </tr>
                    
                    <tr>
                        <td><b> 닉네임 : </b></td>
                        <td><input type="text" class="input" name="nickname" placeholder="닉네임" required></td>
                    </tr>

                    <tr>
                        <td><b> 주소 : </b></td>
                        <td><input type="text" class="input" name="address" placeholder="주소" required></td>
                    </tr>

                    <tr>
                        <td>
                            <b>휴대전화 : </b><br><br>
                        </td>
                        <td>
                            <div class="check1"  style="margin-bottom: 20px;">
                                <input type="text" id="phone" name="phone" placeholder="휴대전화">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>이메일 : </b><br><br>
                        </td>
                        <td>
                            <div class="email" style="margin-bottom: 20px;">
                                <input type="text" id="email" name="email"  placeholder="이메일을 입력하세요"><br>

                            </div>
                        </td>
                    </tr>
                </table>
                <button type="submit" id="next" class="btn btn-info" disabled >가입하기</button>

            </form>

        </div>
            
        <div id="footer"></div>
    </div>
    
    <script>
    $(".home").click(function(){
		location.href="<%= contextPath %>"
	})
    
    function idCheck(){
        const $idInput = $("#enroll-form input[name=memId]");

        $.ajax({
            url:"idCheck.me",
            data:{checkId:$idInput.val()},
            success:function(result){
                if(result == 'NNNNN'){// 사용불가능일 경우
                	alert("이미 존재하거나 탈퇴한 회원의 아이디입니다.");
                	$idInput.fucus();
                }else{ // 사용가능일 경우
                	if(confirm("사용가능한 아이디입니다. 사용하시겠습니까?")){
                		$("#enroll-form :submit").removeAttr("disabled");
                		$idInput.attr("readonly",true);
                	}else{
                		$idInput.focus();
                	}
                }

            },
            error:function(){
                console.log("아이디 중복체크용 ajax 통신실패!");
            }
        })
    }
    </script>
    
    
    <script>



        function checkOnlyOne(element) {
  
        const checkboxes = document.getElementsByName("gender");
        
        checkboxes.forEach((cb) => {
            cb.checked = false;
        })
        
        element.checked = true;
        }



        function checkOnlyOne2(element) {
  
        const checkboxes2 = document.getElementsByName("age");
        
        checkboxes2.forEach((cb) => {
            cb.checked = false;
        })
        
        element.checked = true;
        }


</script>

</body>
</html>