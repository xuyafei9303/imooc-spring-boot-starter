package com.immoc.controller;

import com.immoc.pojo.JsonResult;
import com.immoc.pojo.SysUser;
import com.immoc.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {

    @Autowired
    private UserService userService;

    @Autowired
    private Sid sid;

    @RequestMapping("/saveUser")
    public JsonResult saveUser() throws Exception {
        String userId = sid.nextShort();

        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("xyf1" + new Date());
        user.setNickname("xyf1" + new Date());
        user.setPassword("xyf1");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUser(user);
        return JsonResult.ok("保存成功");
    }

    @RequestMapping("/updateUser")
    public JsonResult updateUser() {

        SysUser user = new SysUser();

        user.setId("1809210TRNXNDSY8");
        user.setUsername("mybatis" + new Date());
        user.setNickname("mybatis" + new Date());
        user.setPassword("mybatis" + new Date());
        userService.updateUser(user);

        return JsonResult.ok("更新成功");
    }

    @RequestMapping("/deleteUser")
    public JsonResult deleteUser(String userId) {
        userService.deleteUser(userId);

        return JsonResult.ok("删除成功");
    }

    @RequestMapping("/queryUserById")
    public JsonResult queryUserById(String userId) {
        return JsonResult.ok(userService.queryUserById(userId));
    }

    @RequestMapping("/queryUserList")
    public JsonResult queryUserList() {
        SysUser user = new SysUser();
        user.setUsername("immoc");
        user.setNickname("xyf");

        List<SysUser> userList = userService.queryUserList(user);

        return JsonResult.ok(userList);
    }

    @RequestMapping("/queryUserListPaged")
    public JsonResult queryUserListPaged(Integer page) {
        if (page == null) {
            page = 1;
        }
        int pageSize = 10;
        SysUser user = new SysUser();
        List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);

        return JsonResult.ok(userList);
    }

    @RequestMapping("/queryUserByIdCustom")
    public JsonResult queryUserByIdCustom(String userId) {
        return JsonResult.ok(userService.queryUserByIdCustom(userId));
    }

    @RequestMapping("/saveUserTransactional")
    public JsonResult saveUserTransactional() {
        String userid = sid.nextShort();

        SysUser user = new SysUser();
        user.setId(userid);
        user.setUsername("xyf-name1" + new Date());
        user.setNickname("xyf-nick1" + new Date());
        user.setPassword("xyf-pwd1" + new Date());
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUserTransactional(user);
        return JsonResult.ok("保存成功");
    }

}
