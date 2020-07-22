package com.itheima.springboot_quick2.control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuickCOntrol {



    @RequestMapping("/quick2")
    @ResponseBody
    public String quick(){/**/
        return  "hello springbo；旅客巨化股份ot ，你好 ！！！  哈哈 quick2";

    }
}
