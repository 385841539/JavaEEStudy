package com.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求参数
        String filaname = req.getParameter("filename");

        //找到真实路径
        ServletContext servletContext = this.getServletContext();

        String realPath = servletContext.getRealPath("/img/" + filaname);

        System.out.println("filaname--："+filaname+"----realPath-:"+realPath);

        FileInputStream fileInputStream = new FileInputStream(realPath);

        //设置 response的响应头
         resp.setHeader("content-type",servletContext.getMimeType(filaname));
         resp.setHeader("content-disposition","attachment;filename="+filaname);


        //写出到输出流中
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] bytes = new byte[1024 * 8];
        int len=0;
        while ((len=fileInputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
        }
        fileInputStream.close();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
