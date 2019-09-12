package com.energy.simulation.util.VO;

/**
 * Author: leesanghyuk
 * Date: 2019-09-11 17:26
 * Description:分页回传工具类
 */

import java.io.Serializable;

/**
 * Author: leesanghyuk
 * Date: 2019-09-05 17:22
 * Description:分页回传VO
 */
public class PageResultVO<T> extends ResultVO implements Serializable {

    private static final long serialVersionUID = -4396654063576953114L;

    private Integer total;//总数

    public PageResultVO() {

    }

    public PageResultVO(Integer resultCode, String msg) {
        super(resultCode, msg);
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}

