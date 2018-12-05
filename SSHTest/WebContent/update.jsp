<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="updateOneInfo.action"  method="post">
				 <input type="hidden" name="cid" value="${computer.cid}"><br>
		电脑名称:<input type="text" name="name" value="${computer.name}"><br>
		电脑价钱:<input type="text" name="price" value="${computer.price}"><br>
		出厂日期:<input type="text" name="bir" value="${computer.bir}"><br>
	    <input type="submit" value="更新">
	</form>
</body>
</html>