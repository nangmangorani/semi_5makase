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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>

    <style>
        @font-face {
            font-family: 'omyu_pretty';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-01@1.0/omyu_pretty.woff2') format('woff2');
            font-weight: normal;
            font-style: normal;
        }

        @font-face {
            font-family: 'SUITE-Regular';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/SUITE-Regular.woff2') format('woff2');
            font-weight: 400;
            font-style: normal;
        }


        div {
            /* border: 1px solid red;/ */
            font-family: 'SUITE-Regular';
            box-sizing: border-box;
        }

        span {
            box-sizing: border-box;
        }

        .wrap {
            width: 1000px;
            height: 2000px;
            margin: auto;
        }

        #header {
            height: 5%;
        }

        .wrap>div {
            width: 100%;
        }

        #logo,
        #login {
            width: 20%;
        }

        #search {
            width: 60%;
        }


        #logo>img {
            width: 80px;
            height: 77px;
        }


        #searchTab {
            width: 500px;
            border-radius: 20px;
            margin-top: 25px;
            margin-left: 20px;
        }

        #header>div {
            height: 100%;
            float: left;
        }

        #content {
            width: 100%;
            height: 78%;
        }

        #category {
            width: 25%;
            height: 80%;
            float: left;
        }

        #mainContent {
            width: 70%;
            height: 100%;
            float: right;
        }

        .Title_Bullet {
            width: 13px;
            height: 13px;
            margin-top: 5px;
            margin-left: 15px;
            float: left;
            border-radius: 5px;
            border: 0px;
        }

        h5 {
            margin-top: 15px;
            font-weight: 700;
        }

        .category_1 {
            margin-left: 15px;
            margin-top: 11px;
        }

        #footer {
            width: 100%;
            height: 15%;
            display: inline-block;
        }

        #category_1 {
            height: 12%;
            border-bottom: 1px solid lightgray;

        }

        .category_2 {
            margin-left: 15px;
            margin-top: 10px;
        }

        #category_2 {
            height: 3%;

            border-bottom: 1px solid lightgray;
        }

        .category_3 {
            margin-left: 15px;
            margin-top: 8px;
        }

        #category_3 {
            height: 11%;

        }

        #category_4 {
            height: 7%;
            border-bottom: 1px solid lightgray;
        }

        .category_5 {
            margin-left: 15px;
            margin-top: 10px;
        }



        .addBtn,
        .addBtn2 {
            /* display: flex;
            margin: auto;
            justify-content: center;
            align-items:center; */
            width: 225px;
            background-color: rgba(207, 206, 206, 0.555);
            border: 0px;
            font-size: 14px;
            height: 28px;
        }

        .order {
            height: 4%;
        }

        .left {
            float: left;
            height: 100%;
            width: 15%;
            text-align: center;
            line-height: 60px;
            font-weight: 600;
        }

        .orderImg {
            width: 20px;
            height: 20px;
        }

        .order>button {
            margin-left: 25px;
            margin-top: 13px;
            background-color: white;
            border: 1px solid rgba(85, 84, 84, 0.712);
            color: rgba(85, 84, 84, 0.712);
            border-radius: 5px;
            height: 35px;
            width: 100px;
        }

        .order>button:hover {
            border: 1px solid black;
            color: black;
        }


        #result>span {
            margin-left: 15px;
            font-size: 20px;
            font-weight: 600;
        }

        .restaurant {
            height: 15%;
            width: 100%;
            border-bottom: 1px solid lightgray;
        }

        .imgLine {
            height: 80%;
            width: 100%;
            padding-top: 10px;
        }

        .textLine {
            height: 20%;
            width: 100%;
        }

        .textLine>span {
            margin-left: 20px;
            width: 100%;
        }

        .imgLine>img {
            height: 120px;
            width: 120px;
            margin-left: 20px;
            margin-top: 20px;
            border-radius: 10px;
        }

        .imgLeft {
            float: left;
            height: 100%;
            width: 25%;
        }

        .imgRight {
            height: 100%;
        }

        .imgRight_1>span {
            font-size: 23px;
            line-height: 50px;
        }

        .imgLeft>img {
            width: 85%;
            height: 85%;
            margin-left: 13px;
            margin-top: 11px;
            border-radius: 10px;
        }

        .imgRight_4>img {
            width: 20px;
        }

        .restaurant:hover {
            background-color: rgb(240, 240, 240);
        }

        #bigHeart {
            width: 35px;
            height: 35px;
            float: right;
            margin-right: 40px;
            margin-top: 10px;
        }

        .location {
            margin-left: 14px;
            margin-top: 6px;
            width: 210px;
            height: 30px;
            border: 1px solid lightgray;
            padding-left: 10px;
        }

        .searchPlus {
            display: flex;
            margin: auto;
            justify-content: center;
            align-items: center;
            width: 660px;
            height: 50px;
            margin-top: 20px;
            border-radius: 10px;
            background-color: rgb(21, 98, 189);
            color: white;
            border: transparent;
        }

        #content_bottom {
            text-align: center;
            height: 180px;
            padding-top: 10px;
        }

        #addRestaurant {
            width: 350px;
            height: 50px;
            margin-top: 10px;
            margin-bottom: -15px;
            border-radius: 10px;
            background-color: rgb(25, 183, 194);
            color: white;
            font-weight: 540;
            border: transparent;
        }

        #content_bottom>span {
            font-size: 13px;
            color: gray;
            font-weight: 500;
        }

        #footer_1 {
            margin-top: 100px;
        }

        #footer * {
            margin-left: 20px;
        }

        #footer_1>a {
            text-decoration: none;
            color: black;
            font-weight: 600;
        }

        #footer_2 {
            margin-top: 20px;
        }

        #footer_3 {
            margin-top: 10px;
        }

        #footer_4 {
            margin-top: 10px;
        }

        .pagination {
            margin-top: 20px;
            margin-left: 200px;
        }

        #inputRestaurantName {
            width: 465px;
            height: 40px;
            margin-top: 5px;
        }

        #inputRestaurantInf {
            width: 465px;
            height: 300px;
            resize: none;
            margin-top: 5px;
        }

        .modalBtn {
            width: 225px;
            height: 33px;
            margin-top: 5px;
            border-radius: 5px;
        }

        #modalBtn1 {
            width: 70px;
            height: 70px;
            background-color: transparent;
            margin-top: 10px;
            margin-bottom: 10px;
        }

        #modalBtn2 {
            border: 1px solid rgb(0, 205, 205);
            color: rgb(0, 205, 205);
            background-color: white;
        }

        #modalBtn3 {
            border: 1px solid transparent;
            background-color: rgb(0, 205, 205);
            color: white;
            margin-left: 11px;
        }

        #selectedPhotos {
            display: flex;
            flex-wrap: wrap;
            gap: 10px;
        }

        .preview-img {
            width: 150px;
            height: 150px;
            border: 1px solid #ccc;
        }

        .fileLabel {
            width: 80px;
            height: 80px;
            cursor: pointer;
            border: 1px solid lightgray;
            margin-top: 10px;

        }

        .fileLabel>img {
            height: 100%;
            width: 100%;

        }

        #photoInput {
            display: none;
        }


        .preview-container {
            position: relative;
            display: inline-block;
        }

        .preview-img {
            width: 80px;
            height: 80px;
            border: 1px solid #ccc;

        }

        .preview-container:hover .preview-img {
            opacity: 0.5;
        }




        .delete-button {
            display: none;
            position: absolute;
            top: 0;
            right: 0;
            background-color: transparent;
            font-weight: 900;
            color: black;
            border: none;
            padding: 2px 6px;
            cursor: pointer;
        }

        .preview-container:hover .delete-button {
            display: block;
        }

        .preview-img:hover {
            opacity: 0.5;
        }

        .photo-count {
            position: absolute;
            top: 5px;
            right: 5px;
            background-color: rgba(0, 0, 0, 0.5);
            color: black;
            padding: 2px 5px;
            border-radius: 3px;
        }

        .heart-container {
            cursor: pointer;
        }

        .heart {
            width: 35px;
            height: 35px;
            position: relative;
        }

        .heart::before,
        .heart::after {
            content: '';
            position: absolute;
            top: 0;
            width: 17.5px;
            height: 27.5px;
            margin-left: 350px;
            border-radius: 17.5px 17.5px 0 0;
            background: #ccc;
            /* Initial color: gray */
            transition: background 0.3s;
        }

        .heart::before {
            left: 17.5px;
            transform: rotate(-45deg);
            transform-origin: 0 100%;
        }

        .heart::after {
            left: 0;
            transform: rotate(45deg);
            transform-origin: 100% 100%;
        }

        .heart.filled::before,
        .heart.filled::after {
            background-color: rgb(215, 68, 62);
            /* Filled color: pink */
        }
    </style>
</head>

<body>
    <div class="wrap">
        <div id="header">
            <div id="logo">
                <img src="./이눔세끼화이팅/resources/img/logo.png">
            </div>
            <div id="search">
                <input type="text" name="" id="searchTab">
                <input type="submit" name="" id="">
            </div>
            <div id="login"></div>
        </div>
        <div id="content">
            <div id="category">
                <div id="category_1">
                    <div class="Title_Bullet" style="background-color: rgb(255, 125, 60);"></div>
                    <h5>&nbsp;이용자층</h5>

                    <form action="" class="ageCheckForm">
                        <label for="category_1_1">
                            <input type="checkbox" class="category_1" id="category_1_1"> 20대
                        </label>

                        <label for="category_1_2">
                            <input type="checkbox" class="category_1" style="margin-left: 70px;" id="category_1_2"> 30대
                            <br>
                        </label>

                        <label for="category_1_3">
                            <input type="checkbox" class="category_1" id="category_1_3"> 40대
                        </label>

                        <label for="category_1_4">
                            <input type="checkbox" class="category_1" style="margin-left: 70px;" id="category_1_4"> 50대
                            <br>
                        </label>

                        <label for="category_1_5">
                            <input type="checkbox" class="category_1" id="category_1_5"> 60대 이상
                        </label>
                    </form>
                </div>

                <div id="category_2">
                    <form action="" class="genderCheckForm">
                        <label for="category_2_1">
                            <input type="radio" class="category_2" name="gender" id="category_2_1"> 남자
                        </label>
                        <label for="category_2_2">
                            <input type="radio" class="category_2" name="gender" style="margin-left: 70px;"
                                id="category_2_2"> 여자 <br>
                        </label>
                    </form>
                </div>
                <div id="category_3">
                    <div class="Title_Bullet" style="background-color: rgb(10, 199, 206);"></div>
                    <h5>&nbsp;카테고리</h5>
                    <label for="category_3_1">
                        <input type="radio" class="category_3" name="gender" id="category_3_1"> 한식
                    </label>
                    <label for="category_3_2">
                        <input type="radio" class="category_3" name="gender" id="category_3_2"
                            style="margin-left: 70px;"> 밥집
                    </label>
                    <br>
                    <label for="category_3_3">
                        <input type="radio" class="category_3" name="gender" id="category_3_3"> 일식
                    </label>
                    <label for="category_3_4">
                        <input type="radio" class="category_3" name="gender" id="category_3_4"
                            style="margin-left: 70px;"> 중식
                    </label>
                    <br>
                    <label for="category_3_5">
                        <input type="radio" class="category_3" name="gender" id="category_3_5"> 양식
                    </label>
                    <label for="category_3_6">
                        <input type="radio" class="category_3" name="gender" id="category_3_6"
                            style="margin-left: 70px;"> 분식
                    </label>
                </div>
                <div id="hiddenCategory">
                    <label for="category_3_7">
                        <input type="radio" class="category_3" name="gender" id="category_3_7"> 면요리
                    </label>
                    <label for="category_3_8">
                        <input type="radio" class="category_3" name="gender" id="category_3_8"
                            style="margin-left: 56px;"> 국물요리
                    </label>
                    <br>
                    <label for="category_3_9">
                        <input type="radio" class="category_3" name="gender" id="category_3_9"> 해산물
                    </label>
                    <label for="category_3_10">
                        <input type="radio" class="category_3" name="gender" id="category_3_10"
                            style="margin-left: 56px;"> 한식
                    </label>
                    <br>
                </div>
                <button class="addBtn" style="margin: auto;">펼치기</button>

                <div id="category_4">
                    <div class="Title_Bullet" style="background-color: rgb(251, 201, 68);"></div>
                    <h5>&nbsp;지역</h5>
                    <select name="location" class="location">
                        <option value="" selected>선택안함</option>
                        <option value="kangnam">강남구</option>
                        <option value="seocho">서초구</option>
                        <option value="songpa">송파구</option>
                        <option value="mapo">마포구</option>
                        <option value="ddm">동대문구</option>
                        <option value="gwanak">관악구</option>
                    </select>
                </div>
                <div id="category_5">
                    <div class="Title_Bullet" style="background-color: rgb(49, 128, 161);"></div>
                    <h5>&nbsp;TV맛집</h5>
                    <form action="">
                        <label for="">
                            <input type="checkbox" class="category_5" name="" id=""> 생활의달인
                        </label><br>
                        <label for="">
                            <input type="checkbox" class="category_5" name="" id=""> 수요미식회
                        </label><br>
                        <label for="">
                            <input type="checkbox" class="category_5" name="" id=""> 미쉐린
                        </label><br>
                        <label for="">
                            <input type="checkbox" class="category_5" name="" id=""> 최자로드
                        </label><br>
                        <label for="">
                            <input type="checkbox" class="category_5" name="" id=""> 성시경의먹을텐데
                        </label><br>
                    </form>
                </div>

                <div id="hiddenTv">
                    <form action="">
                        <label for="">
                            <input type="checkbox" class="category_5" name="" id=""> 백종원의3대천왕
                        </label><br>
                        <label for="">
                            <input type="checkbox" class="category_5" name="" id=""> 식객허영만의백반기행
                        </label><br>
                        <label for="">
                            <input type="checkbox" class="category_5" name="" id=""> 백년가게
                        </label><br>
                        <label for="">
                            <input type="checkbox" class="category_5" name="" id=""> 맛있는녀석들
                        </label><br>
                        <label for="">
                            <input type="checkbox" class="category_5" name="" id=""> 한국인의밥상
                        </label><br>
                    </form>
                </div>
                <button class="addBtn2" style="margin: auto;">펼치기</button>
            </div>
            <div id="mainContent">
                <div class="order">
                    <div class="left"><img
                            src="https://dcicons.s3.ap-northeast-1.amazonaws.com/new/images/web/react_components/Order/order.png"
                            class="orderImg"> 정렬</div>
                    <button>조회수순</button>
                    <button>평점순</button>
                    <button>즐겨찾기순</button>
                    <button>리뷰순</button>
                </div>
                <div id="result">
                    <span>
                        *** 검색결과 : ***개
                    </span>
                </div>
                <div class="restaurant">
                    <div class="imgLine">
                        <div class="imgLeft">
                            <img
                                src="https://d12zq4w4guyljn.cloudfront.net/300_300_20230813205739_photo1_e85403339e4d.jpg">
                        </div>
                        <div class="imgRight">
                            <div class="imgRight_1" style="margin-top: 10px;">
                                <span>1. 주원식당</span>
                                <span class="heart-container" onclick="handleContainerClick(event)">
                                    <span class="heart"></span>
                                </span>
                            </div>
                            <div class="imgRight_2">
                                <span>짬뽕순두부</span>, &nbsp;
                                <strong>순두부짬뽕</strong>
                            </div>
                            <div class="imgRight_3">
                                <span>#한국인의밥상</span>,
                                <span>#가족외식</span>,
                                <span>#무료주차</span>
                            </div>
                            <div class="imgRight_4" style="margin-top: 10px;">
                                <img src="https://dcicons.s3.ap-northeast-1.amazonaws.com/new/images/mobile/react_m_common/card__score__star2.png"
                                    alt="">
                                4.2 (13명)
                                &nbsp;&nbsp;
                                <img src="./이눔세끼화이팅/resources/img/view1.png" alt="">
                                121,732
                                &nbsp;&nbsp;
                                <img src="./이눔세끼화이팅/resources/img/heart.png" alt="">
                                657

                            </div>

                        </div>
                    </div>
                    <div class="textLine">
                        <span>
                            연예인 주원이 하는곳인줄 알고 갔는데 강주원이있네요..
                        </span>
                    </div>
                </div>
                
                <!-- <button class="searchPlus">검색결과 더보기</button> <br> -->
                <nav aria-label="...">
                    <ul class="pagination pagination-lg">
                        <li class="page-item active" aria-current="page">
                            <span class="page-link">1</span>
                        </li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item"><a class="page-link" href="#">4</a></li>
                        <li class="page-item"><a class="page-link" href="#">5</a></li>
                    </ul>
                </nav>
                <div id="content_bottom">
                    <h5>찾으시는 식당이 없나요?</h5>
                    <button id="addRestaurant" data-toggle="modal" data-target="#addRestaurantModal">음식점 추가하기</button>
                    <br><br>
                    <span>되는대로 연락드리겠습니다.</span>
                </div>
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
    <script>
        $("[id^='hiddenCategory']").hide();

        $(function () {
            $(".addBtn").click(function () {
                if ($(this).html() == '접기') {
                    $(this).html('펼치기');
                } else {
                    $(this).html('접기');
                }
                $("#hiddenCategory").toggle();
            })
        })

        $("#hiddenTv").hide();

        $(function () {
            $(".addBtn2").click(function () {
                if ($(this).html() == '접기') {
                    $(this).html('펼치기');
                } else {
                    $(this).html('접기');
                }
                $("#hiddenTv").toggle();
            })

        })
    </script>
    <!-- 회원탈퇴용 Modal -->
    <div class="modal" id="addRestaurantModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">음식점 추가하기</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form action="" method="post">
                        <span>식당이름</span> <br>
                        <input type="text" name="" id="inputRestaurantName" placeholder="등록하려는 식당명을 입력하세요."> <br><br>
                        <span>식당정보</span> <br>
                        <textarea name="" id="inputRestaurantInf" cols="30" rows="10"
                            placeholder="식당에 대한 정보를 자유롭게 써주세요."></textarea> <br>
                        <div id="selectedPhotos"></div>
                        <label for="photoInput" class="fileLabel">
                            <img src="./이눔세끼화이팅/resources/img/iconmonstr-plus-lined-240.png" alt="">
                        </label>
                        <input type="file" id="photoInput" multiple>
                        <span class="photoInputCount"></span>

                        <script src="script.js"></script>


                        <br>
                        <button class="modalBtn" id="modalBtn2">닫기</button>
                        <button class="modalBtn" id="modalBtn3">제출</button>

                    </form>
                </div>
            </div>
        </div>
        <script>
            document.addEventListener('DOMContentLoaded', function () {
                const photoInput = document.getElementById('photoInput');
                const selectedPhotosContainer = document.getElementById('selectedPhotos');
                const photoInputCount = document.querySelector('.photoInputCount');

                // 이미지 담길 배열
                let selectedPhotos = [];

                photoInput.addEventListener('change', function (event) {
                    const newSelectedPhotos = Array.from(event.target.files);
                    const totalPhotos = selectedPhotos.length + newSelectedPhotos.length;

                    if (totalPhotos > 5) {
                        alert("최대 5장까지 가능합니다.");
                        return; // 총 사진 개수가 제한을 초과하면 처리 중지
                    }

                    selectedPhotos.push(...newSelectedPhotos); // 새로운 사진 추가
                    updateSelectedPhotosList();
                    updatePhotoInputCount();
                });

                function updateSelectedPhotosList() {
                    selectedPhotosContainer.innerHTML = '';
                    selectedPhotos.forEach((photo, index) => {
                        const photoItem = document.createElement('div');
                        const previewContainer = document.createElement('div');
                        const previewImg = document.createElement('img');
                        const deleteButton = document.createElement('button');

                        previewContainer.classList.add('preview-container');
                        previewImg.src = URL.createObjectURL(photo);
                        previewImg.classList.add('preview-img');
                        deleteButton.textContent = 'X';
                        deleteButton.classList.add('delete-button');
                        deleteButton.addEventListener('click', function () {
                            selectedPhotos.splice(index, 1);
                            updateSelectedPhotosList();
                            updatePhotoInputCount(); // 사진 삭제 후 카운트 업데이트
                            clearPhotoInput(); // 이미지 삭제 후 입력값 초기화
                        });

                        function clearPhotoInput() {
                            photoInput.value = ''; // 입력값 초기화
                        }

                        previewContainer.appendChild(previewImg);
                        previewContainer.appendChild(deleteButton);
                        photoItem.appendChild(previewContainer);
                        selectedPhotosContainer.appendChild(photoItem);
                    });

                    updatePhotoInputCount(); // 사진 추가 시 카운트 업데이트
                }

                function updatePhotoInputCount() {
                    const countDisplay = `${selectedPhotos.length}/5`; // 총 사진 개수 표시
                    photoInputCount.textContent = countDisplay;
                }

                // 초기화
                updateSelectedPhotosList();
                updatePhotoInputCount();
            });





            // 하트 토글 스크립트구문
            const heartContainer = document.querySelector('.heart-container');
            const heart = heartContainer.querySelector('.heart');

            heart.addEventListener('click', (event) => {
                event.stopPropagation();
                heart.classList.toggle('filled');

            });

            heartContainer.addEventListener('click', (event) => {
                event.stopPropagation();
            });

        </script>
</body>

</html>