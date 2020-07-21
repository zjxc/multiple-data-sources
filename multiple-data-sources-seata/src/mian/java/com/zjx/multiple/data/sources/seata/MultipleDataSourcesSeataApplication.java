package com.zjx.multiple.data.sources.seata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author zjx
 * @version 1.0
 * @date 2020/7/19 21:21
 */
@SpringBootApplication
@MapperScan(basePackages = "com.zjx.multiple.data.sources.seata.mapper")
public class MultipleDataSourcesSeataApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipleDataSourcesSeataApplication.class, args);
    }

}
