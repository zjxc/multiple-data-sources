package com.zjx.multiple.data.sources.annotation.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zjx
 * @version 1.0
 * @date 2020/6/1 15:41
 */
@Aspect
@Component
public class DynamicDataSourceAspect {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before("@annotation(dataSource)")
    public void changeDataSource(JoinPoint point, DataSource dataSource) {
        String value = dataSource.value();
        if ("DB2".equals(value)) {
            DataSourceType.setDataBaseType(DataSourceType.DataBaseType.DB2);
        }else {
            DataSourceType.setDataBaseType(DataSourceType.DataBaseType.DB1);
        }
    }

    @After("@annotation(dataSource)")
    public void restoreDataSource(JoinPoint point, DataSource dataSource) {
        DataSourceType.clearDataBaseType();
    }

//    @Before("execution(* com.zjx.multiple.data.sources.annotation.dao.db1.*.*(..))")
//    public void setDataSource1() {
//        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.DB1);
//    }
//
//    @Before("execution(* com.zjx.multiple.data.sources.annotation.dao.db2.*.*(..))")
//    public void setDataSource2() {
//        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.DB2);
//    }
}
