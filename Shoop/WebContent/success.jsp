<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    ${message}<br>
          操作成功3秒后跳转到商城首页!
    
    <%
        //response.sendRedirect(request.getContextPath()+"/login.jsp");
        response.setHeader("Refresh", "3;url="+request.getContextPath()+"/index.jsp");
    %>
</body>
</html>