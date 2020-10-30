package com.itheima.springboot_quick2.control;


import com.itheima.springboot_quick2.utils.JsonRead;
import com.sun.tools.internal.ws.processor.model.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuickCOntrol {


    @RequestMapping("/quick2")
    @ResponseBody
//    public String quick(@RequestBody String name){/**/
    public String quick() {/**/
        return "hello springbo；旅客巨化股份ot ，你好 ！！！  哈哈 quick2";

    }

    //
    @RequestMapping("/cli/app/frame/v1/flist")
    @ResponseBody
    public String getHomeList(String menu) {/**/
        System.out.println(menu);
        if (menu.equals("menu1")) {
            return JsonRead.readJsonFile(getClass().getClassLoader().getResource("home.json").getPath());
        }else  if (menu.equals("menu4")){

            return JsonRead.readJsonFile(getClass().getClassLoader().getResource("mine.json").getPath());
        }
        return  "";
    }
}
