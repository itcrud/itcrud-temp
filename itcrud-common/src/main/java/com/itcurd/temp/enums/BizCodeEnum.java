package com.itcurd.temp.enums;

/**
 * @Author: Joker
 * @Desc:
 * @Date: 2018/12/22 14:06
 * @Modified By:
 * @Project_name: itcrud-temp
 * @Version 1.0
 */
public enum BizCodeEnum {

    /*200*/
    CODE_200000("200000", "请求成功！"),

    /*400*/
    CODE_400000("400000", "请求失败！"),

    /*500*/
    CODE_500000("500000", "请求失败！"),
    CODE_500001("500001", "requestId不能为空！");

    private BizCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;

    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
