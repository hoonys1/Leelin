package com.joeun.leelin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.joeun.leelin.dto.CustomUser;
import com.joeun.leelin.dto.Users;
import com.joeun.leelin.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * UserDetailsService 
 * : Spring Security에서 사용자 정보를 데이터베이스에서 가져와서,
 *   사용자 인증을 수행하기 위한 인터페이스
 * * 위 인터페이스를 구현하여 loadUserByUsername() 재정의하면,
 * * 데이터베이스나 다른 소스로부터 사용자 인증정보를 가져와서 스프링 시큐리티에 전달해줄 수 있다.
 */
@Slf4j
@Serveice
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username)  {
        log.info("login - loadUserByUsername : " + username);
        // MyBatis를 사용하여 데이터베이스에서 사용자 세부 정보를 가져옵니다.
        Users user = userMapper.login(username);

        if (user == null) {
            log.info("사용자 없음...");
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
        }
        log.info("user :::::");
        log.info(user.toString());
        // 🟢🟡🔴 CustomUser (➡User) 사용
        CustomUser customUser = new CustomUser(user);

        log.info("customuser :::::");
        log.info(customUser.toString());
        return customUser;

    }
}
}
