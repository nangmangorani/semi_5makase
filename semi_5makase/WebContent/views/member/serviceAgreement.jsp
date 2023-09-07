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
        #header_2{
            width: 60%;
            
        }
        .text1{
            margin-left: 35%;
        }
        .textarea{
            resize: none; 
            margin-top: 10px;
            margin-left: 37%;
            border-radius: 5px;
            
        }
        #next{
            width: 260px; 
            height: 40px; 
            margin-left: 42%; 
            margin-top: 10px;
        }
        @font-face {
            font-family: 'SUITE-Regular';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/SUITE-Regular.woff2') format('woff2');
            font-weight: 400;
            font-style: normal;
        }
        
        * {
        	font-family: 'SUITE-Regular';
        }


    </style>

</head>
<body>
    <div class="wrap" >
        <div id="header">
            <div id="header_1"><img src="resources/img/logo.png" style="width: 35%; height: 100%;"></div>
        </div>
        <div id="content" >
            <form action="" id="form_wrap">
                <div>
                    <br>
                    <div class="check_all">
                        <input type="checkbox" style="width: 15px; height: 15px;" id="allAgree"  class="text1">
                        <label for="allAgree"><b>전체 동의하기</b></label> <br>
                        <span style="margin-left: 37%; ">실명 인증된 아이디로 가입, 위치기반서비스 이용약관(선택),</span>
                        <span style="margin-left: 37%; "> 이벤트・혜택 정보 수신(선택) 동의를 포함합니다.</span><br><br>
                    </div>

                    <div class="input_check">
                        <input type="checkbox" style="width: 15px; height: 15px;" id="useAgree" class="text1">
                        <label for="useAgree"><b>[필수]이눔세끼 이용약관></b></label><br>
                        <textarea name="content" cols="50" rows="5" class="textarea" readonly>
여러분을 환영합니다.
네이버 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 네이버 주식회사(이하 ‘네이버’)와 이를 이용하는 네이버 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
                            
네이버 서비스를 이용하시거나 네이버 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 잠시 시간을 내시어 주의 깊게 살펴봐 주시기 바랍니다.
                            
다양한 네이버 서비스를 즐겨보세요.
네이버는 www.naver.com을 비롯한 네이버 도메인의 웹사이트 및 응용프로그램(어플리케이션, 앱)을 통해 정보 검색, 다른 이용자와의 커뮤니케이션, 콘텐츠 제공, 상품 쇼핑 등 여러분의 생활에 편리함을 더할 수 있는 다양한 서비스를 제공하고 있습니다.
여러분은 PC, 휴대폰 등 인터넷 이용이 가능한 각종 단말기를 통해 각양각색의 네이버 서비스를 자유롭게 이용하실 수 있으며, 개별 서비스들의 구체적인 내용은 각 서비스 상의 안내, 공지사항, 네이버 웹고객센터(이하 ‘고객센터’) 도움말 등에서 쉽게 확인하실 수 있습니다                        
                        </textarea><br><br>
                    </div>

                   
                    <div class="input_check">
                        <input type="checkbox" style="width: 15px; height: 15px;" id="userinformation" class="text1">
                        <label for="userinformation"><b>[필수] 개인정보 수집 및 이용></b></label><br>
                        <textarea name="content" cols="50" rows="5" class="textarea"  readonly>
개인정보보호법에 따라 네이버에 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부 시 불이익에 관한 사항을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.

1. 수집하는 개인정보
이용자는 회원가입을 하지 않아도 정보 검색, 뉴스 보기 등 대부분의 네이버 서비스를 회원과 동일하게 이용할 수 있습니다. 이용자가 메일, 캘린더, 카페, 블로그 등과 같이 개인화 혹은 회원제 서비스를 이용하기 위해 회원가입을 할 경우, 네이버는 서비스 이용을 위해 필요한 최소한의 개인정보를 수집합니다.
                            
회원가입 시점에 네이버가 이용자로부터 수집하는 개인정보는 아래와 같습니다.
- 회원 가입 시 필수항목으로 아이디, 비밀번호, 이름, 생년월일, 성별, 휴대전화번호를, 선택항목으로 본인확인 이메일주소를 수집합니다. 실명 인증된 아이디로 가입 시, 암호화된 동일인 식별정보(CI), 중복가입 확인정보(DI), 내외국인 정보를 함께 수집합니다. 만14세 미만 아동의 경우, 법정대리인 정보(법정대리인의 이름, 생년월일, 성별, 중복가입확인정보(DI), 휴대전화번호)를 추가로 수집합니다.
- 비밀번호 없이 회원 가입 시에는 필수항목으로 아이디, 이름, 생년월일, 휴대전화번호를, 선택항목으로 비밀번호를 수집합니다.
- 단체 회원가입 시 필수 항목으로 단체아이디, 비밀번호, 단체이름, 이메일주소, 휴대전화번호를, 선택항목으로 단체 대표자명을 수집합니다.


                        </textarea><br><br>
                    </div>

                    <div class="input_check">
                        <input type="checkbox" style="width: 15px; height: 15px;" id="eventAgree" class="text1">
                        <label for="eventAgree"><b>[선택] 이벤트, 혜택 정보 수신></b></label><br>
                        <textarea name="content" cols="50" rows="5" class="textarea" readonly>
                            네이버 서비스 및 제휴 이벤트・혜택 등의 정보를 휴대전화(네이버앱 알림 또는 문자), 이메일로 받을 수 있습니다. 일부 서비스(별개의 회원 체계 운영, 네이버 가입 후 추가 가입하는 서비스 등)의 경우, 수신에 대해 별도로 안내드리며 동의를 구합니다.                           
                        </textarea>
                    </div>
            </div>
                    
            <button type="submit" id="next" class="btn btn-success" onclick="enrollPage()"  disabled>다음</button>
            
	            <script>
					function enrollPage(){
	            	
	
	            	location.href = "<%=contextPath%>/enrollForm.me";
	            }
					
					
	            </script>
            </form>
        </div>
        <div id="footer"></div>

            <script>
                const form = document.querySelector('#form_wrap'); // 데이터를 전송하는 Form 
                const checkAll = document.querySelector('.check_all input'); // 모두 동의 체크박스
                const checkBoxes = document.querySelectorAll('.input_check input'); // 모두 동의를 제외한 3개의 체크박스
                const submitButton = document.querySelector('button'); // 확인 버튼

                const agreements = {
                    useAgree: false, // 첫번째 필수동의 체크박스
                    userinformation: false, // 두번째 필수동의 체크박스
                    eventAgree: false, // 이벤트 수신 동의 체크박스
                };

                form.addEventListener('submit', (e) => e.preventDefault()); // 새로고침(submit) 되는 것 막음

                checkBoxes.forEach((item) => item.addEventListener('input', toggleCheckbox));

                function toggleCheckbox(e) {
                const { checked, id } = e.target;  
                agreements[id] = checked;
                this.parentNode.classList.toggle('active');
                checkAllStatus();
                toggleSubmitButton();
                }

                function checkAllStatus() {
                const { useAgree, userinformation, eventAgree } = agreements;
                if (useAgree && userinformation && eventAgree) {
                    checkAll.checked = true;
                } else {
                    checkAll.checked = false;
                }
                }

                function toggleSubmitButton() {
                const { useAgree, userinformation } = agreements;
                if (useAgree && userinformation) {
                    submitButton.disabled = false;
                } else {
                    submitButton.disabled = true;
                }
                }

                checkAll.addEventListener('click', (e) => {
                const { checked } = e.target;
                if (checked) {
                    checkBoxes.forEach((item) => {
                    item.checked = true;
                    agreements[item.id] = true;
                    item.parentNode.classList.add('active');
                    });
                } else {
                    checkBoxes.forEach((item) => {
                    item.checked = false;
                    agreements[item.id] = false;
                    item.parentNode.classList.remove('active');
                    });
                }
                toggleSubmitButton();
                });
                

            </script>
        </div>

</body>
</html>