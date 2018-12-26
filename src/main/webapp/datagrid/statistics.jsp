<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<title>用户活跃度统计</title>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 500px;height:300px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '用户活跃度统计'
        },
        tooltip: {},
        legend: {
            data: ['活跃数']
        },
        xAxis: {
            data: ["近一周", "近两周", "近三周"]
        },
        yAxis: {},
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/user/selectNum",
        dataType: "JSON",
        success: function (data) {
            myChart.setOption({
                series: [{
                    name: "活跃度",
                    data: data.data,
                    type: "bar"
                }]
            });
        }
    });
</script>
