package com.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/requestDemo")
public class RequestDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       soutRequest(request);

        soutHead(request);
    }

    private void soutHead(HttpServletRequest request) {

        Enumeration<String> headerNames = request.getHeaderNames();

        String userAgent = request.getHeader("user-agent");
        if (userAgent.contains("Chrome")){
            System.out.println("谷歌来了----");
        }else {
            System.out.println("who are you ? ");
        }
//        while (headerNames.hasMoreElements()){
//            String name = headerNames.nextElement();
//            String value = request.getHeader(name);
//
//            System.out.println("head---name-"+name);
////            head---name-host
////            head---name-connection
////            head---name-cache-control
////            head---name-upgrade-insecure-requests
////            head---name-user-agent
////            head---name-accept
////            head---name-sec-fetch-site
////            head---name-sec-fetch-mode
////            head---name-sec-fetch-user
////            head---name-sec-fetch-dest
////            head---name-accept-encoding
////            head---name-accept-language
////            head---name-cookie
//
//        }
    }

    private void soutRequest(HttpServletRequest request) {
        String method = request.getMethod();
        System.out.println("method--"+method);
        String contextPath = request.getContextPath();
        System.out.println("contextPath-虚拟目录-"+contextPath);
        String requestURI = request.getRequestURI();
        System.out.println("requestURI--"+requestURI);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("requestURL--"+requestURL);
        String protocol = request.getProtocol();
        System.out.println("protocol--"+protocol);
        String remoteAddr = request.getRemoteAddr();
        System.out.println("remoteAddr--"+remoteAddr);
        String queryString = request.getQueryString();
        System.out.println("queryString--"+queryString);
    }
}
