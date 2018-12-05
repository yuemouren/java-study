<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="jshead.jsp" %>

<script type="text/javascript">

     var regdialog; 
     $(function(){
    	  $("#dg").datagrid({
    		  url:"servlet/page",
    		  columns:[[ 
    			    {field:'cd',checkbox:true},
    		        {field:'id',title:'编号',width:100,align:'center'},    
    		        {field:'name',title:'名称',width:100,align:'center'},    
    		        {field:'address',title:'籍贯',width:100,align:'center'}, 
    		        {field:'hir',title:'日期',width:100,align:'center',
    		        	formatter:function(value,row,index){
    		        		//console.info(value+":"+row+":"+index);
    		        		var date = new Date(value); 
    		        		var info = date.getFullYear()+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日";
    		        		return info;
    		        	}
    		        },   		        
    		   ]],
    		   toolbar:"#tb",
    	  });

    	 
    	  
    	 
     });
     
     function show(){
    	   $("#add").dialog({
   		        width: 400,    
 	   		    height: 300,    
 	   		    title: '添加页面', 
 	   		    modal: true, 
 	   		    buttons:"#ntb",		    
   	      });
     }
     
     function add(){     	 
   	        $("#regform").form("submit",{
 		    url:'servlet/ss',
 		    onSubmit: function(){
 				var isValid = $(this).form('validate');
 				if (!isValid){
 					return;
 				}
 				return isValid;	// 返回false终止表单提交
 			},
 			success:function(returndata){  			
 				console.info(returndata);
 				//将json格式字符串转换成json对象
 				var json = JSON.parse(returndata);
 				console.info(json);
 				if(json.msg.success){
 					$("#regform").form("clear");
					$("#add").dialog("close");
 					$("#dg").datagrid("reload");  
 				}
 			},

 	   });  
     }
     
     function deleteInfo(){
    	 //获取的是我们表格中被选中行
    	 var arr = $("#dg").datagrid('getSelections');
    	 var idarr = new Array(); 
    	 var count = 0;
    	 if(arr.length==0){
    		 $.messager.alert('消息提示','至少要选择一行数据！','warning');
    		 return;
    	 }
    	 for(var i=0;i<arr.length;i++){
    		 idarr[i]=arr[i].id
    		 count++;
    	 }
    	 var ids = idarr.join(",");
    	 $.messager.confirm("确认框","您确认要删除"+count+"几条数据么?",function(r){
    		 if(r){
    			 $.ajax({
    				 type:'GET',
    				 url:'servlet/ss',
    				 data:{"ids":ids,"method":"delete"},
    				 dataType:"json",
    				 success:function(results){
    					 console.info(results);
    					 if(results.msg.success){
    						 $("#dg").datagrid("reload"); 
    					 }else{
    						 
    					 } 
    				 }
    			 });
    		 }else{
    			 return;
    		 }
    	 });
     }
     
     function update(){
    	 var arr = $("#dg").datagrid('getSelections');
    	 if(arr.length==0){
    		 $.messager.alert('消息提示','至少要选择一行数据！','warning');
    		 return;
    	 }
    	 if(arr.length>1){
    		 $.messager.alert('消息提示','只能选择一条数据更新！','warning');
    		 //取消表格中选中行
    		 $("#dg").datagrid("clearChecked");
    		 return; 
    	 }
    	 var info = arr[0];
    	 $("#update").dialog({
		        width: 400,    
 	   		    height: 300,    
 	   		    title: '添加页面', 
 	   		    modal: true, 
 	   		    buttons:"#updatetb",	
    	 });
    	 
    	 var date = new Date(info.hir);
    	 var ndate =  date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();   	 
    	 $("#updateform").form("load",{
    		 id:info.id,
    		 uname:info.name,
    		 upass:info.address,
    		 uhir:ndate,
    	 });
    	 
     }
     
     function updateInfo(){
    	  $("#updateform").form("submit",{
   		    url:'servlet/ss',
   		    onSubmit: function(){
   				var isValid = $(this).form('validate');
   				if (!isValid){
   					return;
   				}
   				return isValid;	// 返回false终止表单提交
   			},
   			success:function(returndata){  			
   				console.info(returndata);
   				//将json格式字符串转换成json对象
   				var json = JSON.parse(returndata);
   				console.info(json);
   				if(json.msg.success){
   					$("#updateform").form("clear");
  					$("#update").dialog("close");
   					$("#dg").datagrid("reload");  
   				}
   			},

   	   });   
     }
     
     
     
     
     
     
     function search(){
    	 var uname = $("#sname").textbox('getValue');	 
    	 var uaddr = $("#saddr").textbox('getValue');
    	 $("#dg").datagrid("reload",{
    		 name:uname,
    		 addr:uaddr,
    	 });
     }
     
     
     
</script>
</head>
<body>
  
	   <table id="dg" class="easyui-datagrid" fit="true" data-options="pagination:true,fitColumns:true" >	       
	   
	   </table> 
	   
          <div id="tb" style="display:flex;">      
                <a id="btn" href="javascript:show()" class="easyui-linkbutton"   data-options="iconCls:'icon-add'">添加</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                <a id="btn" href="javascript:deleteInfo()" class="easyui-linkbutton"    data-options="iconCls:'icon-remove'">删除</a>&nbsp;&nbsp;&nbsp;&nbsp; 
                <a id="btn" href="javascript:update()" class="easyui-linkbutton"    data-options="iconCls:'icon-edit'">更新</a>&nbsp;&nbsp;&nbsp;&nbsp;  
			                       姓名: <input class="easyui-textbox" id="sname" name="sname" style="width:150px"> 	
			                       籍贯: <input class="easyui-textbox" id="saddr" name="saddr" style="width:150px"> 
              
                 &nbsp;&nbsp;
                  <a id="btn" href="javascript:search()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>  
          </div>
          
          
          
        <div id="add" style="display:none">
           <form id="regform"  style="margin:40px;">
              <input type="hidden" name="method" value="add">                      
                                     用户名<input class="easyui-textbox" type="text" data-options="required:true" id="name"  name="uname" style="width:150px" ><br>
              <p>
                                     密码  :<input class="easyui-textbox" type="text" data-options="required:true" style="width:150px" id="pwd" name="upass"><br>
              <p>
                                     重复密码  :<input class="easyui-textbox" type="text" data-options="required:true"  validType="equals['#pwd']"  style="width:150px" name="rupass"><br>
              <p>
                                    入职日期:<input  id="dd"  type= "text" class= "easyui-datebox" required ="required"  name="uhir" style="width:150px" />                   
           </form>  
         </div>
         
         
         
         <div id="update" style="display:none">
	           <form id="updateform"  style="margin:40px;"> 
	               <input type="hidden" name="method" value="add">                   
	               <input type="hidden" name="id">                         
	                                     用户名<input class="easyui-textbox" type="text" data-options="required:true" id="uname"  name="uname" style="width:150px" ><br>
	               <p>
	                                     籍贯  :<input class="easyui-textbox" type="text" data-options="required:true" style="width:150px"  name="upass"><br>
	              <p>
	                                    入职日期:<input  id="dd"  type= "text" class= "easyui-datebox" required ="required"  name="uhir" style="width:150px" />                   
	           </form>  
         </div>
         
         
         <div id="updatetb">
			<a href="javascript:updateInfo()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">更新</a>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help'">取消</a>
		</div> 
         
         
         
         
        <div id="ntb">
			<a href="javascript:add()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">提交</a>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true">取消</a>
		</div> 
         
           
    </div>
          
          
  
</body>  

</html>