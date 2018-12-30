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
  <form action="assgin.do" method="post">
    <label>Category:</label><input type="text" name="category_id">
    <label>site ips:</label>
    <textarea rows="20" cols="20" name="site_ips"></textarea></br>
    <input type="radio" name="isNoReaderDB" value="1">使用已存在的sql文件
    <input type="radio" name="isNoReaderDB" value="0" checked="checked">读取数据库生成sql文件
    <input type="text" name="sql_zip_file" value="D:/sql-test/site_assgin.zip">
    <input type="submit" value="分发数据">
  </form>
  <h3> <%=session.getAttribute("message")%></h3>
  </body>
</html>
