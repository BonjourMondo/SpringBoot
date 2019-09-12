package com.energy.simulation.controller;

import com.energy.simulation.mybatis.entity.dto.TestDTO;
import com.energy.simulation.service.TestService;
import com.energy.simulation.util.VO.ResultVO;
import com.energy.simulation.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: leesanghyuk
 * Date: 2019-09-11 17:15
 * Description:
 */
@RestController
@RequestMapping("/")
@Slf4j
public class HomeController {
    @Autowired
    private TestService testService;

    @ResponseBody
    @RequestMapping("/login")
    public String login(){
        return "home";
    }

    @ResponseBody
    @RequestMapping("/data")
    public ResultVO<TestDTO> getDTOtest(){
        log.error("【error】回传energyConfigurationDTO");
        log.debug("【debug】回传energyConfigurationDTO");
        log.info("【info】回传energyConfigurationDTO");
        return ResultVOUtil.success(new TestDTO("name",1.11));
    }

    @ResponseBody
    @RequestMapping("/testDB")
    public ResultVO<String> getDBtest(){
        testService.insert();
        return ResultVOUtil.success();
    }
}
