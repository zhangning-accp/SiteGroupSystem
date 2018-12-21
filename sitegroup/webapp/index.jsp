<%--
  Created by IntelliJ IDEA.
  User: zn
  Date: 2018/12/13
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="">
    <label>Category:</label><input type="text" name="category_id">
    <label>Command:</label><input type="text" value="mysql -uroot -pLitecart@2018 litecart < /root/dep/sql/assgin.sql" name="command">
    <input type="submit" value="Start assgin data">
  </form>


  <h3> 耗时:${message} 分钟</h3>
  </body>
</html>
