package com.xijie.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xijie
 * @description: 登录控制层
 * @dte: 2022/2/28
 */
@RestController
public class LoginController {

    @GetMapping("login")
    public String login(){
        System.out.println("执行登录！");
        return "redirect:main.html";
    }
}
