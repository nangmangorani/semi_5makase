<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Document</title>
</head>
<style>
    #myPageWrap{
        width: 1000px;
        height: 800px;
        border: 1px solid red;
        
    }
    #myPageHead{
        width: 100%;
        height: 18%;
        border: 1px solid white;
    }
    #myPageHead>img{
        width: 200px;
        height: 100%;
        margin: auto;
        display: block;
    }
    #myPageContent{
        width: 70%;
        margin : auto;
        margin-top: 15px;
        border: 1px solid white;
        height: 67%;
    }
    table{
        width: 100%;
        
    }
    th{ 
        width: 30%;
        background-color: lightgray;
        height:60px;
    }
    tr>td{
        width: 100%;
        background-color: aliceblue;
        
        
    }
    #myPageContent2>div{
        /* border: 1px solid red; */
        float: left;
        width: 20%;
        margin-left:20px;
    }
    #myPageFoot{
        width: 100%;
        background-color: gray;;
        height: 13%;
    }


    @font-face {
    font-family: 'Ansungtangmyun-Bold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_11-01@1.0/Ansungtangmyun-Bold.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
    }


    * {

        font-family: 'Ansungtangmyun-Bold';
    }
</style>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<%
		String memId = loginMember.getMemId(); 
		String nickname = loginMember.getNickname();
		String selfIntroduction = loginMember.getSelfIntroduction();
		String email = loginMember.getEmail();
		String phone = loginMember.getPhone();
		String address = loginMember.getAddress();
		
	%>
	
	
    <div id="myPageWrap" >
        <div id="myPageHead">
            <img src="./resources/logo.PNG.png">
         
        </div>
		<form id="myPage-form" action="<%= contextPath%>/update.me" method="post" >
			<input type="hidden" name="memId" value="<%=memId %>" >
        <div id="myPageContent" style="margin-left: 200px;" >
            <table >
                <tr>
                    <th>프로필사진</th>
                    <td><input type="file" name="profile" id=""></td>
                </tr>       
                <tr>
                    <th>닉네임</th>
                    <td><input type="text" name="nickname" value="<%=nickname %>" id="nickname1"><br>
                        <label for="nickname1">이눔세끼에서 이용하실 닉네임을 입력해주세요.</label>
                    </td>
                    
                </tr>       
                <tr>
                    <th>자기소개</th>
                    <td><input type="text" value="<%=selfIntroduction %>" name="selfIntroduction" id=""></td>
                </tr>       
                <tr>
                    <th>이메일</th>
                    <td><input type="text" value="<%=email %>" name="email" id=""></td>
                </tr>                
                <tr>
                    <th>전화번호</th>
                    <td><input type="text" value="<%=phone %>" name="phone" id=""></td>
                </tr>       
                <tr>
                    <th>주소</th>
                    <td><input type="text" value="<%=address %>" name="address" id=""></td>
                </tr>       
            </table>
            <div id="myPageContent2">
                <div align ="center"><button type="submit" class="btn btn-sm">정보변경</button></div>
                <div align ="center"><button type="button" class="btn btn-sm" data-toggle="modal" data-target="#updatePwd">비밀번호 변경</button></div>
                <div align ="center"><button type="button" class="btn btn-sm" onclick="deletePage()">회원탈퇴</button></div>
                <div align ="center"><a href="">내가 쓴 리뷰 조회하기</a></div>
            </div>
            
        </div>
        </form>
         <script >
            function deletePage(){
            	
            	location.href = "<%=contextPath%>/deleteform.me";
            }
        </script>
        
        <div id="myPageFoot">
            
        </div>
    </div>
    
    <!-- 비번변경 -->
  	<div class="modal" id="updatePwd">
	  <div class="modal-dialog">
	    <div class="modal-content">
	
	      <div class="modal-header">
	        <h4 class="modal-title">비밀번호 변경</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	
	      <div class="modal-body" align="center">
	        <form action="<%=contextPath %>/updatePwd.me" method="post">
	        	<input type="hidden" name="memId" value="<%=memId %>">
	        
                      <table>
                          <tr>
                              <td style="background-color: white;">현재비밀번호</td>
                              <td><input type="password" name="memPwd" required></td>
                          </tr>
                          <tr>
                              <td style="background-color: white;">변경할 비밀번호</td>
                              <td><input type="password" name="updatePwd" required></td>
                          </tr>
                          <tr>
                              <td style="background-color: white;">변경할 비밀번호 확인</td>
                              <td><input type="password" name="checkPwd" required></td>
                          </tr>

                      </table>

                      <br>

                      <button type="submit" class="btn btn-sm btn-secondary" onclick="return validatePwd();">비밀번호 변경</button>

                      <br><br>
                  </form>
	      	</div>


                <script>
                  function validatePwd(){
                      if($("input[name=updatePwd]").val() != $("input[name=checkPwd]").val()){
                          alert("변경할 비밀번호가 일치하지 않습니다!");
                          return false;
                      }
                  }
                </script>
	    </div>
	  </div>
	</div>
	
	

    
    
    
</body>
</html>