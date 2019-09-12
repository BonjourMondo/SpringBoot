package com.energy.simulation.mybatis.dao;

import com.energy.simulation.mybatis.entity.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAuthMapper {
    UserDTO findUser(String name);
}
