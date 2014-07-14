<%--
  Created by IntelliJ IDEA.
  User: Akash
  Date: 14-07-2014
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form method="post" action = "story.do" >
    <fieldset>
        <label for="title">Enter your post title</label>
        <input type="text" name="title" id="title">
        <br><br>
        <label for="body" >Story: </label>
        <textarea name="body" id="body" rows="10" cols="40'"></textarea>
        <br><br>
        <input type="SUBMIT" name="submit" value="post">
    </fieldset>
</form>
</body>
</html>
