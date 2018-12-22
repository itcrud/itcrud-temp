package com.itcrud.temp.mapper;

import com.itcrud.temp.bo.TestBO;

import java.util.List;

/**
 * @Author: Joker
 * @Desc:
 * @Date: 2018/12/22 10:53
 * @Modified By:
 * @Project_name: itcrud-temp
 * @Version 1.0
 */
public interface TestMapper {
    List<TestBO> findAll();
}
