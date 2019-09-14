package com.energy.simulation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: leesanghyuk
 * Date: 2019-09-13 19:17
 * Description:
 */
@Controller
@Slf4j
@RequestMapping("/")
public class BrowserSecurityController {

    @RequestMapping(value = {"/login","/"})
    public String showLogin(@RequestParam(name = "auth",required = false) String auth, Model model) {
        Map map=new HashMap();
//        if (!StringUtils.isEmpty(auth)&& "false".equalsIgnoreCase(auth)){
//            //账号或密码错误
//            map.put("message","账号或密码错误");
//            model.addAttribute(map);
//        }
//        map.put("message","账号或密码错误");
//        model.addAttribute(map);
        return "login";
    }

    @RequestMapping("/home")
    public void home(HttpServletResponse httpServletResponse) throws IOException {
        //登陆成功后重定向到vue
        httpServletResponse.sendRedirect("http://www.baidu.com");
    }

}
