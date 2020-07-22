package com.itheima.control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuickControl {



    @RequestMapping("/quick")
    @ResponseBody
    public String quick(){/**/
        return  "hello springboot ，你好 ！！！  哈哈 ";

    }
}
