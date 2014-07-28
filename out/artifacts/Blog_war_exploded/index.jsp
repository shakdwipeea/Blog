<%@ page import="in.kyaji.web.displayStory" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="java.awt.image.BufferedImage" %>
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
    <button id="addPic">Add a picture</button>
        <div id="container">
            <%
                displayStory d = new displayStory();
                ArrayList a = d.getStory(0);
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

        <div id="containerImage">
            <%
                displayStory d1 = new displayStory();
                ArrayList a1 = d1.getStory(1);
                Iterator iterator1 = a1.iterator();
                int i1 = 0;
                while (iterator1.hasNext()) {

                    out.print("<br> Sno: " + iterator1.next());
                    out.print(" Title: " + iterator1.next());
                    //out.print(" Image " + iterator1.next());
                    %>
            <img src="<%=iterator1.next() %>" alt=""/>
            
            <%
                    //String b = iterator1.next();


                }
            %>

        </div>


  <div>
      Server info <%=application.getServerInfo()%> <br/>
      Servlet Version <%=application.getMajorVersion() %>.<%=application.getMinorVersion()%><br/>
  </div>
  </body>
<script>
    var but = document.getElementById("add");
    but.onclick = function () {
        window.location.href = "./newStories.jsp";
    }

    var but2 = document.getElementById("addPic");
    but2.onclick = function () {
        window.location.href = "./newPhoto.jsp";
    }
</script>
</html>
