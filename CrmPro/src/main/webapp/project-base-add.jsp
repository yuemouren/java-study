<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>添加项目信息</title>
    <link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/skin/js/jquery/jquery-1.11.3.min.js"
            charset="UTF-8"></script>
    <script type="application/javascript" charset="UTF-8">
        $(function () {
            $.ajax({
                type: "GET",
                url: "customer/getAllCustomer",
                dataType: "json",
                success: function (data) {
                    $(data).each(function (index, item) {
                        var option = "<option id=" + item.companyperson + "  value=" + item.id + ">" + item.comname + "</option>";
                        $("#companyname").append(option);
                    })
                }
            });

            $.ajax({
                type: "GET",
                url: "employee/getManagerEmployee",
                dataType: "json",
                success: function (data) {
                    $(data).each(function (index, item) {
                        var option = "<option value=" + item.eid + ">" + item.ename + "</option>";
                        $("#manager").append(option);
                    })
                }
            });
        });

        function mycommit() {
            $.ajax({
                type: "POST",
                url: "project/saveProject",
                data: $("#forms").serialize(),
                dataType: "json",
                success: function (data) {
                    alert(data.message);
                    if (data.flag) {
                        window.location.href = "${pageContext.request.contextPath}/project-base.jsp";
                    }
                }
            });
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
                        当前位置:项目管理>>添加项目基本信息
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<form name="form2" id="forms" method="POST">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center"
           style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;添加新项目信息&nbsp;</td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">项目名称：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="pname"/>
            </td>
            <td align="right" bgcolor="#FAFAF1" height="22">客户公司名称：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select name="comname" id="companyname" onchange="addPer()">
                    <option>请选择客户公司名称</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">客户方负责人：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="comper"/>
            </td>
            <td align="right" bgcolor="#FAFAF1" height="22">项目经理：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select name="empFk" id="manager">
                    <option>选择项目负责人</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">开发人数：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="empcount"/>人
            </td>
            <td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="starttime"/>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">立项时间：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="buildtime"/>
            </td>
            <td align="right" bgcolor="#FAFAF1" height="22">预估成本：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="cost"/>万
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">级别：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select name="level">
                    <option value="紧急">紧急</option>
                    <option value="一般">一般</option>
                    <option value="暂缓">暂缓</option>
                </select></td>
            <td align="right" bgcolor="#FAFAF1" height="22">计划完成时间：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="endtime"/>
            </td>
        </tr>

        <tr>
            <td align="right" bgcolor="#FAFAF1">备注：</td>
            <td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';">
                <textarea type="text" rows=15 cols=130 onchange="change()" name="remark">

                </textarea>
                <span id="number"></span>
            </td>
        </tr>

        <tr bgcolor="#FAFAF1">
            <td height="28" colspan=4 align=center>
                &nbsp;
                <A class="coolbg" onclick="mycommit()">保存</A>
                <a href="project-base.jsp" class="coolbg">返回</a>
            </td>
        </tr>
    </table>

</form>

<script type="application/javascript">
    function addPer() {
        var name = $("#companyname :selected").attr("id");
        $("input[name='comper']").val(name);
    }
</script>

</body>
</html>