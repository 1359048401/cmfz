package com.baizhi.controller;

import com.baizhi.conf.CreateValidateCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("code")
public class ValidateController {

    @RequestMapping("getCode")
    public void getCode(HttpServletResponse response, HttpSession session) {
        //画一张随机图片，使用工具类的write方法画图片
        CreateValidateCode cvc = new CreateValidateCode();

        //获取图片上的随机数，并保存到session中
        String code = cvc.getCode();
        session.setAttribute("code", code);

        //再输出图片
        try {
            cvc.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
