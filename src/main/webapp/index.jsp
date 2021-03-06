<%@page contentType="text/html;Utf-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="themes/icon.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>
</head>
<body>
<script type="text/javascript">
    $(function () {
        var con2 = document.getElementById("conversation2");

        var goEasy = new GoEasy({
            appkey: "BC-2b66fbf505a54de1a1ca0b060dc1be20"
        });

        goEasy.subscribe({
            channel: "testSendMessage",
            onMessage: function (message) {
                con2.append(message.content);
                con2.append("\r\n");
            }
        });

        $("#talk2").textbox({
            required: true
        });

        $("#button2").linkbutton({
            text: "发送",
            onClick: function () {
                var msg2 = document.getElementById("talk2").value;

                goEasy.publish({
                    channel: "testSendMessage",
                    message: msg2 + "   <index>   " + new Date().toLocaleString()
                });
                $("#talk2").textbox("clear");
            }
        });

    });
</script>
<textarea id="conversation2" rows="10" cols="70" readonly="readonly"></textarea></br>
<input id="talk2">
<a id="button2"></a>
</body>
</html>
