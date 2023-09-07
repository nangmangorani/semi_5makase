<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        div{
            /* border: 1px solid red; */
            font-family: 'SUITE-Regular';
            box-sizing: border-box;
        }

        .wrap {
            width: 1000px;
            height: 200px;
            margin: auto;
            background: white;
            color: black;
        }

        #footer{
            width: 100%;
            height: 100%;
        }

        #footer_1{
            margin-top: 20px;
        }
        
        #footer *{
            margin-left: 20px;
        }

        #footer_1>a{
            text-decoration: none;
            color: rgb(99, 214, 208);
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
        <div id="footer">
            <div id="footer_1">
                <a href=""> 데이터 제휴 문의 </a>
                <a href=""> 개인정보처리방침 </a>
                <a href=""> 이용약관 </a>
                <a href=""> 위치기반 서비스 이용약관 </a>
            </div>
            <div id="footer_2">
                <b>(주)이눔세끼</b>
                <span>소재지 : 서울특별시 강남구 역삼동</span>
            </div>
            <div id="footer_3">
                <span>이메일 문의: 2num@inum.com</span>
            </div>
            <div id="footer_4">
                <span>전화 문의 : 02-457-1304 (평일 : 10:00 ~ 19:00, 주말/공휴일 제외)</span>
                <span style="margin-left: 160px;">Copyright Ⓒ 2023 inummsekki</span>
            </div>
        </div>
    </div>
</body>
</html>