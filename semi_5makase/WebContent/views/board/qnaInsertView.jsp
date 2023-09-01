<%@page import="com.semi_5makase.board.model.vo.Faq"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.semi_5makase.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Faq> faqList = (ArrayList<Faq>)request.getAttribute("faqList");
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
        #content{
            height: 100%;
        }

        #content_1{
            width: 50%;
            height: 100%;
            float: left;
            border-right: 1px solid gray;

        }
        #content_2{
            width: 50%;
            height: 100%;
            float: left;
        }
        #title{
            width: 380px;
            height: 30px;

            
        }
        #content1{
            width: 380px;
            height: 200px;
        }
        #picture{
            margin-right: 18px;
        }
        #textarea{
            margin-left: 50px;
        }

        .change{
            width: 100px;
            height: 100px;
        }

        .image-container {
            display: flex;
            flex-wrap: wrap;
        }
        
        /* Style for the image container */
        .image-container {
            display: flex;
            flex-wrap: wrap;
        }

        /* Style for individual image divs */
        .image {
            margin: 10px;
            border: 1px solid #ccc;
            padding: 5px;
            text-align: center;
            position: relative;
        }
        
        /* Style for the image itself */
        .image img {
            max-width: 100%; /* Ensure the image doesn't exceed its container */
            max-height: 150px; /* Set the maximum height of the image */
        }

        /* Style for delete buttons */
        .delete-button {
            background-color: red;
            color: white;
            border: none;
            cursor: pointer;
            padding: 5px;
            position: absolute;
            top: 5px;
            right: 5px;
        }
        #image_preview{
            margin-right: 310px;
        }
        #hide{
            margin-left: 350px;
        }
        #att_zone {
        width: 660px;
        min-height: 150px;
        padding: 10px;
        }

    </style>
</head>
<body>  
<%@ include file="../common/menubar.jsp"%>
    <div class="wrap">
        <div id="header"></div>
        <div id="content">
            <br>
            <div id="content_1"align="center">
                <br>
                <form action="<%= contextPath %>/insert.qna" method="post" enctype="multipart/form-data">
                	<input type="hidden" name="userNo" value="<%= loginMember.getMemNo() %>">
                  <b>제목 : </b>
                  <input type="text" id="title" name="title"><br><br>
  
                  <b style="margin-right: 384px;">내용 : </b><br>
                  <textarea name="content" id="textarea" placeholder="내용을 입력해주세요" cols="49" rows="10" style="resize: none;"></textarea><br><br>
  
		          <input type="radio" name="open" value="Y"> 공개
		          <input type="radio" name="open" value="N"> 비공개 <br>
                  
                  
                  
                  
                  <div id='image_preview'>
                      <b id="picture">사진 : </b>      
                      <input type='file' class='btnAtt' name="upfile1" />
                      <input type='file' class='btnAtt' name="upfile2" />
                      <input type='file' class='btnAtt' name="upfile3" />
                      <input type='file' class='btnAtt' name="upfile4" />
                      <input type='file' class='btnAtt' name="upfile5" />
                      <div id='att_zone'></div>
                  </div>
                  <button type="button" class="btn btn-secondary" style="width: 90px;">취소</button>
                  <button type="submit" id="next" class="btn btn-success">등록하기</button>

                </form>


            </div>


            <div id="content_2" align="center">
                <br>
                <b>자주묻는 질문</b> <a href="<%=contextPath%>/list.faq"><b style="margin-left: 350px; color: black;">전체</b></a><br>
                <div class="container" >
                    <table class="table" align="center" style="width: 100%;">
                      <thead class="thead-light">
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                        </tr>
                      </thead>
                      <tbody>
                        
                        	<% for(Faq f : faqList) { %>
                        	<tr>
                            <td><%= f.getFaqNo() %></td>
                            <td><%= f.getFaqTitle()%></td>
                            </tr>
                            <% } %>
                        
                      </tbody>
                    </table>


            </div>
        </div>
        <div id="footer"></div>
    </div>
        
    <script>
    ( /* att_zone : 이미지들이 들어갈 위치 id, btn : file tag id */
  imageView = function imageView(att_zone, btn){

    var attZone = document.getElementById(att_zone);
    var btnAtt = document.getElementById(btn)
    var sel_files = [];
    
    // 이미지와 체크 박스를 감싸고 있는 div 속성
    var div_style = 'display:inline-block;position:relative;'
              + 'width:70px;height:70px;margin:5px;z-index:1';

    // 미리보기 이미지 속성
    var img_style = 'width:100%;height:100%;z-index:none';
    // 이미지안에 표시되는 체크박스의 속성
    var chk_style = 'width:30px;height:30px;position:absolute;font-size:24px;'
              + 'right:0px;bottom:0px;z-index:999;background-color:transparent;border:none';


  
    btnAtt.onchange = function (e) {
        var files = e.target.files;
        var fileArr = Array.prototype.slice.call(files);

        // Check if the total selected files, including the ones already displayed, exceed 5
        if (sel_files.length + fileArr.length > 6) {
          alert('사진 5장을 초과했습니다');
          clearFileInput(btnAtt); // Clear the input field
          return;
        }

        for (f of fileArr) {
          imageLoader(f);
        }
      }

// Function to clear the input field
function clearFileInput(input) {
  input.value = ''; // Clear the input field
}

    
  
    // 탐색기에서 드래그앤 드롭 사용
    attZone.addEventListener('dragenter', function(e){
      e.preventDefault();
      e.stopPropagation();
    }, false)

    attZone.addEventListener('dragover', function(e){
      e.preventDefault();
      e.stopPropagation();
      
    }, false)
  
    attZone.addEventListener('drop', function(e){
      var files = {};
      e.preventDefault();
      e.stopPropagation();
      var dt = e.dataTransfer;
      files = dt.files;
      for(f of files){
        imageLoader(f);
      }
      
    }, false)
    

    
    /*첨부된 이미리즐을 배열에 넣고 미리보기 */
    imageLoader = function (file) {
  sel_files.push(file);
  var reader = new FileReader();
  reader.onload = function (ee) {
    let img = document.createElement('img');
    img.setAttribute('style', img_style);
    img.src = ee.target.result;

    // Add the hover effect to blur the image
    img.onmouseover = function () {
      img.style.filter = 'opacity(0.5)';
    };

    // Remove the blur effect on mouseout
    img.onmouseout = function () {
      img.style.filter = 'none';
    };

    attZone.appendChild(makeDiv(img, file));
  }

  reader.readAsDataURL(file);
}

    
    /*첨부된 파일이 있는 경우 checkbox와 함께 attZone에 추가할 div를 만들어 반환 */
    makeDiv = function(img, file){
  var div = document.createElement('div');
  div.setAttribute('style', div_style);
  
  var btn = document.createElement('input');
  btn.setAttribute('type', 'button');
  btn.setAttribute('value', 'x');
  btn.setAttribute('delFile', file.name);
  btn.setAttribute('style', chk_style);

  // Add hover effect to blur the image when hovering over the button
  btn.onmouseover = function() {
    
    img.style.filter = 'opacity(0.5)';
  };

  // Remove blur effect on mouseout
  btn.onmouseout = function() {
    img.style.filter = 'none';
  };

  btn.onclick = function(ev){
    var ele = ev.srcElement;
    var delFile = ele.getAttribute('delFile');
    for(var i=0 ;i<sel_files.length; i++){
      if(delFile== sel_files[i].name){
        sel_files.splice(i, 1);      
      }
    }
    
    dt = new DataTransfer();
    for(f in sel_files) {
      var file = sel_files[f];
      dt.items.add(file);
    }
    btnAtt.files = dt.files;
    var p = ele.parentNode;
    attZone.removeChild(p);
  }
  div.appendChild(img);
  div.appendChild(btn);
  return div;
}

  }
  

)('att_zone', 'btnAtt')
    </script>
    
</body>
</html>