package com.itcrud.temp.bo;

import lombok.Data;

/**
 * @Author: Joker
 * @Desc:
 * @Date: 2018/12/22 10:54
 * @Modified By:
 * @Project_name: itcrud-temp
 * @Version 1.0
 */
@Data
public class TestBO extends BaseBO {
    private Integer id;
    private String fileName;
    private String fileExt;
    private String fileUrl;
}
