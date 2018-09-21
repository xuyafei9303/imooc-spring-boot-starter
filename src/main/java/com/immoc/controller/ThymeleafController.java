package com.immoc.controller;

import com.immoc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("th")
public class ThymeleafController {

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "Thymeleaf-imooc");
        return "thymeleaf/index";
    }

    @RequestMapping("center")
    public String center(ModelMap map) {
        return "thymeleaf/center/center";
    }

    @RequestMapping("/user")
    public String test(ModelMap map) {
        User u = new User();
        u.setName("张三");
        u.setAge(18);
        u.setPassword("zhangsan");
        u.setBirthday(new Date());
        u.setDesc("<font color='green'><b>hello</b></font>");

        map.addAttribute("user",u);
        return "thymeleaf/user";
    }
}
