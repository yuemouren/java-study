<%@ page language="java"  contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>	
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

.container .row div {
	/* position:relative;
				 float:left; */
	
}

font {
	color: #666;
	font-size: 22px;
	font-weight: normal;
	padding-right: 17px;
}
</style>

<script type="text/javascript" charset="UTF-8">

      function cimg(obj){
    	  obj.src="servlet/CodeServlet?time="+Math.random();
      }

      
      function check(obj){
    	  if(obj.username.value!=""&&obj.password.value!=""&&obj.code.value!=""){
    		  return true;
    	  }
    	   return false;
      }
      function addrem(){
    	  $("#rem").prop("checked",true);
      }
      function loginInfo(){
    	  $.ajax({
    		  type:"post",
    		  url:"servlet/UserServlet",
    		  data:$('#myform').serialize(),
    		  dataType:"json",
    		  success:function(data){
    			  if(data.flag){
    				  window.location.href="index.jsp";
    			  }else{
    				  alert(data.message);
    			  }
    		  }
    	  });
      }
</script>
      

</head>
<body>
	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>
  	<c:if test="${!empty cookie}">
		<c:forEach items="${cookie}" var="cook">
			<c:if test="${cook.value.name eq 'activeInfo'}">
				<c:set value="${cook.value.value}" var="value" scope="request"></c:set>
			</c:if>
			<c:if test="${cook.value.name  eq 'autoLogin'}">
				<c:set value="${cook.value.value}" var="login" scope="request"></c:set>
			</c:if>
		</c:forEach>
	</c:if>
	
	<c:if test="${!empty value}">
		<c:set value="${fn:split(value,':')}" var="info" scope="request"></c:set>
		<c:set value="checked" var="check1" scope="request"></c:set>
	</c:if>
	<c:if test="${empty value}">
		<c:set value="" var="check1" scope="request"></c:set>
	</c:if>
	<c:if test="${!empty login}">
		<c:set value="checked" var="check2" scope="request"></c:set>
	</c:if>
	<c:if test="${empty login}">
		<c:set value="" var="check2" scope="request"></c:set>
	</c:if>
	<%-- <%
		String value="";
		String login="";
		String check1="";
		String check2="";
		Cookie[] cookie = request.getCookies();
		for(Cookie cook:cookie){
			if("activeInfo".equals(cook.getName())){
				value = cook.getValue();
			}
			if("autoLogin".equals(cook.getName())){
				login = cook.getValue();
			}
		}
		String[] info = {"",""};
		if(value.length() > 0){
			info = value.split(":");
			check1="checked";
		}else{
			check1="";
		}
		if("true".equals(login)){
			check2="checked";
		}else{
			check2="";
		}
		
	%> --%>
	
	<div class="container"
		style="width: 100%; height: 460px; background: #FF2C4C url('images/loginbg.jpg') no-repeat;">
		<div class="row">
			<div class="col-md-7">
				<!--<img src="./image/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">-->
			</div>

			<div class="col-md-5">
				<div
					style="width: 440px; border: 1px solid #E7E7E7; padding: 20px 0 20px 30px; border-radius: 5px; margin-top: 60px; background: #fff;">
					<font>会员登录</font>USER LOGIN
					<div>&nbsp;</div>
					<!-- action="${pageContext.request.contextPath}/servlet/UserServlet" -->
					<form class="form-horizontal" onsubmit="return check(this)" method="post" id="myform">						
						<input type="hidden" name="method" value="login">						
						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="username" value="${info[0]}"  name="username"
									placeholder="请输入用户名">
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-6"> 
								<input type="text" class="form-control" id="inputPassword3" name="password" value="${info[1]}"  placeholder="请输入密码">
							    
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">验证码</label>
							<div class="col-sm-6"> 
								<input type="text" class="form-control" id="code" name="code"
									placeholder="请输入验证码">
									
									<img src="${pageContext.request.contextPath }/servlet/CodeServlet" id="img" onclick="cimg(this)">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="checkbox">
									<label> <input type="checkbox" name="autoLogin" value="autoLogin" onclick="addrem()" ${check2} > 自动登录
									</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label>																 
									    <input type="checkbox" id="rem" name="rem" value="rem" ${check1} > 记住用户名						
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="button" width="100" value="登录" name="submit"  onclick="loginInfo()"
 									style="background: url('./images/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>