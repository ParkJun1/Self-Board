<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	
</head>
<body>

	<c:if test="${reList.size() == 0}">
		<h3>등록된 댓글이 없습니다.</h3>
	</c:if>
	
	<form name="replyContentForm" >
		<c:if test="${reList.size() != 0}">
			
			<input name="rno" type="hidden" />
			<input name="bno" type="hidden" />
			<input name="replyer" type="hidden" />
			<input name="reply" type="hidden" />
			
			<c:forEach var="reply" items="${reList}">
				<c:set var="rno" value="${reply.rno}"/>
				<c:set var="bno" value="${reply.bno}"/>
				<c:set var="replyer" value="${reply.replyer}"/>
				<c:set var="regdate" value="${reply.regdate}"/>
				<c:set var="content" value="${reply.reply}"/>
					
				<h6>
					<strong>${replyer}</strong> <!-- 진하게 -->
					<small> ${regdate}</small> <!-- 작게 -->
					<strong>${rno}</strong>
				</h6>
				
				<input id="content_${rno}" type="hidden" value="${content}"/>
												
				<div id="reply_${rno}">
					<c:if test='${reply.lately < 2}'>
						<span class="label label-warning"> New </span> &nbsp;&nbsp;
					</c:if>
					${content}
				</div>
							
				<input type='button' value='수정' onclick='javascript:reUpdate(${rno})' />
				<input type='button' value='삭제' onclick="javascript:reDelete(${rno})" />
							
			</c:forEach>								
		</c:if>
	
	</form>	

</body>
</html>