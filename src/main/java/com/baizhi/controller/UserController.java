package com.baizhi.controller;


import com.baizhi.entity.Province;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("queryAll")
    public List<User> queryAll() {
        List<User> users = userService.queryAll();
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }

    @RequestMapping("selectNum")
    public Map<String, List<Integer>> selectNum() {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> num = userService.queryActiveUser();
        map.put("data", num);
        return map;
    }

    @RequestMapping("countUserProvince")
    public Map<String, List<Province>> countUserProvince() {
        List<Province> list = userService.queryUserProvince();
        Map<String, List<Province>> map = new HashMap<>();
        map.put("data", list);
        return map;
    }
}
