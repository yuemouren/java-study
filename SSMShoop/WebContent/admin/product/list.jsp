<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
<%@ include file="/admin/jshead.jsp" %>      		
<script type="text/javascript">
    $(function(){
    	$("#DataGrid1").datagrid({
    		url:"${pageContext.request.contextPath}/product/getAllPro",
    		columns:[[    
    		   {field:'pid',title:'商品编号',width:100,align:'center'},    
    		   {field:'pname',title:'商品名称',width:100,align:'center'},    
    		   {field:'shopprice',title:'商城价格',width:100,align:'center'},
    		   {field:'pimage',title:'商品图片',width:100,align:'center',
    			   formatter: function(value,row,index){
    				  
    				   //将我们的毫秒值转换成时间对象 
    				   // http://localhost:8080/BB/products/1/c_0001.jpg
    				   return "<img width='50px' height='50px' src='/Mypic/"+value+"'/>";
    				}
    		   },
    		   
    		  /*  {field:'pdate',title:'上架时间',width:100,align:'center',
    			   formatter: function(value,row,index){
    				  
    				   //将我们的毫秒值转换成时间对象
    				   var date = new Date(value);
    				   return date.getFullYear()+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日";
    				}
    		   } */
    		]],
    		fitColumns:true,
    		pagination:true,
    		toolbar:"#tb"
    	});
    	
    	
    });
    
    
    function update(){
	   	 var arr = $("#DataGrid1").datagrid('getSelections');
	   	 if(arr.length==0){
	   		 $.messager.alert('消息提示','至少要选择一行数据！','warning');
	   		 return;
	   	 }
	   	 if(arr.length>1){
	   		 $.messager.alert('消息提示','只能选择一条数据更新！','warning');
	   		 //取消表格中选中行
	   		 $("#DataGrid1").datagrid("clearChecked");
	   		 return; 
	   	 }
	   	 // info  就是我们选中的那条数据
	   	 var info = arr[0];
	   	 $("#update").dialog({
			 width: 400,    
		   	 height: 300,    
		   	 title: '更新页面', 
		   	 modal: true, 
		   	 buttons:"#updatetb",	
	   	 });
	   	 
	     var date = new Date(info.pdate);
	   	 var ndate =  date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();   	 
	   	 alert(info.pimage+"=====================");
	   	 $("#updateform").form("load",{
	   		 pid:info.pid,
	   		 pname:info.pname,
	   		 shopprice:info.shopprice,
	   		 pdate:ndate,
	   	 });  	 
    }
    
    
    //将更新后的表单提交给我们的服务器
    function updateInfo(){
  	  $("#updateform").form("submit",{
 		    url:'${pageContext.request.contextPath}/updateProInfo',
 		    //表单的校验不通过name停止表单提交
 		    /* onSubmit: function(){
 				var isValid = $(this).form('validate');
 				if (!isValid){
 					return;
 				}
 				return isValid;
 			}, 
 			*/
 			success:function(returndata){  			 				
 				if(returndata == "true"){
 					$("#updateform").form("clear");
					$("#update").dialog("close");
					//刷新当前数据表格
 					$("#DataGrid1").datagrid("reload");  
 				}
 			},

 	   });   
   }
    
    
    

</script>
</HEAD>
<body>
	<br>
	
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>商品列表</strong>
					</TD>
				</tr>
				<%-- <tr>
					<td class="ta_01" align="right">
					   <a href="${pageContext.request.contextPath}/admin/product/add.jsp">添加</a>
					</td>
				</tr> --%>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
					
					    <!--  使用easyui的异步的数据  放入到我们的这个table标签中 -->
					    
						<table  cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">

						</table>

					</td>
				</tr>

			</TBODY>
		</table>
		
		 <div id="tb" style="display:flex;">      
               
                <a id="btn" href="javascript:deleteInfo()" class="easyui-linkbutton"    data-options="iconCls:'icon-remove'">删除</a>&nbsp;&nbsp;&nbsp;&nbsp; 
                <a id="btn" href="javascript:update()" class="easyui-linkbutton"    data-options="iconCls:'icon-edit'">更新</a>&nbsp;&nbsp;&nbsp;&nbsp;  
                <a id="btn" href="${pageContext.request.contextPath}/admin/product/add.jsp" class="easyui-linkbutton"    data-options="iconCls:'icon-edit'">添加</a>&nbsp;&nbsp;&nbsp;&nbsp;  
			                       商品名称: <input class="easyui-textbox" id="sname" name="sname" style="width:150px"> 	
			                       商品价格: <input class="easyui-textbox" id="saddr" name="saddr" style="width:150px"> 
              
                 &nbsp;&nbsp;
                  <a id="btn" href="javascript:search()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>  
          </div>
          
          <!--  弹出更新的框 -->
		  <div id="update" style="display:none">
	           <form id="updateform"  style="margin:40px;"> 
	                <!--  隐藏了id值 -->                
	               <input type="hidden" name="pid">                         
	                                     商品名称<input class="easyui-textbox" type="text" data-options="required:true" id="uname"  name="pname" style="width:150px" ><br>
	               <p>
	                                     商品价格:<input class="easyui-textbox" type="text" data-options="required:true" style="width:150px"  name="shopprice"><br>
	               <p>
	                                     上架日期:<input  id="dd"  type= "text" class= "easyui-datebox" required ="required"  name="pdate" style="width:150px" /> 
	               <!--  
	               <p>                     
	                                     商品图片:<input class="easyui-filebox" style='width:300px' name="pimage"><br> -->
	           </form>  
          </div>
		
		   <!--  更新按钮 -->
		  <!--  <div id="updatetb">
				<a href="javascript:updateInfo()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">更新</a>
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help'">取消</a>
		   </div>  -->
</body>
</HTML>

