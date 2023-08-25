<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<style>
    div{box-sizing: border-box;}

    .menubar-area{
        position: sticky;
        top: 0;
        height: 100px;
        width: 1100px;
        margin: auto;
        background-color: white;
        z-index: 5;
    }

    .logo-area>img{
        margin-left: 45px;
        max-width: 90%;
        max-height: 90%;
    }
    
    .logo-area, .searchbar-area, .member-area{
        height: 100px;
        float: left;
    }
    
    .logo-area, .member-area{width: 20%;}

    .member-area a{
        text-decoration: none;
        color: black;
        line-height: 90px;
        margin: 20px;
        font-size: 12px;
    }
    
    .searchbar-area{
        width: 60%;
        position: relative;
    }

    .searchbar-area input[type=text]{
        border-radius: 200px;
        width: 400px;
        height: 40px;
        margin: 25px 50px;
        background-color: rgb(240, 240, 240);
        border-color: white;
        padding-right: 30px; 
    }

    .searchbar-area button{
        position: absolute;
        top: 50%;
        right: 200px;
        transform: translateY(-60%);
        border: 0;
        cursor: pointer;
    }

    #form1 input{
      
    }
com.semi_5makase.
</style>
<body>
    <div class="menubar-area">
        <div class="logo-area">
            <img src="resources/img/logo.png">
        </div>
        <div class="searchbar-area">
            <form id="form1" method="post" action="restSearch">
                <input type="text" name="searchVal" placeholder="     지역, 음식 또는 식당명을 입력해주세요. " style="border: 0px;">
                <button type="submit"><img src="resources/img/searchIcon.png"></button>
            </form>
        </div>
        <div class="member-area" align="center">
            <a href="">로그인</a>
            <a href="">회원가입</a>
        </div>
    </div>
</body>
</html>