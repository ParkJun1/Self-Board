<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%> <!-- sts의 jsp파일은 세션이 없어도 안만들도록 다음과같이 설정되어있다. 로그인 페이지만 필요한 것이기 때문에 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.o/resources/html4/loose.dtd">
<html>
    <head>
 		<style type="text/css">
		   
		    .attachList div {
		    	margin-right: 10px;
		    	float: left;
		    }
		    
		   	.attachList div .thumb {
				width: 100px;
				height: 100px;
			} <%--thumbnail이미지사용을 안하고 출력되는 이미지의 크기를 모두 css로적용--%>
			
	    </style> 
	
    </head>
    <body>
     	<div align="center">
	    	<form name='addForm'>
	    		<input type="hidden" name="fileList">
				<li> <label>서명</label> <input type="text" name="title"> </li>
				<li> <label>저자 </label> <input type="text" name="writer"> </li>
				<li> <label>출판사 </label> <input type="text" name="publisher"> </li>
				<li> <label>출판년도</label> <input type="text" name="pubyear"> </li>
				<li> <label>간략설명</label> <input type="text" name="keyword"> </li>
				<p></p>					
			</form>
			
			<li>
				<label>파일첨부</label>
				<form target="zero" action="/file/upload" method="post" enctype="multipart/form-data" >
					<input type='file' name='file'><input type='submit' value="업로드">
				</form>
			</li>
			
			<div class="attachList" ></div>
				
			<iframe name="zero" width="0" height="0" ></iframe>
		</div>
		
		<div align="right">
			<button onclick="javascript:writeActionData();">등록 완료</button>
			<button onclick="javascript:before();">취소</button>	
		</div>

    </body>
</html>
