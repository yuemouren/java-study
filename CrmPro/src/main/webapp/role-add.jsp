<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>添加角色</title>
    <link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/skin/js/jquery/jquery-1.11.3.min.js"
            charset="UTF-8"></script>
    <script type="application/javascript" charset="UTF-8">
        $(function () {
            $.ajax({
                type: "GET",
                url: "getAuth",
                dataType: "json",
                success: function (data) {
                    console.log(data);
                    $.each(data, function (key, value) {
                        var arr = key.split(",");
                        var xinput = "";
                        $(value).each(function (index, item) {
                            xinput += "&nbsp;&nbsp;&nbsp;<input type=\"checkbox\" value='" + item.authid + "'/>" + item.authname + "<br/>";
                        });
                        var myinput = "<input type=\"checkbox\" value='" + arr[0] + "'/>" + arr[1] + "<br/>\n" + xinput;
                        $("#td").append(myinput);
                    });
                }
            });
        });
    </script>

</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
    <tr>
        <td height="26" background="skin/images/newlinebg3.gif">
            <table width="58%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td>
                        当前位置:权限管理>>添加角色信息
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<form name="form2" id="form2">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center"
           style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;添加角色&nbsp;</td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">角色名称：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="rolename"/>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">状态：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select name="state">
                    <option value="启用">启用</option>
                    <option value="禁用">禁用</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">赋菜单资源：</td>
            <td id="td" align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="70">

                <%--<input type="checkbox"/>项目管理<br/>
                &nbsp;&nbsp;&nbsp;<input type="checkbox"/>基本信息管理<br/>
                &nbsp;&nbsp;&nbsp;<input type="checkbox"/>需求分析管理<br/>
                &nbsp;&nbsp;&nbsp;<input type="checkbox"/>模块管理<br/>
                &nbsp;&nbsp;&nbsp;<input type="checkbox"/>功能管理<br/>
                &nbsp;&nbsp;&nbsp;<input type="checkbox"/>附件管理<br/>

                <input type="checkbox"/>任务管理<br/>
                &nbsp;&nbsp;&nbsp;<input type="checkbox"/>创建任务<br/>
                &nbsp;&nbsp;&nbsp;<input type="checkbox"/>任务信息<br/>
                &nbsp;&nbsp;&nbsp;<input type="checkbox"/>我的任务<br/>--%>

            </td>
        </tr>

        <tr>
            <td align="right" bgcolor="#FAFAF1">备注：</td>
            <td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';">
                <textarea rows=10 cols=130 name="roledescription"></textarea>
            </td>
        </tr>


        <tr bgcolor="#FAFAF1">
            <td height="28" colspan=4 align=center>
                &nbsp;
                <a href="javascript:addRole()" class="coolbg">保存</a>
                <a href="role.jsp" class="coolbg">返回</a>
            </td>
        </tr>
    </table>
    <script type="application/javascript">
        function addRole() {
            var ids = "";
            $.each($('input:checkbox:checked'), function () {
                ids += $(this).val() + ",";
            });
            var s = $("#form2").serialize() + "&ids=" + ids;
            $.ajax({
                type: "POST",
                url: "role/saveRole",
                data: s,
                dataType: "json",
                success: function (data) {
                    alert(data.message);
                    if (data.flag) {
                        window.location.href = "${pageContext.request.contextPath}/role.jsp";
                    }
                }
            });
        }

    </script>
</form>


</body>
</html>