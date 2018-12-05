<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>menu</title>
    <link rel="stylesheet" href="skin/css/base.css" type="text/css"/>
    <link rel="stylesheet" href="skin/css/menu.css" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <script language='javascript'>
        var curopenItem = '1';
    </script>
    <base target="main"/>
    <script language="javascript" type="text/javascript"
            src="skin/js/frame/menu.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/skin/js/jquery/jquery-1.11.3.min.js"
            charset="UTF-8"></script>
    <script type="application/javascript" charset="UTF-8">
        $(function () {
            $.ajax({
                type: "GET",
                url: "showMenu",
                dataType: "json",
                success: function (data) {
                    var count = 1;
                    for (var key in data) {
                        var li = "";
                        var dis = "none";
                        if (count == 1) {
                            dis = "block";
                        }
                        $(data[key]).each(function (index, item) {
                            li += "<li><a href='" + item.authpath + "' target='main'>" + item.authname + "</a></li>";
                        });
                        var dl = "<dl class='bitem'><dt onclick=showHide('items" + count + "_1')><b>" + key + "</b></dt>\n" +
                            "                    <dd style='display:" + dis + "' class='sitem' id=items" + count + "_1>\n" +
                            "                        <ul class='sitemu' id=" + (count - 1) + ">\n" + li +
                            "                        </ul>\n" +
                            "                    </dd>\n" +
                            "                </dl>";
                        count++;
                        $("#td").append(dl);
                    }

                }
            });
        });
    </script>

</head>
<body target="main">
<table width='99%' height="100%" border='0' cellspacing='0' cellpadding='0'>
    <tr>
        <td id="td" style='padding-left:3px;padding-top:8px' valign='top' id="menuss">

            <%-- <dl class='bitem'><dt onclick=showHide("items1_1")><b>项目管理</b></dt>
                     <dd style='display:block' class='sitem' id=items1_1>
                         <ul class='sitemu' id=0>

                         </ul>
                     </dd>
                 </dl>

             <dl class='bitem'>
                 <dt onclick=showHide('items2_1')><b>任务管理</b></dt>
                 <dd style='display:none' class='sitem' id=items2_1>
                     <ul class='sitemu' id=1>
                         <li><a href='task-add.jsp' target='main'>创建任务</a></li>
                         <li><a href='task.jsp' target='main'>任务信息</a></li>
                         <li><a href='task-my.jsp' target='main'>我的任务</a></li>
                     </ul>
                 </dd>
             </dl>

             <dl class='bitem'>
                 <dt onclick=showHide("items3_1")><b>信息箱</b></dt>
                 <dd style='display:none' class='sitem' id=items3_1>
                     <ul class='sitemu' id=2>
                         <li><a href='message-seed.jsp' target='main'>发信息</a></li>
                         <li><a href='message.jsp' target='main'>发件箱</a></li>
                         <li><a href='message-give.jsp' target='main'>收件箱</a></li>
                     </ul>
                 </dd>
             </dl>

             <dl class='bitem'>
                 <dt onclick=showHide("items4_1")><b>客户信息管理</b></dt>
                 <dd style='display:none' class='sitem' id=items4_1>
                     <ul class='sitemu' id=3>
                         <li><a href='customer.jsp' target='main'>客户信息</a></li>
                     </ul>
                 </dd>
             </dl>

             <dl class='bitem'>
                 <dt onclick=showHide("items5_1")><b>权限管理</b></dt>
                 <dd style='display:none' class='sitem' id=items5_1>
                     <ul class='sitemu' id=4>
                         <li><a href='user.jsp' target='main'>人员管理</a></li>
                         <li><a href='role.jsp' target='main'>角色管理</a></li>
                         <li><a href='resources.jsp' target='main'>菜单资源管理</a></li>
                     </ul>
                 </dd>
             </dl>

             <dl class='bitem'>
                 <dt onclick=showHide("items6_1")><b>我的信息</b></dt>
                 <dd style='display:none' class='sitem' id=items6_1>
                     <ul class='sitemu' id=5>
                         <li><a href='info.jsp' target='main'>信息查看</a></li>
                         <li><a href='modpassword.jsp' target='main'>修改密码</a></li>
                     </ul>
                 </dd>
             </dl>--%>

        </td>
    </tr>
</table>
</body>
</html>