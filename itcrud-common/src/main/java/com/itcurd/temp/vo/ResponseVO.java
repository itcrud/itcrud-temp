package com.itcurd.temp.vo;

import com.itcurd.temp.enums.BizCodeEnum;

/**
 * @Author: Joker
 * @Desc: 请求响应封装
 * @Date: 2018/12/22 11:04
 * @Modified By:
 * @Project_name: itcrud-temp
 * @Version 1.0
 */
public class ResponseVO<T> {

    public static final Integer SUCCESS = 0;
    public static final Integer FAIL = 1;

    private Integer success;
    private String msg;
    private T data;
    private String code;

    public ResponseVO() {
    }

    public ResponseVO(Integer success, String msg, T data, String code) {
        this.success = success;
        this.msg = msg;
        this.data = data;
        this.code = code;
    }

    private ResponseVO(T data) {
        this(SUCCESS, BizCodeEnum.CODE_200000.getMsg(), data, BizCodeEnum.CODE_200000.getCode());
    }


    //成功：默认
    public static ResponseVO successResp() {
        return new ResponseVO<>(SUCCESS, BizCodeEnum.CODE_200000.getMsg(), null, BizCodeEnum.CODE_200000.getCode());
    }

    //成功：响应数据
    public static <D> ResponseVO<D> successResp(D data) {
        return new ResponseVO<>(data);
    }

    //成功：响应数据+响应信息
    public static <D> ResponseVO<D> successResp(D data, String msg) {
        return new ResponseVO<>(SUCCESS, msg, data, BizCodeEnum.CODE_200000.getCode());
    }

    //成功：响应数据+响应信息+响应code
    public static <D> ResponseVO<D> successResp(D data, String msg, String code) {
        return new ResponseVO<>(SUCCESS, msg, data, code);
    }

    //失败：默认
    public static ResponseVO failResp() {
        return new ResponseVO<>(FAIL, BizCodeEnum.CODE_500000.getMsg(), null, BizCodeEnum.CODE_500000.getCode());
    }

    //失败：响应数据的失败
    public static <D> ResponseVO<D> failResp(D data) {
        return new ResponseVO<>(FAIL, BizCodeEnum.CODE_500000.getMsg(), data, BizCodeEnum.CODE_500000.getCode());
    }

    //失败：响应数据+响应信息
    public static <D> ResponseVO<D> failResp(D data, String msg) {
        return new ResponseVO<>(FAIL, msg, data, BizCodeEnum.CODE_500000.getCode());
    }

    //失败：响应数据+响应信息+响应code
    public static <D> ResponseVO<D> failResp(D data, String msg, String code) {
        return new ResponseVO<>(FAIL, msg, data, code);
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
