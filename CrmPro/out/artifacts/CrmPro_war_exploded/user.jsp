<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>用户管理</title>
    <link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/skin/js/jquery/jquery-1.11.3.min.js"
            charset="UTF-8"></script>
    <script type="application/javascript" charset="UTF-8">
        $(function () {
            $.ajax({
                type: "GET",
                url: "employee/getAllEmployee",
                dataType: "json",
                success: function (data) {
                    $(data).each(function (index, item) {
                        var newDate = new Date(item.hiredate);
                        var nd = newDate.getFullYear() + "年" + (newDate.getMonth() + 1) + "月" + newDate.getDate() + "日";
                        var tr = "<tr align='center' id='" + item.eid + "' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\" >\n" +
                            "\t<td><input name=\"id\" type=\"checkbox\" id='" + item.eid + "' value=\"101\" class=\"np\"></td>\n" +
                            "\t<td>" + item.eid + "</td>\n" +
                            "\t<td>" + item.ename + "</td>\n" +
                            "\t<td align=\"center\">" + item.position.name + "</td>\n" +
                            "\t<td>" + item.esex + "</td>\n" +
                            "\t<td>" + item.eage + "</td>\n" +
                            "\t<td>" + item.telephone + "</td>\n" +
                            "\t<td>" + nd + "</td>\n" +
                            "\t<td>正常</td>\n" +
                            "\t<td><a href='javascript:deleteInfo(" + item.eid + ")'>删除</a> | <a href='user-edit.jsp?eid=" + item.eid + "'>编辑</a> | <a href='user-look.jsp?eid=" + item.eid + "'>查看详情</a></td>\n" +
                            "</tr>";
                        $("#tb tr:eq(1)").after(tr);
                    })
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
                        当前位置:权限管理>>用户管理
                    </td>
                    <td>
                        <input type='button' class="coolbg np" onClick="location='user-add.jsp';" value='添加用户'/>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<!--  搜索表单  -->
<form name='form3' action='' method='get'>
    <input type='hidden' name='dopost' value=''/>
    <table width='98%' border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center"
           style="margin-top:8px">
        <tr bgcolor='#EEF4EA'>
            <td background='skin/images/wbg.gif' align='center'>
                <table border='0' cellpadding='0' cellspacing='0'>
                    <tr>
                        <td width='90' align='center'>搜索条件：</td>
                        <td width='160'>
                            <select name='cid' style='width:150px'>
                                <option value='0'>选择类型...</option>
                                <option value='1'>姓名</option>
                                <option value='1'>联系电话</option>
                            </select>
                        </td>
                        <td width='70'>
                            关键字：
                        </td>
                        <td width='160'>
                            <input type='text' name='keyword' value='' style='width:120px'/>
                        </td>
                        <td width='110'>
                            <select name='orderby' style='width:120px'>
                                <option value='id'>排序...</option>
                                <option value='pubdate'>添加时间</option>
                                <option value='pubdate'>修改时间</option>
                            </select>
                        </td>
                        <td>
                            &nbsp;&nbsp;&nbsp;<input name="imageField" type="image" src="skin/images/frame/search.gif"
                                                     width="45" height="20" border="0" class="np"/>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form>
<!--  内容列表   -->
<form name="form2">

    <table width="98%" border="0" id="tb" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center"
           style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;用户列表&nbsp;</td>
        </tr>
        <tr align="center" bgcolor="#FAFAF1" height="22">
            <td width="4%">选择</td>
            <td width="6%">序号</td>
            <td width="10%">姓名</td>
            <td width="10%">职位</td>
            <td width="10%">性别</td>
            <td width="10%">年龄</td>
            <td width="10%">联系电话</td>
            <td width="8%">入职时间</td>
            <td width="8%">状态</td>
            <td width="10%">操作</td>
        </tr>

        <%--<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
            <td><input name="id" type="checkbox" id="id" value="101" class="np"></td>
            <td>1</td>
            <td>李晓明</td>
            <td align="center">初级开发工程师</td>
            <td>男</td>
            <td>24</td>
            <td>13288888888</td>
            <td>2015-01-03</td>
            <td>正常</td>
            <td><a >删除</a> | <a href="user-edit.jsp">编辑</a> | <a href="user-look.jsp">查看详情</a></td>
        </tr>--%>


        <tr bgcolor="#FAFAF1">
            <td height="28" colspan="12">
                &nbsp;
                <a href="" class="coolbg">全选</a>
                <a href="" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="javascript:deleteBatch()" class="coolbg">删除选中</a>&nbsp;&nbsp;&nbsp;
                <a href="" class="coolbg">&nbsp;注销&nbsp;</a>
                <a href="" class="coolbg">&nbsp;导出Excel&nbsp;</a>
            </td>
        </tr>
        <tr align="right" bgcolor="#EEF4EA">
            <td height="36" colspan="12" align="center"><!--翻页代码 --></td>
        </tr>
    </table>

</form>
<script type="application/javascript">
    function deleteInfo(eid) {
        $.ajax({
            type: "GET",
            url: "employee/deleteInfo",
            data: {"eid": eid},
            dataType: "json",
            success: function (data) {
                alert(data.message);
                if (data.flag) {
                    $("#" + eid).remove();
                }
            }
        });
    }

    function deleteBatch() {
        var arr = $("input:checked");
        var newarr = new Array();
        var i = 0;
        $.each(arr, function (index, item) {
            newarr[i] = $(item).val();
            i++;
        });
        $.ajax({
            type: "GET",
            url: "employee/deleteBatchInfo?eids=" + newarr,
            //data:{"eids":newarr},
            dataType: "json",
            success: function (data) {
                alert(data.message);
                if (data.flag) {
                    $("#" + eid).remove();
                }
            }
        });
    }
</script>

</body>
</html>