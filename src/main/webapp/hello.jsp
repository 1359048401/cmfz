<%@page contentType="text/html;UTF-8" pageEncoding="utf-8" %>
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
        var con1 = document.getElementById("conversation1");

        var goEasy = new GoEasy({
            appkey: "BC-2b66fbf505a54de1a1ca0b060dc1be20"
        });

        goEasy.subscribe({
            channel: "testSendMessage",
            onMessage: function (message) {
                con1.append(message.content);
                con1.append("\r\n");

            }
        });

        $("#talk1").textbox({
            required: true
        });

        $("#button1").linkbutton({
            text: "发送",
            onClick: function () {
                var msg1 = document.getElementById("talk1").value;

                goEasy.publish({
                    channel: "testSendMessage",
                    message: msg1 + "   <hello>   " + new Date().toLocaleString()
                });
                $("#talk1").textbox("clear");
            }
        });

    });
</script>
<textarea id="conversation1" readonly="readonly" rows="10" cols="70"></textarea></br>
<input id="talk1">
<a id="button1"></a>
</body>
</html>
