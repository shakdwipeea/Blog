package in.kyaji.web;

import in.kyaji.model.Post;
import javafx.geometry.Pos;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Created by Akash on 22-07-2014.
 */

@MultipartConfig
public class addImage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.print(request.toString());

        String title = request.getParameter("title");
        System.out.print("This is " +title);
        InputStream inputStream = null;

        Part filePart = request.getPart("image");

        if (filePart != null) {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            inputStream = filePart.getInputStream();

            String resp;

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            if (inputStream != null) {
                Post post = new Post();
                resp = post.addImage(title, inputStream);
            } else {
                resp = "Pl upload a valid image";
            }

            out.print(resp);
        } else
        {
            System.out.print("iuwhbf");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
