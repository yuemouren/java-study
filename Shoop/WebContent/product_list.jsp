<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
	width: 100%;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}
</style>
</head>

<body>


	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>


	<div class="row" style="width: 1210px; margin: 0 auto;">
        <c:forEach items="${newPro}"  var="pro">
        	<div class="col-md-2">
				<a href="servlet/ProductServlet?pid=${pro.pid}&method=getOneInfo"> 
				   <img src="/Mypic/${pro.pimage}" width="170" height="170" style="display: inline-block;">
				</a>
				<p>
					<a href="product_info.jsp" style='color: green'>${pro.pname}</a>
				</p>
				<p>
					<font color="#FF0000">商城价：&yen;${pro.shopprice}</font>
				</p>
			</div>
        </c:forEach>
	</div>

	<!--分页 -->
	<c:if test="${! empty pservice.cid}">
	<div style="width: 380px; margin: 0 auto; margin-top: 50px;">
	          当前是${pservice.currentPage}页&nbsp;&nbsp;&nbsp;&nbsp;
		<ul class="pagination" style="text-align: center; margin-top: 10px;">
	
			<li><a href="servlet/ProductServlet?currentPage=1&method=getProByCid&cid=${pservice.cid}">首页</a></li>
			
			<c:if test="${pservice.currentPage > 1}">
				<li><a href="servlet/ProductServlet?currentPage=${pservice.currentPage-1}&method=getProByCid&cid=${pservice.cid}">上一页</a></li>
			</c:if> 
			
			<c:if test="${pservice.currentPage < pservice.total}">
				<li><a href="servlet/ProductServlet?currentPage=${pservice.currentPage+1}&method=getProByCid&cid=${pservice.cid}">下一页</a></li>
			</c:if>
			
			<li><a href="servlet/ProductServlet?currentPage=${pservice.total}&method=getProByCid&cid=${pservice.cid}">尾页</a></li>	
		
		</ul>
	         共有<b>${pservice.total}</b>页

	</div> 
	</c:if>
	<c:if test="${! empty pservice.like}">
	<div style="width: 380px; margin: 0 auto; margin-top: 50px;">
	          当前是${pservice.currentPage}页&nbsp;&nbsp;&nbsp;&nbsp;
		<ul class="pagination" style="text-align: center; margin-top: 10px;">
	
			<li><a href="servlet/ProductServlet?currentPage=1&method=likeSearch&searchinfo=${pservice.like}">首页</a></li>
			
			<c:if test="${pservice.currentPage > 1}">
				<li><a href="servlet/ProductServlet?currentPage=${pservice.currentPage-1}&method=likeSearch&searchinfo=${pservice.like}">上一页</a></li>
			</c:if> 
			
			<c:if test="${pservice.currentPage < pservice.total}">
				<li><a href="servlet/ProductServlet?currentPage=${pservice.currentPage+1}&method=likeSearch&searchinfo=${pservice.like}">下一页</a></li>
			</c:if>
			
			<li><a href="servlet/ProductServlet?currentPage=${pservice.total}&method=likeSearch&searchinfo=${pservice.like}">尾页</a></li>	
		
		</ul>
	         共有<b>${pservice.total}</b>页

	</div> 
	</c:if>
	<!-- 分页结束 -->

	<!--商品浏览记录-->
	<c:if test="${!empty hisPro}">
			<div
				style="width: 1210px; margin: 0 auto; padding: 0 9px; border: 1px solid #ddd; border-top: 2px solid #999; height: 246px;">
		
				<h4 style="width: 50%; float: left; font: 14px/30px 微软雅黑 ">浏览记录</h4>
				<div style="width: 50%; float: right; text-align: right;">
					<a href="">more</a>
				</div>
				<div style="clear: both;"></div>
		
				<div style="overflow: hidden;">
					<ul style="list-style: none;">
					    <c:forEach items="${hisPro}" var="pro">
						<li style="width: 150px; height: 216; float: left; margin: 0 8px 0 0; padding: 0 18px 15px; text-align: center;"><img
							src="/Mypic/${pro.pimage}"  width="130px" height="130px" /></li>
						</c:forEach>
					</ul>
				</div>
			</div>
    </c:if>
	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>

</html>