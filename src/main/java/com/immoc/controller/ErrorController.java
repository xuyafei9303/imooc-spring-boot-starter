package com.immoc.controller;

import com.immoc.pojo.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("err")
public class ErrorController {

    @RequestMapping("/error")
    public String error1() {
        System.out.println("hello");
        int a = 1 / 0;
        return "thymeleaf/error";
    }

    @RequestMapping("/ajaxerror")
    public String ajaxerror() {
        return "thymeleaf/ajaxerror";
    }

    @RequestMapping("/getAjaxError")
    @ResponseBody
    public JsonResult getAjaxerror() {
        int a = 1 / 0;
        return JsonResult.ok();
    }
}
