<%--
  Created by IntelliJ IDEA.
  User: Akash
  Date: 22-07-2014
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding a picture</title>
</head>
<body>
    <form method="post" action="img.do" enctype="multipart/form-data">

        Give a caption
        <input type="text" name="title" id="title">
        Upload your desired file
        <input type="file" name="image">
        <br/><br/>

        <input type="submit">
    </form>
</body>
</html>
