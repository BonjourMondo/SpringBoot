package com.energy.simulation.config;

import com.energy.simulation.config.security.CustomUserDetailsService;
import com.energy.simulation.config.security.SimulationAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Author: leesanghyuk
 * Date: 2019-09-12 09:18
 * Description:
 */
@Configuration
@EnableWebSecurity
@Profile(value = {"dev"})
public class WebSecurityProdConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/login","/register").permitAll()//login路径不拦截
                .anyRequest().authenticated()
                .and()
                .formLogin()//指定表单登陆
                .loginPage("/login") //登陆页面
//                .loginProcessingUrl("/authentication/form")
                .defaultSuccessUrl("/home") //登陆成功转向该页面
                .failureUrl("/login?auth=fail")
                .permitAll()
                .and()
                .csrf().disable()
//                .and()
//                .logout().logoutUrl("/logout").logoutSuccessUrl("/login").invalidateHttpSession(true)
//                .permitAll()
        ;

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers( "/css/**", "/js/**", "/images/**", "/error");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new SimulationAuthenticationProvider(customUserDetailsService));
        auth.eraseCredentials(true);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

