<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        $("#albumDetailForm").form("load", "${pageContext.request.contextPath}/album/queryById?id=" + id);


        $("#yes").linkbutton({
            onClick: function () {
                $("#albumDetailDialog").dialog("close");
            }
        });

        $("#al_pub_date").textbox({
            required: true,
            readonly: true
        });

        $("#albumDetailForm").form({onLoadSuccess: loadSuccess})

    });

    function loadSuccess(data) {
        console.log(data);
        $("#cover_img").prop("src", "${pageContext.request.contextPath}" + data.cover_img);
    }

</script>
<h1 align="center">AlbumDetail</h1>
<form id="albumDetailForm">
    <table align="center" border="1px" cellspacing="0" cellpadding="10">
        <tr>
            <td align="center">标题：</td>
            <td align="center"><input id="al_title" name="title"/></td>
        </tr>
        <tr>
            <td align="center">章节数：</td>
            <td align="center"><input id="count" name="count"/></td>
        </tr>
        <tr>
            <td align="center">封面图片：</td>
            <td align="center"><input type="image" id="cover_img"/></td>
        </tr>
        <tr>
            <td align="center">评分：</td>
            <td align="center"><input id="score" name="score"/></td>
        </tr>
        <tr>
            <td align="center">作者：</td>
            <td align="center"><input id="author" name="author"/></td>
        </tr>
        <tr>
            <td align="center">播音员：</td>
            <td align="center"><input id="broadcast" name="broadcast"/></td>
        </tr>
        <tr>
            <td align="center">简介：</td>
            <td align="center"><input id="brief" name="brief"/></td>
        </tr>
        <tr>
            <td align="center">发布时间：</td>
            <td align="center"><input id="al_pub_date" name="pub_date"/></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <a id="yes">确定</a>
            </td>
        </tr>
    </table>
</form>