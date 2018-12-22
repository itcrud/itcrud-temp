package com.itcrud.temp;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Joker
 * @Desc:
 * @Date: 2018/12/22 12:04
 * @Modified By:
 * @Project_name: itcrud-temp
 * @Version 1.0
 */
@Data
public class BaseDTO implements Serializable {
    private static final long serialVersionUID = 1195242212086237834L;

    private Integer pageNo;
    private Integer pageSize;
}
