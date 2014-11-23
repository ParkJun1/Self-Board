<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 		
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

	<h2>상세 조회 페이지</h2>
	
		<c:set var="bno" value="${bbs.bno}"/>
		<c:set var="writer" value="${bbs.writer}"/>
		<c:set var="title" value="${bbs.title}"/>
		<c:set var="publisher" value="${bbs.publisher}"/>
		<c:set var="pubyear" value="${bbs.pubyear}"/>
		<c:set var="keyword" value="${bbs.keyword}"/>
		<c:set var="regdate" value="${bbs.regdate}"/>
		<c:set var="viewcnt" value="${bbs.viewcnt}"/>
		<c:set var="isFile" value="${bbs.isFile}"/>
		<c:set var="fileList" value="${bbs.fileList}"/>
	
		<div class="bbsDetail">
		<!-- <div> -->
			<ul>
			<!-- <ul> -->
				<li class='title'>번호<li>
				<li class='content'>${bno}</li>
			</ul>
			<ul>
				<li class='title'>저자명</li>
				<li class='content'>${writer}</li>
			</ul>
			<ul>
				<li class='title'>도서명</li>
				<li class='content'>${title}</li>
			</ul>
			<ul>
				<li class='title'>출판사</li>
				<li class='content'>${publisher}</li>
			</ul>
			<ul>
				<li class='title'>출판년도</li>
				<li class='content'>${pubyear}</li>
			</ul>
			<ul>
				<li class='title'>간략정보</li>
				<li class='content'>${keyword}</li>
			</ul>
			<ul>	
				<li class='title'>등록일</li>
				<li class='content'>${regdate}</li>
			</ul>
			<ul>	
				<li class='title'>조회수!!!</li>
				<li class='content'>${viewcnt}</li>
			</ul>
			
			<ul>
				<li class='title'>첨부파일</li>
				<li class='content'>
					<c:if test="${isFile == 'F'}">없음</c:if>
					<c:if test="${isFile == 'T'}">
						<!-- <div class="attachList"> -->
							<c:forEach var="fileName" items="${fileList}">
								<%-- <div><image class='thumb' src='/file/view/${fileName}'/></div> --%>
								<a href='/file/down?src=${fileName}'>${fileName}</a>
								</br>
							</c:forEach>
						<!-- </div> -->
					</c:if>
				</li>
			</ul>
		
		</div>
		
		<hr noshade>
		<!-- 댓글.................................................................... -->		
		<div align="left" id="replyList"></div>
		
		<div>
			<form name="replyForm">
				<input name="bno" type="hidden">
				<input name="replyer" type="text" size="20" placeholder="이름">
				<input name="reply" type="text" size="100" placeholder="댓글입력">
				<input type='button' value='입력' onclick="javascript:replyInput(${bno})"/>
			</form>
		</div>

		<hr noshade>
		<div align="right">
			<strong> 댓글 갯수 : ${bbs.replycnt} </strong>
			<input type='button' value='댓글 보기' onclick="javascript:replyData(${bno})"/>
			<input type='button' value='댓글 보기(json)' onclick="javascript:jsonData(${bno})"/>
			<input type='button' value='도서 수정' onclick="javascript:updateData(${bno})"/>
			<input type='button' value='도서 삭제' onclick="javascript:deleteData(${bno})">
		</div>
