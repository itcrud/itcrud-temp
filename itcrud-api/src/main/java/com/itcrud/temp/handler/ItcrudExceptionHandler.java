package com.itcrud.temp.handler;

import com.itcurd.temp.vo.ResponseVO;
import com.itcurd.temp.enums.BizCodeEnum;
import com.itcurd.temp.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author: Joker
 * @Desc: 异常统一处理
 * @Date: 2018/12/22 12:51
 * @Modified By:
 * @Project_name: itcrud-temp
 * @Version 1.0
 */
@ControllerAdvice("com.itcrud.temp")
@Slf4j
public class ItcrudExceptionHandler {

    //处理除自定义异常的其他异常信息
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseVO globalException(Exception e) {
        log.error("系统异常信息：", e);
        return ResponseVO.failResp(null, BizCodeEnum.CODE_500000.getMsg(), BizCodeEnum.CODE_500000.getCode());
    }

    //自定义异常处理
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BizException.class)
    @ResponseBody
    public ResponseVO bizException(BizException e) {
        log.error("业务异常信息：", e);
        BizCodeEnum bizCode = e.getBizCode();
        return ResponseVO.failResp(null, bizCode.getMsg(), bizCode.getCode());
    }
}
