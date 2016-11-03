<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("newLine", "\n");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/insert" method="post">
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
		</tr>
	</table>
	</form>
	<c:set var="count" value="${fn:length(list) }"/> 
	<c:forEach items="${list }" var="vo" varStatus="status">
	<table width=510 border=1>
		<tr>
			<td>[${count-status.index }]</td>
			<td>[${vo.no }]</td>
			<td>[${vo.name }]</td>
			<td>[${vo.reg_date }]</td>
			<td rowspan=2>
			<!-- <form action="${pageContext.request.contextPath }/deleteform/${vo.no }" method="post"> -->
			<form action="${pageContext.request.contextPath }/deleteform" method="post">
				<input type=hidden value='${vo.no }' name=no>
				<input type="submit" value="삭제">			
			</form>
			</td>
		</tr>
		<tr>
			<td colspan=4>${fn:replace(vo.content, newLine, "<br>")}</td>
		</tr>
	</table>
	</c:forEach>
</body>
</html>