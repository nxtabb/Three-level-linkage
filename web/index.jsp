<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/3
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>省市区三级联动框</title>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/place.js"></script>
  </head>
  <body>
  <p>省市级三级联动框</p>
  <select name="province" id="province">
    <option value="1">黑龙江</option>
    <option value="2">吉林省</option>
    <option value="3">辽宁省</option>
    <option value="4">山东省</option>
  </select>

  <select name="city" id="city">
    <option value="1">哈尔滨</option>
    <option value="2">大庆</option>
    <option value="3">佳木斯</option>
  </select>

  <select name="qu" id="qu">
    <option value="1">香坊区</option>
    <option value="2">道里区</option>
  </select>
  </body>
</html>
