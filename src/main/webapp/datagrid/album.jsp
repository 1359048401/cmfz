<%@page pageEncoding="UTF-8" %>

<script type="text/javascript">
    var id = 0;
    var a;
    var toolbar = [{
        iconCls: 'icon-tip',
        text: "专辑详情",
        handler: function () {
            var row = $("#album").treegrid("getSelected");
            if (row == null) {
                $.messager.alert("警告！", "请选择您要查看的专辑名称！");
            } else if (isNaN(row.id)) {
                $.messager.alert("警告！", "请选择您要查看的专辑名称！");
            } else {
                id = row.id;
                $("#albumDetailDialog").dialog({
                    title: row.title,
                    width: 600,
                    height: 500,
                    cache: false,
                    modal: true,
                    href: "${pageContext.request.contextPath}/dialog/showAlbum.jsp"
                });
            }
        }
    }, '-', {
        text: "添加专辑",
        iconCls: 'icon-add',
        handler: function () {
            $("#addAlbumDialog").dialog("open");
        }
    }, '-', {
        text: "添加章节",
        iconCls: 'icon-add',
        handler: function () {
            var row = $("#album").treegrid("getSelected");
            if (row == null) {
                $.messager.alert("警告！", "请选择正确的专辑！");
            } else if (isNaN(row.id)) {
                $.messager.alert("警告！", "请选择正确的专辑！");
            } else {
                a = row;
                $("#addChapterDialog").dialog("open");
            }
        }
    }, '-', {
        text: "下载音频",
        iconCls: 'icon-save',
        handler: function () {
            var row = $("#album").treegrid("getSelected");
            if (row != null) {

            } else {

            }

        }
    }]
    $(function () {
        $('#album').treegrid({
            method: "POST",
            url: '${pageContext.request.contextPath}/album/queryAll',
            idField: 'id',
            treeField: 'title',
            columns: [[
                {field: 'title', title: '名字', width: 60, align: "left"},
                {field: 'url', title: '文件路径', width: 80, align: "center"},
                {field: 'duration', title: '时长', width: 80, align: "center"},
                {field: 'size', title: '大小', width: 80, align: "center"},
                {
                    field: 'play', title: "播放", align: "center",
                    formatter: function (value, row, index) {
                        if (isNaN(row.id)) {
                            return "<audio controls><source src='${pageContext.request.contextPath}" + row.url + "' type='audio/mpeg'></audio>";
                        }
                    }
                }
            ]],
            fit: true,
            fitColumns: true,
            toolbar: toolbar,
        });

        $("#addAlbumDialog").dialog({
            title: "添加专辑",
            width: 600,
            height: 500,
            cache: false,
            modal: true,
            closed: true,
            href: "${pageContext.request.contextPath}/dialog/addAlbum.jsp"
        });
        $("#addChapterDialog").dialog({
            title: "添加章节",
            width: 600,
            height: 500,
            cache: false,
            modal: true,
            closed: true,
            href: "${pageContext.request.contextPath}/dialog/addChapter.jsp"
        });
    });

</script>

<table id="album"></table>
<div id="albumDetailDialog"></div>
<div id="addAlbumDialog"></div>
<div id="addChapterDialog"></div>