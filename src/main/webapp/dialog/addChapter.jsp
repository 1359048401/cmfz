<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {

        $("#addAlbumForm").form({
            cache: false
        });

        $("#chapter_title").textbox({
            required: true,
            type: "text"
        });
        $("#a_title").textbox({
            required: true,
            readonly: true,
            value: a.title,
            type: "text"
        });
        $("#chapter_file").filebox();
        $("#chapter_upload_date").datebox({
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

        $("#chapter_submit").linkbutton({
            onClick: function () {
                //提交表单的操作
                $("#addChapterForm").form("submit", {
                    url: "${pageContext.request.contextPath}/chapter/insert?a_id=" + a.id,
                    onSubmit: function () {
                        return $("#addChapterForm").form("validate");
                    },
                    success: function () {
                        $.messager.show({
                            title: "提示",
                            msg: "添加成功"
                        });
                        $("#addChapterDialog").dialog("close");
                        $("#dg").edatagrid("reload");
                    }
                });
            }
        });
    });

</script>
<h1 align="center">AddAlbum</h1>
<form id="addChapterForm" method="post" enctype="multipart/form-data">
    <table align="center" border="1px" cellspacing="0" cellpadding="10">
        <tr>
            <td align="center">请输入标题：</td>
            <td align="center"><input id="chapter_title" name="title"/></td>
        </tr>
        <tr>
            <td align="center">请上传章节：</td>
            <td align="center"><input id="chapter_file" name="file3"/></td>
        </tr>
        <tr>
            <td align="center">请选择上传时间：</td>
            <td align="center"><input id="chapter_upload_date" name="upload_date"/></td>
        </tr>
        <tr>
            <td align="center">上传到的专辑</td>
            <td align="center"><input id="a_title"/></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <a id="chapter_submit">添加</a>
            </td>
        </tr>
    </table>
</form>

