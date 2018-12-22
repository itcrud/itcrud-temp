package com.itcurd.temp.exception;

import com.itcurd.temp.enums.BizCodeEnum;

/**
 * @Author: Joker
 * @Desc: 业务异常
 * @Date: 2018/12/22 12:57
 * @Modified By:
 * @Project_name: itcrud-temp
 * @Version 1.0
 */
public class BizException extends RuntimeException {

    private BizCodeEnum bizCode;

    public BizCodeEnum getBizCode() {
        return bizCode;
    }

    public void setBizCode(BizCodeEnum bizCode) {
        this.bizCode = bizCode;
    }

    public BizException(BizCodeEnum bizCode) {
        super(bizCode.getMsg());
        this.bizCode = bizCode;
    }
}
