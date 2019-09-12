package com.energy.simulation.service.serviceImpl;

import com.energy.simulation.mybatis.dao.TestMapper;
import com.energy.simulation.mybatis.entity.dto.TestDTO;
import com.energy.simulation.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: leesanghyuk
 * Date: 2019-09-11 18:58
 * Description:
 */
@Slf4j
@Service("testservice")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public void insert() {
        TestDTO testDTO=testMapper.selectTestDTO("name1");
        log.info("【info】name:{},data:{}",testDTO.getE_name(),testDTO.getE_data());
    }
}
