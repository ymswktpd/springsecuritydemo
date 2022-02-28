package com.xijie.springsecuritydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author: xijie
 * @description: UserDetailService实现类
 * @dte: 2022/2/28
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder pw;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("执行loadUserByUsername");
        if(!"admin".equals(username)){
            throw new UsernameNotFoundException("用户名不存在！");
        }

        String password = pw.encode("123");
        return new User(username,password,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
    }
}
