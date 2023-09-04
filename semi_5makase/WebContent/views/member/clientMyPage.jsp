<%@page import="com.oreilly.servlet.multipart.FilePart"%>
<%@page import="com.semi_5makase.member.model.vo.Attachment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Attachment pf = (Attachment)request.getAttribute("pf");
%>   


<!DOCTYPE html>
<html lang="en">
<head>
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	

</head>
<style>
    #myPageWrap{
        width: 1000px;
        height: 800px;

        margin: auto;
        
    }
    #myPageHead{
        width: 100%;
        
        /* border: 1px solid red; */
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
        margin-top: 30px;
        /* border: 1px solid red; */
        height: 75%;
    }
    table{
        width: 100%;
        border-top: 1px solid  rgb(228, 227, 227);
        border-bottom: 1px solid  rgb(228, 227, 227);
        
    }
    th{ 
        width: 30%;
        background-color: rgb(228, 227, 227);
        height:60px;
        text-align: center;
        border-bottom: 1px solid rgb(228, 227, 227);
        
    }
    tr>td{
        width: 100%;
        /* background-color: aliceblue; */
        border-bottom: 1px solid rgb(228, 227, 227);
        
    }
    #myPageContent2>div{
        /* border: 1px solid red; */
        float: left;
        width: 20%;
        margin-left:20px;
    }
    #myPageFoot{
        width: 100%;
        /* background-color: gray; */
        height: 15%;
    }

    .soft-border {
        border: 1px solid #ccc; 
        border-radius: 5px;
        padding: 5px; 
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
		int memNo = loginMember.getMemNo();

	%>
	

	

    <div id="myPageWrap">
        <div id="myPageHead" >
        </div>
		<form id="myPage-form" action="<%= contextPath%>/update.me" method="post"  enctype="multipart/form-data" >
			<input type="hidden" name="memId" value="<%= memId %>">
			<input type="hidden" name="memNo" value="<%= memNo %>">
			
			
			
        <div id="myPageContent" style="margin-left: 100px;"  >
            <table style=" width: 800px; height: 500px;" >
                <tr>
                    <th>프로필사진</th>
                    <td>
                        <div id="imagePreview" >
                            <img id="preview"  src="" alt="Preview" style="width: 100px; height: 100px; border-radius: 50%;">
                            <input type="file" id="profileImage" name="upfile" accept=".jpg, .jpeg, .png, .gif" onchange="previewImage()">
                        </div>
                    </td>
                </tr>       
    
                <tr>
                    <th>닉네임</th>
                    <td><input type="text" name="nickname" value="<%=nickname %>" id="nickname1"  class="soft-border"><br>
                        <label for="nickname1">이눔세끼에서 이용하실 닉네임을 입력해주세요.</label>
                    </td>
                    
                </tr>       
                <tr>
                    <th>자기소개</th>
                    <td><input type="text" value="<%=selfIntroduction %>"  class="soft-border" name="selfIntroduction"  class="soft-border" id=""></td>
                </tr>       
                <tr>
                    <th>이메일</th>
                    <td><input type="text" value="<%=email %>"  class="soft-border" name="email" id=""></td>
                </tr>                
                <tr>
                    <th>전화번호</th>
                    <td><input type="text" value="<%=phone %>"  class="soft-border" name="phone" id=""></td>
                </tr>       
                <tr>
                    <th>주소</th>
                    <td><input type="text" value="<%=address %>"  class="soft-border" class="soft-border" name="address" id=""></td>
                </tr>       
            </table>
            <div id="myPageContent2">
                <div align ="center"><button type="submit" class="btn btn-sm btn-success">정보변경</button></div>
                <div align ="center"><button type="button" class="btn btn-sm btn-success" data-toggle="modal" data-target="#updatePwd">비밀번호 변경</button></div>
                <div align ="center"><button type="button" class="btn btn-sm btn-success" onclick="deletePage()">회원탈퇴</button></div>
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

                  // Function to preview the selected image
                    function previewImage() {
                        const input = document.getElementById("profileImage");
                        const preview = document.getElementById("preview");

                        if (input.files && input.files[0]) {
                            const reader = new FileReader();

                            reader.onload = function (e) {
                                preview.src = e.target.result;
                            };

                            reader.readAsDataURL(input.files[0]);
                        } else {
                            preview.src = "";
                        }
                    }



                </script>
	    </div>
	  </div>
	</div>
	
	

    
    
    
</body>
</html>