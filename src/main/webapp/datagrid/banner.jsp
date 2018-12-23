<%@ page contentType="text/html;charset=UTF-8" %>
<script type="text/javascript">
    $(function () {
        var toolbar = [{
            iconCls: 'icon-add',
            text: "添加",
            handler: function () {
                $("#addBanner").dialog("open");
            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-edit',
            handler: function () {
                //获取选中行
                var row = $("#dg").edatagrid("getSelected");
                if (row != null) {
                    //编辑指定行
                    var index = $("#dg").edatagrid("getRowIndex", row);
                    $("#dg").edatagrid("editRow", index);
                } else {
                    alert("请先选中行")
                }
            }
        }, '-', {
            text: "删除",
            iconCls: 'icon-remove',
            handler: function () {
                //获取选中行
                var row = $("#dg").edatagrid("getSelected");
                if (row != null) {
                    //删除指定行
                    var index = $("#dg").edatagrid("getRowIndex", row);
                    $.post("${pageContext.request.contextPath}/banner/delete?id=" + row.id,
                        function (data) {
                            console.log(data);
                            $.messager.show({
                                title: '系统提示',
                                msg: '删除成功',
                                showType: 'slide'
                            });
                            $("#dg").edatagrid("reload");
                        }
                    )
                } else {
                    alert("请先选中行")
                }
            }
        }, '-', {
            text: "保存",
            iconCls: 'icon-save',
            handler: function () {
                $("#dg").edatagrid("saveRow");
            }
        }]

        $('#dg').edatagrid({
            method: "POST",
            updateUrl: "${pageContext.request.contextPath}/banner/update",
            url: '${pageContext.request.contextPath}/banner/queryByPage',
            columns: [[
                {field: 'title', title: '名称', width: 100, align: 'center'},
                {
                    field: 'status', title: '状态', width: 100, align: 'center', editor: {
                        type: "text",
                        options: {required: true}
                    }
                },
                {field: 'img_path', title: '图片路径', width: 100, align: 'center'},
                {field: 'description', title: '图片描述', width: 100, align: 'center'},
                {field: 'pub_date', title: '上传时间', width: 100, align: 'center'}
            ]],
            fitColumns: true,
            fit: true,
            pagination: true,
            pageList: [5, 10, 15, 20],
            pageSize: 5,
            toolbar: toolbar,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.img_path + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.description + '</p>' +
                    '<p>日期: ' + rowData.pub_date + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }

        });
        $("#addBanner").dialog({
            title: "添加轮播图",
            width: 600,
            height: 300,
            cache: false,
            modal: true,
            closed: true,
            href: "${pageContext.request.contextPath}/dialog/addBanner.jsp"
        });
    });
</script>

<table id="dg"></table>
<div id="addBanner"></div>