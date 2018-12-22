package com.itcrud.temp;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Joker
 * @Desc:
 * @Date: 2018/12/22 12:04
 * @Modified By:
 * @Project_name: itcrud-temp
 * @Version 1.0
 */
@Data
public class BaseVO implements Serializable {
    private static final long serialVersionUID = 1095242212086237834L;

    private Date createTime;
    private Date updateTime;
    private String createBy;
    private String updateBy;
}
