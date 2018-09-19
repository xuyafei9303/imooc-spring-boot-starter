package com.immoc.controller;

import com.immoc.pojo.JsonResult;
import com.immoc.pojo.Resource;
import com.immoc.pojo.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController // = @Controller + @ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Resource resource;

    @RequestMapping("/getUser")
    public JsonResult index() {
        User u = new User();
        u.setName("immoc");
        u.setAge(18);
        u.setBrithday(new Date());
        u.setPassword("immoc");
        u.setDesc("desc");

        return JsonResult.ok(u);
    }

    @RequestMapping("/getResource")
    public JsonResult getResource() {
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);

        return JsonResult.ok(bean);
    }
}
