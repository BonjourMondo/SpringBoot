package com.energy.simulation.config.security;

import com.energy.simulation.mybatis.entity.dto.SimulationUserInfoDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Author: leesanghyuk
 * Date: 2019-09-12 10:15
 * Description:
 */
public class SecurityUser implements UserDetails {
    private SimulationUserInfoDTO user;
    /**
     *
     */
    private static final long serialVersionUID = -1623385418837308233L;
    public SecurityUser(SimulationUserInfoDTO u){
        this.user=u;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        //放入用户的权限和角色信息
        SimpleGrantedAuthority authority= new SimpleGrantedAuthority("auth:"+this.user.getRole());
        authorities.add(authority);
        return authorities;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
