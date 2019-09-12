package com.energy.simulation.mybatis.entity.dto;

import lombok.*;

import java.io.Serializable;

/**
 * Author: leesanghyuk
 * Date: 2019-09-12 10:04
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 4380065733663836314L;
    private int id;
    private String name;
    private String email;
    private String password;
    private String role;
}
