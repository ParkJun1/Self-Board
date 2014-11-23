<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- ${cri} --%>
<ul class='pagination' >	   
	<c:if test="${cri.hasBefore==true}">
		<li><a href='javascript:_goPage(${cri.startPage - 1})'>&#60</a></li>
	</c:if>
											
	<c:forEach var="page" begin="${cri.startPage}" end="${cri.endPage}">
		<li><a href='javascript:_goPage(${page})'>${page}</a></li>
	</c:forEach>
											
	<c:if test="${cri.hasNext==true}">
		<li><a href='javascript:_goPage(${cri.endPage + 1})'>&#62</a></li>
	</c:if>
</ul>