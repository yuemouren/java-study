<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="jshead.jsp" %>
<script type="text/javascript">   
     var logdialog;//登录窗体
     var logform;//登录from
     $(function(){

    	 logform = $("#loginform").form({
    		    url:'${pageContext.request.contextPath}/servlet/AdminServlet',
    		    onSubmit: function(){
    				var isValid = $(this).form('validate');
    				if (!isValid){
    					return;
    				}
    				return isValid;	// 返回false终止表单提交
    			},
    		    // 提交表单成功,异步返回的那个信息,就是一个字符串
    			success:function(returndata){
    				
    				var nr = JSON.parse(returndata);
    				console.log(nr);
    				if(nr.message == "admin/main"){
    					$("#loginform").form("clear");
    					$("#login").dialog("close");   					
                     window.location.href="${pageContext.request.contextPath}/"+nr.message+".jsp";                  
    				}else{
    					alert("登录失败");
    					window.location.href="${pageContext.request.contextPath}/"+nr.message+".jsp";
    				} 
    			},

    	   });
     	   
     	     	     
     	   
     	  $("#login").dialog({
     		    title: 'My Dialog',    
     		    width: 400,    
     		    height: 200,    
     		    closed: false,    
     		    cache: false,    
     		    //href: 'servlet/is',    
     		    modal: true, 
     		    buttons:[{
     				text:'登录',
     				iconCls:'icon-edit',
     				handler:function(){
     					logform.submit();
     				}
     			},{
     				text:'注册',
     				iconCls:'icon-help',
     				handler:function(){
     					$("#reg").dialog("open");
     					$("#login").dialog("close");
     				}
     			}]

     	  });
     	  
     });  
</script>
</head>
<body>


    <div id="login">    
       
         <form id="loginform" style="margin: 40px;" method="post">
          		<input type="hidden" name="method"  value="Login">
               用户名<input class="easyui-textbox" id="lname" type="text" data-options="required:true" name="username"><br>
             <p>
               密码  :<input class="easyui-textbox" id="lpwd" type="text" data-options="required:true" name="password">
         </form>
     </div>

</body>
</html>