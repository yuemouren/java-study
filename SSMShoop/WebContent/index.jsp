<%@ page language="java"  pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>优就业商城首页</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(function(){
				$.ajax({
					type:'GET',
					url:'product/getIndex',
					dataType:'json',
					success:function(data){
						$(data.hot).each(function(index,item){
							var div = "<div class='col-md-2' style='text-align:center;height:200px;padding:10px 0px;'><a href='product/getPro?pid="+item.pid+"'><img src='/Mypic/"+item.pimage+"' width='130' height='130' style='display: inline-block;'></a><p><a href='servlet/ProductServlet?pid="+item.pid+"&method=getOneInfo' style='color:#666'>"+item.pname+"</a></p><p><font color='#E4393C' style='font-size:16px'>&yen;"+item.shopprice+"</font></p></div>";
							$("#hot").append(div);
						});
						$(data.newPro).each(function(index,item){
							var div = "<div class='col-md-2' style='text-align:center;height:200px;padding:10px 0px;'><a href='product/getPro?pid="+item.pid+"'><img src='/Mypic/"+item.pimage+"' width='130' height='130' style='display: inline-block;'></a><p><a href='servlet/ProductServlet?pid="+item.pid+"&method=getOneInfo' style='color:#666'>"+item.pname+"</a></p><p><font color='#E4393C' style='font-size:16px'>&yen;"+item.shopprice+"</font></p></div>";
							$("#new").append(div);
						})
					}
				});
				
			});
		</script>
	</head>

	<body>
		<div class="container-fluid">

			<!-- 引入header.jsp -->
			<jsp:include page="/header.jsp"></jsp:include>

			<!-- 轮播图 -->
			<div class="container-fluid">
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					<!-- 轮播图的中的小点 -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>
					<!-- 轮播图的轮播图片 -->
					<div class="carousel-inner" style="width:100%;height:500px" role="listbox">
						<div class="item active">
							<img src="img/1.jpg">
							<div class="carousel-caption">
								<!-- 轮播图上的文字 -->
							</div>
						</div>
						<div class="item">
							<img src="img/2.jpg">
							<div class="carousel-caption">
								<!-- 轮播图上的文字 -->
							</div>
						</div>
						<div class="item">
							<img src="img/3.jpg">
							<div class="carousel-caption">
								<!-- 轮播图上的文字 -->
							</div>
						</div>
					</div>

					<!-- 上一张 下一张按钮 -->
					<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			
			<!-- 热门商品 -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>热门商品&nbsp;&nbsp;<img src="img/title2.jpg"/></h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
					<img src="/Mypic/products/hao/big01.PNG" width="259" height="404" style="display: inline-block;"/>
				</div>
				<div class="col-md-10" id="hot">
					<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
						<a href="/Mypic/product_info.htm">
							<img src="/Mypic/products/hao/12.PNG" width="520px" height="200px" style="display: inline-block;">
						</a>
					</div>

					<!-- 循环数据库中的热门商品的结果 -->
				
						<%-- <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
							<a href="product_info.jsp">
								<img src="${pageContext.request.contextPath }/products/1/c_0001.jpg" width="130" height="130" style="display: inline-block;">
							</a>
							<p><a href="product_info.jsp" style='color:#666'>华为手机</a></p>
							<p><font color="#E4393C" style="font-size:16px">&yen;333</font></p>
						</div> --%>
						

					
				</div>
			</div>
			
			<!-- 广告条 -->
            <div class="container-fluid">
				<img src="/Mypic/products/hao/kk.PNG" width="100%"/>
			</div>
			
			<!-- 最新商品 -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>最新商品&nbsp;&nbsp;<img src="img/title2.jpg"/></h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
					<img src="/Mypic/products/hao/22.PNG" width="259" height="404" style="display: inline-block;"/>
				</div>
				<div class="col-md-10" id="new">
					<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
						<a href="product_info.htm">
							<img src="/Mypic/products/hao/13.PNG" width="525px" height="200px" style="display: inline-block;">
						</a>
					</div>									
				     <!-- 获取我们数据库中的最新商品信息  -->
				     <!--  域对象中存放数据的时候key不要使用java关键字 -->
					   <%--  <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
							<a href="product_info.jsp">
								<img src="${pageContext.request.contextPath }/products/1/c_0001.jpg" width="130" height="130" style="display: inline-block;">
							</a>
							<p><a href="product_info.jsp" style='color:#666'>华为手机</a></p>
							<p><font color="#E4393C" style="font-size:16px">&yen;333</font></p>
						</div> --%>
						
									
				</div>
			</div>			
			
			<!-- 引入footer.jsp -->
			<jsp:include page="/footer.jsp"></jsp:include>
			
		</div>
	</body>

</html>