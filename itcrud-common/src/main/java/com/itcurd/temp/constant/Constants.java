package com.itcurd.temp.constant;

import java.util.UUID;

/**
 * @Author: Joker
 * @Desc: 全局常量类
 * @Date: 2018/12/22 10:34
 * @Modified By:
 * @Project_name: itcrud-temp
 * @Version 1.0
 */
public class Constants {
    /**
     * 请求地址开头
     */
    public static final String REQUEST_PREFIX = "api/";

    /**
     * 请求头requestId
     */
    public static final String REQUEST_ID = "requestId";

    /**
     * 系统默认requestId
     */
    public static final String REQUEST_ID_DEFAULT = "default" + UUID.randomUUID().toString().toLowerCase().replace("-","").substring(7, 32);
}
