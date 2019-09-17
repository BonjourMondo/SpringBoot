package com.energy.simulation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: leesanghyuk
 * Date: 2019-09-13 19:17
 * Description:
 */
@Controller
@Slf4j
@RequestMapping("/")
public class BrowserSecurityController {

    /**
     * 登陆系统重定向到登陆页面
     * @return
     * @throws IOException
     */
    @RequestMapping
    public String toLogin() throws IOException {
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String showLogin(@RequestParam(name = "auth",required = false) String auth, Model model,HttpServletResponse httpServletResponse) throws IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            if (!StringUtils.isEmpty(auth)) {
                if ("fail".equalsIgnoreCase(auth)){
                    log.info("【登陆失败】auth验证失败，用户账号或者密码错误");
                    //账号或密码错误
                    model.addAttribute("auth", "No such user or wrong password");
                }else if ("register".equalsIgnoreCase(auth)){
                    log.info("【注册成功】注册成功，重新输入账号密码");
                    model.addAttribute("auth", "Register successfully, please login again");
                }
            } else {
                model.addAttribute("auth", "Sign in to continue");
            }
            return "login";
        }else{
            log.info("【用户已登陆】跳转到首页");
            httpServletResponse.sendRedirect("http://localhost:9090");
            return null;
        }
    }

    @RequestMapping("/home")
    public void home(HttpServletResponse httpServletResponse) throws IOException {
        //登陆成功后重定向到vue
        httpServletResponse.sendRedirect("http://localhost:9090");
    }

    @RequestMapping("/register")
    public String register(@RequestParam("username") String username,@RequestParam("password") String password){
        log.info("【register】注册用户名:{},密码:{}",username,password);
        //service register
        return "redirect:/login?auth=register";
    }

}
