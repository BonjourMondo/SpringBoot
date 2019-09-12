package com.energy.simulation.config.security;

import com.energy.simulation.mybatis.dao.UserAuthMapper;
import com.energy.simulation.mybatis.entity.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Author: leesanghyuk
 * Date: 2019-09-12 10:01
 * Description:
 */
@Component
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
//    @Autowired
//    private UserAuthMapper userAuthMapper;

    /**
     * 根据用户名判断是否找到用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserDTO user = userAuthMapper.findUser(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        return new SecurityUser(user);
        return new User("user","123456",
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
