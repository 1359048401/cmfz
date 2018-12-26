<%@ page contentType="text/html;charset=UTF-8" %>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="distribution" style="width: 500px;height:300px;"></div>

<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('distribution'));

    option = {
        title: {
            text: '用户分布',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['用户数量']
        },
        visualMap: {
            min: 0,
            max: 30,
            left: 'left',
            top: 'bottom',
            text: ['高', '低'],           // 文本，默认为数值文本
            calculable: true
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },

    };
    myChart.setOption(option);
    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/user/countUserProvince",
        dataType: "JSON",
        success: function (data) {
            myChart.setOption({
                series: [
                    {
                        name: '用户数量',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        label: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        data: data.data
                    }
                ]
            });
        }
    });
</script>
