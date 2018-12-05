<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>创建任务</title>
    <link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/skin/js/jquery/jquery-1.11.3.min.js"
            charset="UTF-8"></script>
    <script type="application/javascript" charset="UTF-8">
        $(function () {
            $.ajax({
                type: "GET",
                url: "project/getAllProject",
                dataType: "json",
                success: function (data) {
                    $(data).each(function (index, item) {
                        var option = "<option  value=" + item.pid + ">" + item.pname + "</option>";
                        $("#projectname").append(option);
                    })
                }
            });
        });

        $.ajax({
            type: "GET",
            url: "employee/getManagerEmployee",
            data: {"eid": 1},
            dataType: "json",
            success: function (data) {
                $(data).each(function (index, item) {
                    var option = "<option value=" + item.eid + ">" + item.ename + "</option>";
                    $("#performer").append(option);
                })
            }
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
                        当前位置:任务管理>>创建任务
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<form name="form2" id="form2" method="post">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center"
           style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;创建任务&nbsp;</td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">参考位置：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select name="proname" id="projectname" onchange="addAnalysisAndModule(this.value)">
                    <option>请选择项目</option>
                </select>-
                <select id="anal" name="analname">
                    <option>请选择需求</option>
                </select>-
                <select id="md" name="modulename" onchange="addFunction(this.value)">
                    <option>请选择模块</option>
                </select>-
                <select id="fun" name="funFk">
                    <option>请选择功能</option>
                </select></td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">任务标题：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="tasktitle"/>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="starttime"/>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">结束时间：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="endtime"/>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">执行者：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select id="performer" name="empFk2">
                    <option>请选择执行者</option>
                </select></td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">优先级：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select name="level">
                    <option value="高">高</option>
                    <option value="中">中</option>
                    <option value="低">低</option>
                    <option value="暂缓">暂缓</option>
                </select>
            </td>
        </tr>

        <tr>
            <td align="right" bgcolor="#FAFAF1">详细说明：</td>
            <td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';">
                <textarea rows=10 cols=130 name="remark"></textarea>
            </td>
        </tr>


        <tr bgcolor="#FAFAF1">
            <td height="28" colspan=4 align=center>
                &nbsp;
                <a href="javascript:addTask()" class="coolbg">保存</a>
            </td>
        </tr>
    </table>

</form>
<script type="application/javascript">

    function addAnalysisAndModule(pid) {
        $.ajax({
            type: "GET",
            url: "analysis/getAnalAndMod",
            data: {"pid": pid},
            dataType: "json",
            success: function (data) {
                $("#anal").html("<option>请选择需求</option>");
                $("#md").html("<option>请选择模块</option>");
                $("#anal").append("<option  value=" + data.id + " selected>" + data.title + "</option>");
                $(data.modules).each(function (index, item) {
                    var option = "<option  value=" + item.id + ">" + item.modname + "</option>";
                    $("#md").append(option);
                })
            }
        });
    }

    function addFunction(modeleFk) {
        $.ajax({
            type: "POST",
            url: "function/getFunByModeleFk",
            data: {"modeleFk": modeleFk},
            dataType: "json",
            success: function (data) {
                $("#fun").html("<option>请选择功能</option>");
                $(data).each(function (index, item) {
                    var option = "<option  value=" + item.id + ">" + item.functionname + "</option>";
                    $("#fun").append(option);
                })
            }
        });
    }

    function addTask() {
        $.ajax({
            type: "POST",
            url: "task/saveTask",
            data: $("#form2").serialize(),
            dataType: "json",
            success: function (data) {
                alert(data.message);
                if (data.flag) {
                    window.location.href = "${pageContext.request.contextPath}/task.jsp";
                }
            }
        });
    }
</script>
</body>
</html>