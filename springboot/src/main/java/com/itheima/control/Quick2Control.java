package com.itheima.control;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Quick2Control {


    @Value("${name}")
    private String name;


    @Value("${person.addr}")
    private String add;

    @RequestMapping("/quicktext")
    @ResponseBody
    public String quick2(){


        return  "name: "+name+"-----add: "+add;
    }
}
