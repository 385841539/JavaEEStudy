package com.itcast.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/demo/img")
public class ResponseDemo implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

//        servletResponse.setCharacterEncoding("text/html,utf-8");
//        servletResponse.setContentType("text/html;charset=utf-8");
        //字符流返回
//        servletResponse.getWriter().write("hhh，咋了啊");


        int width =100;
        int height=50;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics graphics = bufferedImage.getGraphics();

        //画背景
        graphics.setColor(Color.CYAN);
        graphics.fillRect(0,0,width,height);

        //画边框
        graphics.setColor(Color.blue);
        graphics.drawRect(0,0,width-1,height-1);

        String str="ABCDEFGHIJKLMNOPQRESTUVWXYZabcdefghijklmnopqrestuvwxyz1234567890";
        graphics.setColor(Color.red);

        Random random = new Random();

        for (int i=1;i<=4;i++){

            int index = random.nextInt(str.length());
            char c = str.charAt(index);

            //写验证码
            graphics.drawString(c+"",(width/5)*i,height/2);
        }


        //画干扰线


        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(width);
            int y2 = random.nextInt(width);

            graphics.setColor(Color.green);
            graphics.drawLine(x1,y1,x2,y2);
        }



        ImageIO.write(bufferedImage,"jpg",servletResponse.getOutputStream());

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
