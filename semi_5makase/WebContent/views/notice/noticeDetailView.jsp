<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            @font-face {
            font-family: 'SUITE-Regular';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/SUITE-Regular.woff2') format('woff2');
            font-weight: 400;
            font-style: normal;
            }
            div {
                /* border: 1px solid black; */
                box-sizing: border-box;
                font-family: 'SUITE-Regular';
            }
            .wrap {
                width: 1000px;
                height: 1200px;
                margin: auto;
            }
            
            #header{
                width: 100%;
                height: 7%;
            }
            
            .wrap>div{
                width: 100%;
            }
    
            #header{
                height: 7%;
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
                margin-top: 30px;
                margin-left: 20px;
            }
    
            #header>div{
                height: 100%;
                float: left;
            }
    
            #content{
                height: 78%;
            }
            #footer{
                height: 15%;
                display: inline-block;
            }
            #content_top1, #content_top2, #content_top3{
                width: 33.3333%;
                height: 10%;
                float: left;
                border: 1px solid black;
            }
            #content_top3{
                height: 10%;
            } 
            #content_top1>h5, #content_top2>h5, #content_top3>h5{
                margin-top: 10px;
                margin-left: 15px;
            }
            #content_top1>p, #content_top2>p, #content_top3>p{
                color: gray;
                font-size: small;
                font-weight: 500;
                margin-left: 15px;
            }
            #content_top2:hover, #content_top3:hover{
                background-color: rgb(240, 240, 240);
                cursor: pointer;
            }
            #content_main{
                height: 80%;
                width: 70%;
                margin: auto;
                margin-top: 9%;
            }
            
            #btnToNoticeList{
                margin-top: 70px;
                border: transparent;
                width: 100px;
                height: 40px;
                background-color: rgb(21, 98, 189);
                color: white;
                border-radius: 10px;
                margin-left: 580px;
                
            }
    
            #noticeDate {
                font-size: small;
                color: gray;
            }
    
            #footer_1{
                margin-top: 20px;
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
    
    
            
        </style>
    </head>
    <body>
    
        <div class="wrap">
            <div id="header" style="border-bottom: 1px solid black;">
                <div id="header">
                    <div id="logo">
                        <img src="resources/img/logo.png">
                    </div>
                    <div id="search">
                        <input type="text" name="" id="searchTab">
                        <input type="submit" name="" id="">
                    </div>
                    <div id="login"></div>
                </div>
            </div>
            <div id="content">
                <h2 style="margin-top: 15px;">이눔세끼 공지사항</h2> <br>
                <div id="content_top1">
                    <h5>Tel. 02-123-1234</h5>
                    <p>평일 : 9:00~18:00</p>
                </div>
                <div id="content_top2" style="border-left: 0px;" onclick="location.href='http://localhost:8001/jsp/';">
                    <h5>Q&A 게시판</h5>
                    <p>생각하고 질문하세요</p>
                </div>
                <div id="content_top3" style="border-left: 0px;" onclick="location.href='http://localhost:8001/jsp/';">
                    <h5>FAQ</h5>
                    <p>자주 묻는 질문</p>
                </div>
                <div id="content_main">
                    <div id="noticeTitle"> <br>
                        <h2>[공지] 망고플레이트 개인정보 처리방침 변경 안내</h2>
                    </div>
                    <div id="noticeDate">
                        2020-02-20
                    </div>
                    <div id="noticeMain" style="word-break:break-all;"> <br>
                        안녕하세요. 맛있는 경험, 맛있는 삶 망고플레이트입니다. <br>
                        망고플레이트 개인정보처리방침을 일부 변경하게 되어 이를 알려 드리고자 합니다. <br>
                        <br>
                        
    
                        1. 주요 변경 사항 <br>
                        1) 개인정보 수집항목 현행화 <br>
                        2) 개인정보의 제3자 제공 현행화 <br>
                        3) 개인정보 처리위탁 업체 현행화 <br>
                        4) 개인정보의 안전성 확보조치 세부 항목 추가 <br>
                        <br>
                        
    
                        ※ 자세한 사항은 '개인정보처리방침 보기' 내용을 통해 확인할 수 있습니다. <br>
                        개인정보 처리방침 보기 <br>
                        <br>
                        
    
                        2. 변경 시기 <br>
                        변경 사항은 2023년 3월 31일부터 적용됩니다. <br>
                        <br>
                        
    
                        앞으로도 지속적인 서비스 이용과 관심 부탁드립니다. <br>
                        감사합니다.
                        
                    </div>
                    <button id="btnToNoticeList">목록으로</button>
                </div>
            </div>
            <div id="footer">
                <div id="footer_1">
                    <a href=""> 데이터 제휴 문의 </a>
                    <a href=""> 개인정보처리방침 </a>
                    <a href=""> 이용약관 </a>
                    <a href=""> 위치기반 서비스 이용약관 </a>
                </div>
                <div id="footer_2">
                    <b>(주)유소</b>
                    <span>소재지 : 서울특별시 강남구 역삼동</span>
                </div>
                <div id="footer_3">
                    <span>이메일 문의: 2num@enum.com</span>
                </div>
                <div id="footer_4">
                    <span>전화 문의 : 02-457-1304 (평일 : 10:00 ~ 19:00, 주말/공휴일 제외)</span>
                    <span style="margin-left: 260px;">Copyright Ⓒ 2023 Diningcode</span>
                </div>
            </div>
        </div>
        
    </body>
    </html>