<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>我的信息</title>
    <link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/skin/js/jquery/jquery-1.11.3.min.js"
            charset="UTF-8"></script>
    <script type="application/javascript" charset="UTF-8">
        $(function () {
            $.ajax({
                type: "GET",
                url: "employee/getEmployeeByEid",
                dataType: "json",
                success: function (data) {
                    console.log(data);

                    $("#ename").append(data.ename);
                    $("#esex").append(data.esex);
                    $("#eage").append(data.eage);
                    $("#telephone").append(data.telephone);
                    $("#pnum").append(data.pnum);
                    $("#remark").append(data.remark);
                    var newDate = new Date(data.hiredate);
                    var nd = newDate.getFullYear() + "年" + (newDate.getMonth() + 1) + "月" + newDate.getDate() + "日";
                    $("#hiredate").append(nd);
                    $("#posname").append(data.position.name);
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
                        当前位置:我的信息>>我的信息
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<form name="form2">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center"
           style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;我的信息&nbsp;</td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">职位：</td>
            <td align='left' id="posname" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">姓名：</td>
            <td align='left' id="ename" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">性别：</td>
            <td align='left' bgcolor="#FFFFFF" id="esex" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">年龄：</td>
            <td align='left' id="eage" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">联系电话：</td>
            <td align='left' id="telephone" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">入职时间：</td>
            <td align='left' bgcolor="#FFFFFF" id="hiredate" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">身份证号码：</td>
            <td align='left' id="pnum" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">状态：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">正常
            </td>
        </tr>

        <tr>
            <td align="right" bgcolor="#FAFAF1">备注：</td>
            <td colspan=3 align='left' id="remark" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';">

            </td>
        </tr>

    </table>

</form>


</body>
</html>