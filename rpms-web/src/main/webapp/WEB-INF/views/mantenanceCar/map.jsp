<%--
  Created by IntelliJ IDEA.
  User: peng
  Date: 2019/4/15
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #l-map{height:300px;}
        #r-result,#r-result table{width:100%;}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=BsyizLI7RHmnR6XbkwqyrKkROt6hX0FI"></script>
</head>
<body>

<div id="carDiv" >
    <div id="l-map"></div>
    <div id="r-result"></div>
</div>
</body>
<script type="text/javascript">

    // 百度地图API功能
    var map = new BMap.Map("l-map");
    map.centerAndZoom(new BMap.Point(104.086, 30.658),5);

    var driving = new BMap.DrivingRoute(map, {renderOptions: {map: map, panel: "r-result", autoViewport: true}});
    driving.search("成都市天府新谷", "${address}");
</script>
</html>
