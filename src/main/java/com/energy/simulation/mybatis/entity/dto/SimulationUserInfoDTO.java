package com.energy.simulation.mybatis.entity.dto;

import lombok.*;

import java.io.Serializable;

/**
 * Author: leesanghyuk
 * Date: 2019-09-12 19:12
 * Description:用户登陆数据库DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SimulationUserInfoDTO implements Serializable {
    private static final long serialVersionUID = 4278314483973023293L;
    private Integer id;
    private String username;
    private String password;
    private String role;
}
