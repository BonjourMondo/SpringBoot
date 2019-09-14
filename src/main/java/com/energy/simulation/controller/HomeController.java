package com.energy.simulation.controller;

import com.energy.simulation.mybatis.entity.dto.UserDTO;
import com.energy.simulation.mybatis.entity.query.User;
import com.energy.simulation.service.TestService;
import com.energy.simulation.util.ResultVOUtil;
import com.energy.simulation.util.VO.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Author: leesanghyuk
 * Date: 2019-09-11 17:15
 * Description:
 */
@RestController
@RequestMapping("/simulation")
@Slf4j
public class HomeController {
    @Autowired
    private TestService testService;

//    @ResponseBody
//    @RequestMapping("/home")
//    public String home(){
//        return "home";
//    }

//    @ResponseBody
//    @RequestMapping("/error")
//    public String error(){
//        return "error";
//    }

    @ResponseBody
    @RequestMapping(value = "/data",method = RequestMethod.POST)
    public ResultVO<User> getDTOtest(@Valid @RequestBody User user, BindingResult errors){
        if (errors.hasErrors())
            log.error("【error!!!!!!!!!!!!!】");
        log.error("【error】name:{},password:{}",user.getUsername(),user.getPassword());
        return ResultVOUtil.success(user);
    }

    @ResponseBody
    @RequestMapping(value = "/data2",method = RequestMethod.GET)
    public ResultVO<UserDTO> getDTOtest(@RequestParam("username") String name,@RequestParam String password){
        //http://localhost:8080/data2?username=1&password=2
        UserDTO userDTO=new UserDTO();
        userDTO.setName(name);
        userDTO.setPassword(password);
        log.error("【error】name:{},password:{}",userDTO.getName(),userDTO.getPassword());
        return ResultVOUtil.success(userDTO);
    }

    @ResponseBody
    @RequestMapping("/testDB")
    public ResultVO<String> getDBtest(){
        testService.insert();
        return ResultVOUtil.success();
    }
}
