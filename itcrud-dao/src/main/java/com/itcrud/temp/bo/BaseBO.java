package com.itcrud.temp.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Joker
 * @Desc:
 * @Date: 2018/12/22 15:09
 * @Modified By:
 * @Project_name: itcrud-temp
 * @Version 1.0
 */
@Data
public class BaseBO implements Serializable {
    private static final long serialVersionUID = 1195242212086237839L;
    private Date createTime;
    private Date updateTime;
    private String createBy;
    private String updateBy;
}
