<%@page import="com.semi_5makase.restaurant.model.vo.Restaurant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int memNo = (int)request.getAttribute("memNo");
	String nickName = (String)request.getAttribute("nickName");
	Restaurant rest = (Restaurant)request.getAttribute("rest");
	
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        /* 별점 매기기 */
        .star-rating {

        display:flex;
        flex-direction: row-reverse;
        font-size:1.5em;
        justify-content:space-around;
        padding:0 .2em;
        text-align:center;
        width:5em;
        }

        .star-rating input {
        display:none;
        }

        .star-rating label {
        color:#ccc;
        cursor:pointer;
        }

        .star-rating :checked ~ label {
        color:#f90;
        }

        .star-rating label:hover,
        .star-rating label:hover ~ label {
        color:#fc0;
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
            margin-left: 15px;
            display: block;
            width: 100%;
            border: 0;
            font-size: 16px;
            resize: none;
        }
        .review:focus {
        outline: none;
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
        .back{
            margin-top: 20px;
            min-width: 140px;
            min-height: 50px;
            margin-right: 34px;
            padding-left: 14px;
            padding-right: 14px;
            border: 1px solid rgb(16, 199, 212);
            border-radius: 50px;
            font-size: 16px;
            color: rgb(15, 155, 202);
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
            background-color: rgb(37, 176, 231);
        }
    
    </style>
</head>

<body>
    <div class="content">
        <div class="header">
            <strong class="restaurent"><%= rest.getRestName() %></strong>
            <span class="subMessage">에 대한 리뷰를 작성해주세요.</span>
        </div>
        <form id="form" action="<%= contextPath %>/insertReview.rv" method="post" enctype="multipart/form-data" onsubmit="return enroll()">
        	<input type="hidden" name="restNo" value="<%= rest.getRestNo() %>">
	        <div class="contentWrap">
	            <div class="formWrap">
	                <div class="editor">
	                    <div class="editorWrap">
	                        <div class="recommendWrap">
	                            <div class="star">
	                                <div class="star-rating">
                                        <input type="radio" id="5-stars" name="rating" value="5" />
                                        <label for="5-stars" class="star">&#9733;</label>
                                        <input type="radio" id="4-stars" name="rating" value="4" />
                                        <label for="4-stars" class="star">&#9733;</label>
                                        <input type="radio" id="3-stars" name="rating" value="3" />
                                        <label for="3-stars" class="star">&#9733;</label>
                                        <input type="radio" id="2-stars" name="rating" value="2" />
                                        <label for="2-stars" class="star">&#9733;</label>
                                        <input type="radio" id="1-star" name="rating" value="1" />
                                        <label for="1-star" class="star">&#9733;</label>
                                    </div>
	                            </div>
	                        </div>
	                        <textarea class="review" name="reviewContent" maxlength="10000" style="overflow: hidden; overflow-wrap: break-word; height: 150px; width: 640px;" placeholder="<%= nickName %>님, 주문하신 메뉴는 어떠셨나요? 식당의 분위기와 서비스가 궁금해요!"></textarea>
	                    </div>
	                    <p class="textLength">
	                        <span id="count">0</span>/300
	                    </p>
	                    <script>
	                    	$(".review").keyup(function(){
	                    		let length = $(this).val().length;
	                    		$("#count").text(length);

                                if(length > 300){
                                    alert("300자 미만으로 작성해주세요!")
                                }
	                    	})
	                    </script>
	                </div>
	                <div class="photo">
                        <table>
                            <tr>
                                <td><img id="contentImg1" width="155" height="120" onclick="chooseFile(1);"></td>
                                <td><img id="contentImg2" width="155" height="120" onclick="chooseFile(2);"></td>
                                <td><img id="contentImg3" width="155" height="120" onclick="chooseFile(3);"></td>
                                <td><img id="contentImg4" width="155" height="120" onclick="chooseFile(4);"></td>
                                <td width="35"><span id="countPic">&nbsp;0</span>/4</td>
                            </tr>
                        </table>
                        <div class="photoContain">
                            <div id="file-area" style="display:none">
                                <input type="file" name="file1" id="file1" onchange="loadImg(this, 1);">
                                <input type="file" name="file2" id="file2" onchange="loadImg(this, 2);">
                                <input type="file" name="file3" id="file3" onchange="loadImg(this, 3);">
                                <input type="file" name="file4" id="file4" onchange="loadImg(this, 4);">
                            </div>
                        </div>
	                </div>
	                <div>
	                	<button type="button" class="back" onclick="history.back()">뒤로가기</button>
	                    <button type="reset" class="cancle">취소</button>
	                    <button type="submit" class="enroll">리뷰 등록</button>
	                </div>
	            </div>
                <script>
                	// 사진 등록
                	function chooseFile(num){
            		$("#file" + num).click();
            		}
                	
                	let count = 0;
                	
                	function loadImg(inputFile, num){
                		if(inputFile.files.length == 1){
                			count++;
                			const reader = new FileReader();
                			reader.readAsDataURL(inputFile.files[0]);
                			reader.onload = function(e){
                				switch(num){
                					case 1 : $("#contentImg1").attr("src", e.target.result); break;
                					case 2 : $("#contentImg2").attr("src", e.target.result); break;
                					case 3 : $("#contentImg3").attr("src", e.target.result); break;
                					case 4 : $("#contentImg4").attr("src", e.target.result); break;
                				}
                			}
                		} else{
                			count--;
                			switch(num){
	    						case 1 : $("#contentImg1").attr("src", null); break;
	    						case 2 : $("#contentImg2").attr("src", null); break;
	    						case 3 : $("#contentImg3").attr("src", null); break;
	    						case 4 : $("#contentImg4").attr("src", null); break;
                		}
                	}
                		updateCount();
                	}
                	
                	function updateCount(){
                		$("#countPic").text(count);
                	}
                	
					// 안됨 해결해야됨
                    $(".review").keyup(function(){
                        switch(!($(".review").val())){
                            case true : $(".enroll").attr("disabled", true); break;
                            case false : $(".enroll").attr("disabled", false); break;
                        }
                    })
                    
                    function enroll(){
						
						const star = $("input[type='radio']:checked");
						const text = $(".review").val();
						
						if(!star.length || !text){
							alert("별점과 리뷰내용을 등록해주세요!");
							return false;
						}
						
					}
 
                </script>
	        </div>
        </form>
    </div>
    
</body>
</html>