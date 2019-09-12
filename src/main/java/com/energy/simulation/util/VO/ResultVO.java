package com.energy.simulation.util.VO;


import java.io.Serializable;

/**
 * Author: leesanghyuk
 * Date: 2019-09-05 17:21
 * Description:回传VO
 */
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -6554233178238131230L;

    /**
     * 调用结果码
     */
    private Integer resultCode;

    /**
     * 调用详情
     * 返回错误码
     */
    private String msg="";

    /**
     * 返回数据集（非必须）
     */
    private T data;

    public ResultVO() {
    }

    public ResultVO(Integer resultCode, String msg) {
        this.resultCode = resultCode;
        this.msg = msg;
    }

    public ResultVO(Integer resultCode, String msg, T data) {
        this.resultCode = resultCode;
        this.msg = msg;
        this.data = data;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
