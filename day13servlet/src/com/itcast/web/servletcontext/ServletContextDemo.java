package com.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/mineType")
public class ServletContextDemo  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        ServletContext servletContext1 = this.getServletContext();

        String  fileName="a.jpg";
        String mimeType = servletContext.getMimeType(fileName);
        System.out.println("mimeType---"+mimeType);

        servletContext.setAttribute("hh","你好");

        //获取文件真实路径
        String realPath = servletContext.getRealPath("/b.txt");
        String aRealPath = servletContext.getRealPath("/a.txt");
        File file = new File(realPath);
        System.out.println("realPath--"+realPath);
        System.out.println("aRealPath--"+aRealPath);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
