<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" src="./utf8-jsp/ueditor.all.js"></script>
<script type="text/javascript" charset="utf-8" src="./utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<style type="text/css">
        div{
            width:100%;
        }
</style>

<script type="text/javascript">
    var ue = UE.getEditor('editor');
</script>
</head>
<body>
  <form action="${pageContext.request.contextPath}/servlet/EvaluateServlet?method=saveEvaluate"  method="post">
  		<input type="hidden" name="pid"  value="${param.pid}">
  		<script id="editor"  name="upfile" type="text/plain" style="width:1024px;height:500px;"></script>
  		<input type="submit" value="提交">
  </form>
</body>
</html>