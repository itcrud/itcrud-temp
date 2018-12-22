package com.itcrud.temp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: Joker
 * @Desc:
 * @Date: 2018/12/22 10:29
 * @Modified By:
 * @Project_name: itcrud-temp
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.itcrud.temp.mapper"})
@EnableAspectJAutoProxy(exposeProxy = true)
public class TempApplication {
    public static void main(String[] args) {
        SpringApplication.run(TempApplication.class);
    }
}
