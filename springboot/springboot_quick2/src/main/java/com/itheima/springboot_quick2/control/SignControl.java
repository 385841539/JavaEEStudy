package com.itheima.springboot_quick2.control;


import com.itheima.springboot_quick2.utils.JsonRead;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SignControl {


    @RequestMapping("/v2/signIn/setting")
    @ResponseBody
//    public String quick(@RequestBody String name){/**/
    public String signRule() {/**/
        return JsonRead.readJsonFile(getClass().getClassLoader().getResource("sign_rule.json").getPath());

    }


    @RequestMapping("/v2/resignIn")
    @ResponseBody
//    public String quick(@RequestBody String name){/**/
    public String repairSign() {/**/
        return JsonRead.readJsonFile(getClass().getClassLoader().getResource("action_repair_sign.json").getPath());

    }

    @RequestMapping("v2/signIn")
    @ResponseBody
//    public String quick(@RequestBody String name){/**/
    public String actionSign() {/**/
        return JsonRead.readJsonFile(getClass().getClassLoader().getResource("action_sign.json").getPath());

    }

    @RequestMapping("/v2/signIn/calendar")
    @ResponseBody
//    public String quick(@RequestBody String name){/**/
    public String signCalendar() {/**/
        return JsonRead.readJsonFile(getClass().getClassLoader().getResource("sign_rili.json").getPath());

    }

//    @RequestMapping(value="/addWhiteIp", method= RequestMethod.GET)

    @RequestMapping(value = "/v2/signIn/pushStatus", method = RequestMethod.GET)
    @ResponseBody
//    public String quick(@RequestBody String name){/**/
    public String pushState() {/**/
        System.out.println("获取推送状态");
        return JsonRead.readJsonFile(getClass().getClassLoader().getResource("push_state.json").getPath());

    }

    @RequestMapping(value = "/v2/signIn/pushStatus", method = RequestMethod.POST)
    @ResponseBody
//    public String quick(@RequestBody String name){/**/
    public String changeState(int status) {/**/
        System.out.println("修改推送状态---"+status);
        return JsonRead.readJsonFile(getClass().getClassLoader().getResource("push_state.json").getPath());

    }

    //
//    @RequestMapping("/cli/app/frame/v1/flist")
//    @ResponseBody
//    public String getHomeList(String menu) {/**/
//        System.out.println(menu);
//        if (menu.equals("menu1")) {
//            return JsonRead.readJsonFile(getClass().getClassLoader().getResource("home.json").getPath());
//        }else  if (menu.equals("menu4")){
//
//            return JsonRead.readJsonFile(getClass().getClassLoader().getResource("mine.json").getPath());
//        }
//        return  "";
//    }
}
