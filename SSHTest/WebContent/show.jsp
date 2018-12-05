<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		show(1,3);
	});
</script>
</head>
<body>
	<table border="1" id="tb">
		<tr>
			<th><a href="javascript:selectAll()">全选</a> <a
				href="javascript:deleteInfo()">批量删除</a></th>
			<th>编号</th>
			<th>电脑型号</th>
			<th>价钱</th>
			<th>出厂日期</th>
			<th>其他</th>
		</tr>
		
	</table>
	<script type="text/javascript">
		
		function deleteOne(cid){
			$.ajax({
				type : 'POST',
				url : 'deleteOneInfo.action',
				data:{"cid":cid},
				dataType : 'json',
				success : function(data) {
					if(data.flag){
						$("#"+cid).remove();
						alert(data.message);
					}else{
						alert(data.message);
					}
					
				}
			});
		}
		 function selectAll(){
			 if( $("input[type='checkbox']").prop("checked")){
				 $("input[type='checkbox']").prop("checked", false);
			 }else{
				 $("input[type='checkbox']").prop("checked", true); 
			 }
		 }
		function deleteInfo(){
			 var arr = $("input:checked");
			 var newarr = new Array();
			 var index=0;
			 for(var i=0;i<arr.length;i++){
				 newarr[index] = $(arr[i]).val();
				 index++;
			 }
			 var ids=newarr.join(",");
			 $.ajax({
					type:'POST',
					url:'deleteBatchInfo.action',
					data:{"ids":ids},
					dataType:'json',
					success:function(data){
						if(data.flag){
							alert(data.message);
							for(var i=0;i<newarr.length;i++){
								$("#"+newarr[i]).remove();
							}
						}else{
							alert(data.message);
						}
					}
				}); 
		}
		function updateOne(cid){
			window.location.href="getOneInfo.action?cid="+cid;
		}
		function  show(currentPage,perPageRows) {
			$("tr:gt(0)").remove();
			$.ajax({
				type : 'POST',
				url : 'getAllInfo.action',
				data:{"currentPage":currentPage,"perPageRows":perPageRows},
				dataType : 'json',
				success : function(data) {
					$(data.computer).each(function(index, item) {
										var tr = "<tr id="+item.cid+"><td><input type='checkbox' name='id' value='"+item.cid+"'></td><td>"
												+ item.cid
												+ "</td><td>"
												+ item.name
												+ "</td><td>"
												+ item.price
												+ "</td><td>"
												+ item.bir
												+ "</td><td><a href='javascript:deleteOne("
												+ item.cid
												+ ")'>删除</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:updateOne("+item.cid+")'>修改</a></td></tr>";
										$("#tb").append(tr);
				     });
					
					var tr1 = "<tr><td>当前是第"+data.page.currentPage+"页</td><td><a href='javascript:show(1,"+(data.page.perPageRows)+")'>首页</a></td>";
					
					if(data.page.currentPage != 1){
						var tr2 ="<td><a href='javascript:show("+(data.page.currentPage-1)+","+(data.page.perPageRows)+")'>上一页</a></td>";
					}else{
						var tr2 ="<td></td>";
					}
					if(data.page.currentPage != data.page.totalPages){
						var tr3 ="<td><a href='javascript:show("+(data.page.currentPage+1)+","+(data.page.perPageRows)+")'>下一页</a></td>";
					}else{
						var tr3 ="<td></td>";
					}
				    var tr4 ="<td><a href='javascript:show("+data.page.totalPages+"),"+(data.page.perPageRows)+"'>尾页</a></td><td>共有"+data.page.totalPages+"页</td></tr>";
					
				    var tr5 = tr1+tr2+tr3+tr4;
				    
				    $("#tb").append(tr5);
				}
			});
		}
		
	</script>
</body>
</html>