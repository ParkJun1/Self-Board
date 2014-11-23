<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%> <!-- sts의 jsp파일은 세션이 없어도 안만들도록 다음과같이 설정되어있다. 로그인 페이지만 필요한 것이기 때문에 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.o/resources/html4/loose.dtd">
<html>  
    <head>
		<style type="text/css">
		    div.bookdetail * {  margin: 0px; padding: 0px; }
		    div.bookdetail { border: 1px solid #d1d1d1; margin: 20px; } 
		    div.bookdetail ul { list-style: none; height: 25px; border-bottom: 1px solid #d1d1d1;}
		    div.bookdetail ul.head { background-color: #f1f1f1; font-weight: bold;  text-align: center; }   
		    div.bookdetail li { float: left; height: 25px; border-right: 1px solid #d1d1d1; text-align: center; }
		    div.bookdetail ul li.title { width: 20%; } 
		    div.bookdetail ul li.content { width: 70%; margin-left: 10px; } 
    	</style>
	</head>
	<body>
        <h3 class="box-title">도서 수정 페이지</h3>	
        	<form name='updateForm'>
		
				<c:set var="bno" value="${bbs.bno}"/>
				<c:set var="writer" value="${bbs.writer}"/>
				<c:set var="title" value="${bbs.title}"/>
				<c:set var="publisher" value="${bbs.publisher}"/>
				<c:set var="pubyear" value="${bbs.pubyear}"/>
				<c:set var="keyword" value="${bbs.keyword}"/>
				<c:set var="regdate" value="${bbs.regdate}"/>
						
				<div class="bookdetail" >
					<ul class="head">
						<li class='title'>번호<li>
						<li class='content'><input type='text' name='bno' value='${bno}' readonly></li>
					</ul>
					<ul>
						<li class='title'>저자명</li>
						<li class='content'><input type='text' name='writer' value='${writer}'></li>
					</ul>
					<ul>
						<li class='title'>도서명</li>
						<li class='content'><input type='text' name='title' value='${title}'></li>
					</ul>
					<ul>
						<li class='title'>출판사</li>
						<li class='content'><input type='text' name='publisher' value='${publisher}'></li>
					</ul>
					<ul>
						<li class='title'>출판년도</li>
						<li class='content'><input type='text' name='pubyear' value='${pubyear}'></li>
					</ul>
					<ul>
						<li class='title'>간략정보</li>
						<li class='content'><input type='text' name='keyword' value='${keyword}'></li>
					</ul>
					<ul>	
						<li class='title'>등록일</li>
						<li class='content'><input type='text' name='regdate' value='${regdate}' readonly></li>
					</ul>
				</div>
					
				<div align="right">
					<button onclick="javascript:updateActionData();">수정 완료</button>	
					<button type="reset">되돌리기</button>
					<%-- <button onclick="javascript:viewData(${bno});">취소</button> --%>	
				</div>		
			</form>
    </body>
</html>
