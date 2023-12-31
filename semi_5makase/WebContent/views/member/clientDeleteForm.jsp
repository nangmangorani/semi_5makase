<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원탈퇴</title>
	<link rel="icon" href="resources/img/favicon.ico" type="image/x-icon" sizes="16x16">
    <!-- Add these lines to include Bootstrap CSS and JavaScript -->

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


    


</head>
<style>
    	@font-face {
        font-family: 'SUITE-Regular';
        src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/SUITE-Regular.woff2') format('woff2');
        font-weight: 400;
        font-style: normal;
        }


    .delbtn{
        padding: 0.25rem 0.5rem;
        font-size: 25px;
        line-height: 1.5;
        border-radius: 0.5rem;
        color: #fff;
        background-color: #6c757d;
        border: none;
        width: 100px;
        height: 40px;
        
    }

    #deleteWrap{
        width: 1000px;
        height: 1000px;
        border: 1px solid white;
        margin: auto;
    }
    #deleteHead{
        width: 100%;
    }
    #deleteHead>img{
        width: 100px;
        height: 80px;
        margin: auto;
        display: block;
    }
    #deleteHead2{
        width: 100%;
        height: 120px;
        background-image: url(resources/img/parting.jpg);
        /* background-color: lightgray; */
        background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),url(resources/img/parting.jpg);
        background-size: cover;
        background-position: 20% 19%;
        color: white;

    }
    #deleteHead2>h2{
        
        text-align: center;
        line-height: 120px;
    }
    #deleteBody{
        width: 100%;
        height: 64%;
        border: 1px solid white;
    }
    #deleteBody2{
        width: 100%;
    }
    form{
        margin-left: 30px;
    }
    #p1{
        font-size: 13px;
        color: orangered;
        font-weight: bold;
    }
    #text1{
        color: red;
    }
    
    

    
</style>


<body>
	<%@ include file="../common/menubar.jsp" %>
	<%
		String memId = loginMember.getMemId(); 
		String memPwd = loginMember.getMemPwd(); 
	%>
    <div id="deleteWrap">
        <div id="deleteHead">

            <hr>
            <div id="deleteHead2">
                <h2>회원 탈퇴</h2>
            </div>
        </div>

        <div id="deleteBody">
            <form action="<%=contextPath%>/memDeleteController.me">
            <input type="hidden" name="memId" value="<%=memId %>">
            <input type="hidden" name="memPwd" value="<%=memPwd %>">
            
                <h3>회원 탈퇴</h3>
                <h5>회원 탈퇴를 원하시는 이유를 모두 골라주세요</h5>

                <input type="checkbox" name="reason" id="text1" value="더 이상 이용하지 않을것 같아서" onclick='checkOnlyOne(this)' > 
                <label for="text1">더 이상 이용하지 않을것 같아서</label><br><br>
                
                <input type="checkbox" name="reason" id="text2" value="개인정보 보안이 걱정되어서" onclick='checkOnlyOne(this)'> 
                <label for="text2">개인정보 보안이 걱정되어서</label><br><br>
                
                <input type="checkbox" name="reason" id="text3" value="사이트 방문을 잘 하지 않아요" onclick='checkOnlyOne(this)'> 
                <label for="text3">사이트 방문을 잘 하지 않아요</label><br><br>
                
                <input type="checkbox" name="reason" id="text4" value="이용혜택이 부족해요" onclick='checkOnlyOne(this)'> 
                <label for="text4">이용혜택이 부족해요</label><br><br>
                
   				<input type="checkbox" name="reason"  id="text5" value="on" onclick='toggleTextbox(this); "copyText(this)";  checkOnlyOne(this);' >
		        <label for="text5">기타 </label>
		       
				
				
				
                <h5>이눔세끼에서 개선되면 좋을점이나 불편하셨던 점을 말씀해주세요!</h5>
                <p id="p1">적극 반영하여 개선하도록 노력하겠습니다. <br>
                언제든 다시 찾아와 주세요!!</p>
                <textarea name="textareaData" id="my_text" cols="80" rows="4" placeholder="10자 이상 부탁드립니다 :)" disabled  style="resize: none;"></textarea>
            <div id="deleteBody2" align="center">
                <h4>회원 탈퇴 전 아래 유의사항을 꼭 확인해주세요.</h4>
                <b id="text1">회원탈퇴 후 1개월간 재가입이 불가능하며,</b> 이후 재가입시 신규가입으로 처리되며<br>
                작성한 리뷰,즐겨찾기 등 모든 정보가 초기화 됩니다. <br><br>
                
				


				<script>
				 function copyText() {
			            var textareaValue = document.getElementById("my_text").value;
			            document.getElementById("text5").value = textareaValue;
			        }

                    console.log(text5);
				</script>

                
                
                <button type="button" id="delbtn"  class="btn btn-sm" data-toggle="modal" data-target="#deleteModal">회원탈퇴</button>
            </div>
            
            
		       <!-- 탈퇴 -->
			   <div class="modal" id="deleteModal">
		       <div class="modal-dialog">
		       <div class="modal-content">
		   
		           <!-- Modal Header -->
		           <div class="modal-header">
		           <h4 class="modal-title">회원탈퇴</h4>
		           <button type="button" id="delbtn" class="close" data-dismiss="modal">&times;</button>
		           </div>
		   
		           <!-- Modal body -->
		           <div class="modal-body" align="center">
		           <input type="hidden" name="memId" value="<%=memId %>"> <!-- 아이디 숨겨서가져가기 -->
		           
		               <b>탈퇴 후 복구가 불가능 합니다. <br>정말로 탈퇴하시겠습니까?</b> <br><br>
		
		               비밀번호 : <input type="password" name="memPwd" required> <br><br>
		               <button type="submit" id="delbtn" class="btn btn-sm ">탈퇴하기</button>
		
		
		
		      		 </div>
		       </div>
		       </div>
		       </div>
            
            
            
            
            
            </form>
        </div>
        <script>
        function toggleTextbox(checkbox) {
        	  
        	  // 1. 텍스트 박스 element 찾기
        	  const textbox_elem = document.getElementById('my_text');
        	  
        	  // 2-1. 체크박스 선택여부 체크
        	  // 2-2. 체크박스 선택여부에 따라 텍스트박스 활성화/비활성화
        	  textbox_elem.disabled = checkbox.checked ? false : true;
        	  
        	  // 3. 텍스트박스 활성화/비활성화 여부에 따라
        	  // - 텍스트박스가 비활성화 된 경우 : 텍스트박스 초기화
        	  // - 텍스트박스가 활성화 된 경우 : 포커스 이동
        	  if(textbox_elem.disabled) {
        	    textbox_elem.value = null;
        	  }else {
        	    textbox_elem.focus();
        	  }
        	}
        
        function checkOnlyOne(element) {
        	  
            const checkboxes = document.getElementsByName("reason");
            
            checkboxes.forEach((cb) => {
                cb.checked = false;
            })
            
            element.checked = true;
            }
        </script>

        
        
        <div id="deleteFoot" align="center">
        </div>
    </div>
    
    

    
    <%@ include file="../common/footer.jsp" %>
    
    
    
</body>
</html>