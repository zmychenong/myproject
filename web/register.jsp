<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/8
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>注册用户</title>
  </head>
  <body>
     <center>
        <h1>注册用户</h1>
        <form action="RegisterServlet" method="post">

          用户名：<input type="text" name="userName"
                     placeholder="请输入用户名">
          <br> <br>
          密码：<input type="password" name="userPassword"
                     placeholder="请输入密码">
          <br> <br>
          年龄：<input type="text" name="userAge"
                     placeholder="请输入年龄">
          <br> <br>
          性别：<input type="radio" name="userSex" value="男" checked>男
                <input type="radio" name="userSex" value="女">女
          <br> <br>
          <input type="submit" value="提交">

        </form>
     </center>
  </body>
</html>
