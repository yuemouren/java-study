<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="jshead.jsp" %>

<script type="text/javascript">
    //定义一个树结构的json数据
    var treeData=[{    
        "id":1,    
        "text":"Folder1",    
        "iconCls":"icon-save",    
        "children":[{    
            "text":"商品管理",    
            "state":"open",    
            "attributes":{    
                "url":"${pageContext.request.contextPath}/admin/product/list.jsp",    
                "price":100    
            },  
        },{    
            "text":"用户管理",    
            "state":"open",    
            "attributes":{    
                "url":"/demo/book/abc",    
                "price":100    
            },      
        }]    
    },{    
        "text":"订单管理",    
        "state":"closed",    
        "children":[{    
            "text":"订单详情",
            "state":"open",    
            "attributes":{    
                "url":"${pageContext.request.contextPath}/orders/getAllOrders",    
                "price":100    
            }, 
        },{    
            "text":"订单饼状图","state":"open",    
            "attributes":{    
                "url":"${pageContext.request.contextPath}/admin/order/datapic.jsp",    
                "price":100    
            },   
        }]    
    }] 
    	

    $(function(){
    	$("#mytree").tree({
    		//data:treeData,
    		url:"${pageContext.request.contextPath}/menu/createTree",
    		onClick:function(node){
    		    console.info(node.attributes);
    		    if(node.attributes){
    		    	createTab(node.text,node.attributes.url)
    		    }
    		}
    	});
    	
    });
    function createTab(text,url){ 
    	if($("#tt").tabs("exists",text)){
    		$("#tt").tabs("select",text);
    		return ;
    	}
    	//var iframe="<iframe></iframe>"
		$("#tt").tabs("add",{
			closable:true,
			title:text,
			href:url,
		});
	}
	

</script>



</head>
<body>

	<body class="easyui-layout"> 
	  
	    <div data-options="region:'north',split:true,href:'top.jsp'" style="height:100px;"></div>   
	    <div data-options="region:'south',split:true,href:'bottom.jsp'" style="height:70px;"></div>   
	    
	    <div data-options="region:'west',title:'菜单导航栏',split:true" style="width:200px;">	    
	          <ul id="mytree"></ul>	    
	    </div>   
	    <div data-options="region:'center'" style="padding:5px;background:#eee;">
	          <div id="tt" fit="true" class="easyui-tabs" style="width:500px;height:250px;">   
				    <div title="首页" style="padding:20px;display:none;">   
                           <center>
                               <font color="red">欢迎进入系统</font>
                           </center>
				    </div>   				   
              </div>   
	    </div>  

	</body>  










</body>
</html>