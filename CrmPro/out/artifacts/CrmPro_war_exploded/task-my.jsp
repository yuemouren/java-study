<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>我的任务信息</title>
    <link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/skin/js/jquery/jquery-1.11.3.min.js"
            charset="UTF-8"></script>
    <script type="application/javascript" charset="UTF-8">
        $(function () {
            $.ajax({
                type: "GET",
                url: "employee/getEmpAndTask",
                dataType: "json",
                success: function (data) {
                    console.info(data);
                    $(data.tasks).each(function (index, item) {
                        var state = "";
                        var begintask = "";
                        if (item.state == 1) {
                            state = "进行中。。。";
                            begintask = "<a href='javascript:updateState(" + item.id + ")'>任务完成</a> | ";
                        } else {
                            state = "已完成";
                        }
                        var newDate = new Date(item.starttime);
                        var start = newDate.getFullYear() + "年" + (newDate.getMonth() + 1) + "月" + newDate.getDate() + "日";
                        var newDate1 = new Date(item.endtime);
                        var end = newDate1.getFullYear() + "年" + (newDate1.getMonth() + 1) + "月" + newDate1.getDate() + "日";
                        var tr = "<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\" >\n" +
                            "\t<td><input name=\"id\" type=\"checkbox\" id=\"id\" value=\"101\" class=\"np\"></td>\n" +
                            "\t<td>" + item.id + "</td>\n" +
                            "\t<td>" + item.tasktitle + "</td>\n" +
                            "\t<td align=\"center\">" + data.ename + "</td>\n" +
                            "\t<td align=\"center\">" + state + "</td>\n" +
                            "\t<td align=\"center\">" + item.level + "</td>\n" +
                            "\t<td>" + start + "</td>\n" +
                            "\t<td>" + end + "</td>\n" +
                            "\t<td>" + begintask + "<a href=\"task-look.html\">查看详情</a></td>\n" +
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
                        当前位置:任务管理>>我的任务信息
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
                                <option value='1'>任务标题</option>
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
                                <option value='pubdate'>开始时间</option>
                                <option value='pubdate'>结束时间</option>
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

    <table width="98%" id="tb" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center"
           style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;我的任务信息&nbsp;</td>
        </tr>
        <tr align="center" bgcolor="#FAFAF1" height="22">
            <td width="4%">选择</td>
            <td width="6%">序号</td>
            <td width="10%">任务标题</td>
            <td width="10%">执行者</td>
            <td width="8%">状态</td>
            <td width="8%">优先级</td>
            <td width="8%">开始时间</td>
            <td width="8%">结束时间</td>
            <td width="15%">操作</td>
        </tr>

        <%--<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
            <td><input name="id" type="checkbox" id="id" value="101" class="np"></td>
            <td>1</td>
            <td>完成用户信息增删改查</td>
            <td align="center">某某某</td>
            <td align="center">进行中...</td>
            <td align="center">高</td>
            <td>2015-02-03</td>
            <td>2015-02-15</td>
            <td><a >开始任务</a> | <a >任务完成</a> | <a href="task-look.html">查看详情</a></td>
        </tr>--%>


        <tr bgcolor="#FAFAF1">
            <td height="28" colspan="12">
                &nbsp;
                <a href="" class="coolbg">全选</a>
                <a href="" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="" class="coolbg">&nbsp;删除&nbsp;</a>
                <a href="" class="coolbg">&nbsp;导出Excel&nbsp;</a>
            </td>
        </tr>
        <tr align="right" bgcolor="#EEF4EA">
            <td height="36" colspan="12" align="center"><!--翻页代码 --></td>
        </tr>
    </table>

</form>
<script type="application/javascript">
    function updateState(id) {
        $.ajax({
            type: "POST",
            url: "task/updateState",
            data: {"id": id, "state": 2},
            dataType: "json",
            success: function (data) {
                alert(data.message);
                if (data.flag) {
                    window.location.reload();
                }
            }
        });
    }

</script>

</body>
</html>