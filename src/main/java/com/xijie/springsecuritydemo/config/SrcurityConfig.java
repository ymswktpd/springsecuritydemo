package com.xijie.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: xijie
 * @description: springsecurity配置类
 * @dte: 2022/2/28
 */
@Configuration
public class SrcurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        //表单提交
        http.formLogin()
                //当发现是/login时认为是登录，必须和表单提交的地址一样，去执行UserDetailServiceImpl
                .loginProcessingUrl("/login")
                //自定义登录页面
                .loginPage("/login.html")
                //登录成功后的跳转必须是POST请求
                .successForwardUrl("/toMain")
                //登录失败后的跳转必须是POST请求
                .failureForwardUrl("/toError");
        //授权认证
        http.authorizeRequests()
                //放过
                .antMatchers("/error.html").permitAll()
                .antMatchers("/login.html").permitAll()
                //所有请求都必须被认证，必须登录后访问
                .anyRequest().authenticated();
        //关闭csrf
        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder getPw(){
        return new BCryptPasswordEncoder();
    }
}
