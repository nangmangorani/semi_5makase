<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        button {
        appearance: none;
        cursor: pointer;
        border: 0px;
        border-radius: 0;
        background-color: transparent;
        }
        ol,ul,ul li{
            list-style: none;
        }
        .content{
            width: 678px;
            margin: 101px auto 62px;
        }
        .header{
            display: block;
        }
        .restaurent{
            font-size: 28px;
            line-height: 1.45;
            color: lightblue;
            word-break: break-word;
        }
        .subMessage{
            font-size: 16px;
            line-height: 1.45;
            color: #7f7f7f;
        }
        .editorWrap{
            border: 1px solid #dbdbdb;
            border-radius: 5px;
            box-sizing: 3px;
            padding: 16px;
        }
        .recommendWrap{
            margin-bottom: 20px;
            box-sizing: border-box;
        }
        .recommendWrap>div{
            display: inline-block;
            width: 49.2%;
            height: 100%;
        }
        .star{
            font-size: 24px;
        }
        .list{
            float: right;
        }
        .likePicture1{
            background-image: url(resources/img/notGood.png);
            display: inline-block;
            width: 35px;
            height: 35px;
            margin-right: 20px;
            background-size: cover;
        }
        .likePicture2{
            background-image: url(resources/img/Good.png);
            display: inline-block;
            width: 35px;
            height: 35px;
            margin-right: 20px;
            background-size: cover;
        }
        .review{
            display: block;
            width: 100%;
            border: 0;
            font-size: 16px;
            resize: none;
    
        }
        .review:placeholder-shown{
            color: #cbcbcb;
        }
        .textLength{
            text-align: right;
            bottom: -4px;
            right: 0px;
            font-size: 12px;
            line-height: normal;
            color: #7F7F7F;
        }
        .photoWrap{
            width: 89px;
            height: 89px;
            line-height: 89px;
            border: 1px dashed #DBDBDB;
            cursor: pointer;
            padding-top: 20px;
        }
        .photoAdd{
            background-image: url(resources/img/plus.png);
            display: -webkit-inline-box;
            width: 50px;
            height: 50px;
            background-size: cover;
        }
        .photoCounter{
            font-size: 12px;
            text-align: right;
            color: #7F7F7F;
            width: 90px;
        }
        .rewrite{
            margin-top: 20px;
            min-width: 140px;
            min-height: 50px;
            margin-right: 34px;
            padding-left: 14px;
            padding-right: 14px;
            border: 1px solid lightblue;
            border-radius: 50px;
            font-size: 16px;
            color: lightblue;
            text-align: center;
            background-color: #FFFFFF;
        }
        .cancle{
            margin-left: 28%;
            min-width: 140px;
            min-height: 50px;
            margin-right: 16px;
            padding-left: 14px;
            padding-right: 14px;
            border: 1px solid #7F7F7F;
            border-radius: 50px;
            font-size: 16px;
            color: #7F7F7F;
            text-align: center;
            background-color: #FFFFFF;
        }
        .enroll{
            min-width: 140px;
            min-height: 50px;
            padding-left: 14px;
            padding-right: 14px;
            border: 1px solid lightblue;
            border-radius: 50px;
            font-size: 16px;
            color: #FFFFFF;
            text-align: center;
            background-color: lightblue;
        }
    
    </style>
</head>

<body>
    <div class="content">
        <div class="header">
            <strong class="restaurent">음식점</strong>
            <span class="subMessage">에 대한 리뷰를 작성해주세요.</span>
        </div>
        <div class="contentWrap">
            <div class="formWrap">
                <div class="editor">
                    <div class="editorWrap">
                        <div class="recommendWrap">
                            <div class="star">
                                별점 :
                            </div>
                            <div class="recommendPicture">
                                <ul class="pictureList">
                                    <li class="list">
                                        <button>
                                            <i class="likePicture1"></i>
                                        </button>
                                    </li>
                                    <li class="list">
                                        <button>
                                            <i class="likePicture2"></i>
                                        </button>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <textarea class="review" maxlength="10000" style="overflow: hidden; overflow-wrap: break-word; height: 150px;" placeholder="식당의 분위기와 서비스가 궁금해요!"></textarea>
                    </div>
                    <p class="textLength">
                        <span>0</span>
                        <span>/</span>
                        <span>500</span>
                    </p>
                </div>
                <div class="photo">
                    <div class="photoContain">
                        <ul>
                            <li>
                                <button class="photoWrap">
                                    <i class="photoAdd"></i>
                                </button>
                            </li>
                        </ul>
                    </div>
                    <div class="photoCounter" style="top: 90px; left: 90px; display: block;">
                        <span>0</span>
                        <span>/</span>
                        <span>5</span>
                    </div>
                </div>
                <div>
                    <button class="rewrite">나중에 이어쓰기</button>
                    <button class="cancle">취소</button>
                    <button class="enroll">리뷰 등록</button>
                </div>
            </div>
    
        </div>
    </div>
    
</body>
</html>