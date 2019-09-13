package com.energy.simulation.mybatis.dao;

import com.energy.simulation.mybatis.entity.dto.SimulationUserInfoDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author: leesanghyuk
 * Date: 2019-09-12 19:14
 * Description:用户登陆验证Mapper
 */
@Mapper
public interface SimulationAuthMapper {
    SimulationUserInfoDTO selectUserByUsername(String username);
}
