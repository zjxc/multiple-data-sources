package com.zjx.multiple.data.sources.atomikos.config.db;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zjx
 * @version 1.0
 * @date 2020/6/21 21:20
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.db2")
public class Db2Config {
    private String url;
    private String username;
    private String password;
    private int minPoolSize;
    private int maxPoolSize;
    private int maxLifetime;
    private int borrowConnectionTimeout;
    private int loginTimeout;
    private int maintenanceInterval;
    private int maxIdleTime;
}
