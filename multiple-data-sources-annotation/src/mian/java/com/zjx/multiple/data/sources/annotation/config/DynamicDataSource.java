package com.zjx.multiple.data.sources.annotation.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author zjx
 * @version 1.0
 * @date 2020/6/1 15:08
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceType.getDataBaseType();
    }

}
