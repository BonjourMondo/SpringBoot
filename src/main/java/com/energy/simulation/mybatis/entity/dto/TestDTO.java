package com.energy.simulation.mybatis.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

/**
 * Author: leesanghyuk
 * Date: 2019-09-11 17:20
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TestDTO implements Serializable {
    private static final long serialVersionUID = -7452704421255137211L;
    @JsonProperty("name")
    private String e_name;
    @JsonProperty("data")
    private Double e_data;
}
