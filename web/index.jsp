<%@ page import="in.kyaji.web.displayStory" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: Akash
  Date: 14-07-2014
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    <button id="add">Add a post</button>
        <div id="container">
            <%
                displayStory d = new displayStory();
                ArrayList a = d.getStory();
                Iterator iterator = a.iterator();
                int i = 0;
                while (iterator.hasNext()) {

                    out.print("<br> Sno: " + iterator.next());
                    out.print(" Title: " + iterator.next());
                    out.print(" Story: " + iterator.next());
                    out.print("Date: " + iterator.next());
                }
            %>
        </div>
  </body>
<script>
    var but = document.getElementById("add");
    but.onclick = function () {
        window.location.href = "./newStories.jsp";
    }
</script>
</html>
