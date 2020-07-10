package com.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mineType1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        ServletContext servletContext1 = this.getServletContext();

        String  fileName="a.jpg";
        String mimeType = servletContext.getMimeType(fileName);
        System.out.println("mimeType---"+mimeType);

        Object hh = servletContext.getAttribute("hh");
        System.out.println("hh---"+hh);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
