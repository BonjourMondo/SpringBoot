package com.energy.simulation.mybatis.dao;

import com.energy.simulation.mybatis.entity.dto.TestDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {
    TestDTO selectTestDTO(String name);
    void updateName(String name);
}
