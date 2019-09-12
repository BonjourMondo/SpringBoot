package com.energy.simulation.util;

import com.energy.simulation.util.VO.ResultVO;

/**
 * Author: leesanghyuk
 * Date: 2019-09-11 17:25
 * Description:结果回传工具
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setResultCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setResultCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
