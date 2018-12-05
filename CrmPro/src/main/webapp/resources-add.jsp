<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>添加菜单资源</title>
    <link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/skin/js/jquery/jquery-1.11.3.min.js"
            charset="UTF-8"></script>
    <script type="application/javascript" charset="UTF-8">
        $(function () {
            $("#path").hide();
            $("#par").hide();
        });

        function addSelect(obj) {
            if (obj == "open") {
                $("#par").hide();
                $("#path").hide();
            } else {
                $("#par").show();
                $("#path").show();
                $.ajax({
                    type: "GET",
                    url: "getParentMenu",
                    dataType: "json",
                    success: function (data) {
                        $("#par").html("<option>请选择父菜单</option>");
                        $(data).each(function (index, item) {
                            var option = "<option value='" + item.authid + "'>" + item.authname + "</option>"
                            $("#par").append(option);
                        });
                    }
                });
            }
        }
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
                        当前位置:权限管理>>添加菜单资源
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
            <td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;添加菜单资源&nbsp;</td>
        </tr>

        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">菜单资源名称：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="authname"/>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">父菜单：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select name="state" id="se" onchange="addSelect(this.value)">
                    <option>请选择菜单</option>
                    <option value="open">顶级菜单</option>
                    <option value="close">项目管理</option>
                </select>-
                <select name="parentid" id="par">
                    <option value="">请选择父菜单</option>
                    <%--<option value="open">顶级菜单</option>
                    <option value="close">项目管理</option>--%>
                </select>
            </td>
        </tr>
        <tr id="path">
            <td align="right" bgcolor="#FAFAF1" height="22">菜单资源路径：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="authpath"/>
            </td>
        </tr>

        <tr>
            <td align="right" bgcolor="#FAFAF1">备注：</td>
            <td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';">
                <textarea rows=10 cols=130 name="remark"></textarea>
            </td>
        </tr>


        <tr bgcolor="#FAFAF1">
            <td height="28" colspan=4 align=center>
                &nbsp;
                <a href="javascript:addAuth()" class="coolbg">保存</a>
                <a href="resources.jsp" class="coolbg">返回</a>
            </td>
        </tr>
    </table>

</form>
<script type="application/javascript">
    function addAuth() {
        $.ajax({
            type: "POST",
            url: "saveAuth",
            data: $("#form2").serialize(),
            dataType: "json",
            success: function (data) {
                alert(data.message);
                if (data.flag) {
                    window.location.href = "${pageContext.request.contextPath}/resources.jsp";
                }
            }
        });
    }
</script>

</body>
</html>