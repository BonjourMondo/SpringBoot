package com.energy.simulation.mybatis.entity.query;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * Author: leesanghyuk
 * Date: 2019-09-12 16:10
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User implements Serializable {
    private static final long serialVersionUID = -1164193626244882601L;
    @NotEmpty(message = "username不能为空")
    String username;
    String password;
}
