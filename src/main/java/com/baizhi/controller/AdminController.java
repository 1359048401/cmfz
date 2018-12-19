package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    public String adminLogin(String name, String password, String enCode, HttpSession session) {
        System.out.println(name);
        System.out.println(password);
        String code = (String) session.getAttribute("code");
        if (!code.equals(enCode)) {
            throw new RuntimeException("验证码错误");
        }
        Admin admin = adminService.queryByName(name, password);
        session.setAttribute("admin", admin);

        System.out.println(admin);
        return "redirect:/main/main.jsp";
    }

}
