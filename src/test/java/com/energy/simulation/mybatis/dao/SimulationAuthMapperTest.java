package com.energy.simulation.mybatis.dao;

import com.energy.simulation.mybatis.entity.dto.SimulationUserInfoDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class SimulationAuthMapperTest {
    @Autowired
    SimulationAuthMapper simulationAuthMapper;

    @Test
    public void getAuthMapper(){
        SimulationUserInfoDTO simulationUserInfoDTO=simulationAuthMapper.selectUserByUsername("xzq123");
        System.out.println(simulationUserInfoDTO.getPassword());
    }


}