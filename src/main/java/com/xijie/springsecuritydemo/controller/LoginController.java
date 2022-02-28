package com.xijie.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author: xijie
 * @description: 登录控制层
 * @dte: 2022/2/28
 */
@RestController
public class LoginController {

//    @GetMapping("login")
//    public String login(){
//        System.out.println("执行登录！");
//        return "redirect:main.html";
//    }
    @PostMapping("toMain")
    public ModelAndView toMain(){
        return new ModelAndView(new RedirectView("main.html"));
    }
    @PostMapping("toError")
    public ModelAndView toError(){
        return new ModelAndView(new RedirectView("error.html"));
    }
}
