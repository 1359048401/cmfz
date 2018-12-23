<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        $("#addAlbumForm").form({
            cache: false
        });

        $("#album_title").textbox({
            required: true,
            type: "text"
        });
        $("#album_count").textbox({
            required: true
        });
        $("#album_score").textbox({
            required: true
        });
        $("#album_author").textbox({
            required: true
        });
        $("#album_broadcast").textbox({
            required: true
        });
        $("#album_brief").textbox({
            required: true
        });
        $("#album_pub_date").datebox({
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

        $("#album_submit").linkbutton({
            onClick: function () {
                //提交表单的操作
                $("#addAlbumForm").form("submit", {
                    url: "${pageContext.request.contextPath}/album/insert",
                    onSubmit: function () {
                        return $("#addAlbumForm").form("validate");
                    },
                    success: function () {
                        $.messager.show({
                            title: "提示",
                            msg: "添加成功"
                        });
                        $("#addAlbumDialog").dialog("close");
                        $("#dg").edatagrid("reload");
                    }
                });
            }
        });
    });


</script>
<h1 align="center">AddAlbum</h1>
<form id="addAlbumForm" method="post" enctype="multipart/form-data">
    <table align="center" border="1px" cellspacing="0" cellpadding="10">
        <tr>
            <td align="center">请输入标题：</td>
            <td align="center"><input id="album_title" name="title"/></td>
        </tr>
        <tr>
            <td align="center">请输入章节数：</td>
            <td align="center"><input id="album_count" name="count"/></td>
        </tr>
        <tr>
            <td align="center">请上传封面：</td>
            <td align="center"><input type="file" name="file2"/></td>
        </tr>
        <tr>
            <td align="center">请输入评分：</td>
            <td align="center"><input id="album_score" name="score"/></td>
        </tr>
        <tr>
            <td align="center">请输入作者：</td>
            <td align="center"><input id="album_author" name="author"/></td>
        </tr>
        <tr>
            <td align="center">请输入播音员：</td>
            <td align="center"><input id="album_broadcast" name="broadcast"/></td>
        </tr>
        <tr>
            <td align="center">请输入简介：</td>
            <td align="center"><input id="album_brief" name="brief"/></td>
        </tr>
        <tr>
            <td align="center">请输入发布时间：</td>
            <td align="center"><input id="album_pub_date" name="pub_date"/></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <a id="album_submit">添加</a>
            </td>
        </tr>
    </table>
</form>

