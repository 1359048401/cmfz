<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        $("#bannerForm").form({
            cache: false
        });

        $("#title").textbox({
            required: true,
            type: "text"
        });
        $("#description").textbox({
            required: true
        });
        $("#status").textbox({
            required: true
        });
        $("#pub_date").datebox({
            required: true,
            editable: false,
            formatter: function (date) {
                var y = date.getFullYear();
                var m = date.getMonth() + 1;
                var d = date.getDate();
                return y + "-" + m + "-" + d;
            },
            parser: function (s) {
                var t = Date.parse(s);
                if (!isNaN(t)) {
                    return new Date(t);
                } else {
                    return new Date();
                }
            }
        });

        $("#submit").linkbutton({
            onClick: function () {
                //提交表单的操作
                $("#bannerForm").form("submit", {
                    url: "${pageContext.request.contextPath}/banner/insert",
                    onSubmit: function () {
                        return $("#bannerForm").form("validate");
                    },
                    success: function () {
                        $.messager.show({
                            title: "提示",
                            msg: "添加成功"
                        });
                        $("#addBanner").dialog("close");
                        $("#dg").edatagrid("reload");
                    }
                });
            }
        });
    });


</script>
<h1 align="center">AddBanner</h1>
<form id="bannerForm" method="post" enctype="multipart/form-data">
    <table align="center" border="1px" cellspacing="0" cellpadding="10">
        <tr>
            <td align="center">请输入标题：</td>
            <td align="center"><input id="title" name="title"/></td>
        </tr>
        <tr>
            <td align="center">请上传图片：</td>
            <td align="center"><input type="file" name="file1"/></td>
        </tr>
        <tr>
            <td align="center">请输入描述信息：</td>
            <td align="center"><input id="description" name="description"/></td>
        </tr>
        <tr>
            <td align="center">请输入上传时间：</td>
            <td align="center"><input id="pub_date" name="pub_date"/></td>
        </tr>
        <tr>
            <td align="center">请输入状态：</td>
            <td align="center"><input id="status" name="status"/></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <a id="submit">添加</a>
            </td>
        </tr>
    </table>
</form>

