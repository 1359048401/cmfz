package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    public String adminLogin(Admin admin, String enCode, HttpSession session) {
        System.out.println(admin.getName() + "---" + admin.getPassword());
        String code = (String) session.getAttribute("code");
        if (!code.equals(enCode)) {
            throw new RuntimeException("验证码错误");
        }
        Admin ad = adminService.queryByName(admin);
        session.setAttribute("admin", ad);

        System.out.println(ad);
        return "redirect:/main/main.jsp";
    }

}
