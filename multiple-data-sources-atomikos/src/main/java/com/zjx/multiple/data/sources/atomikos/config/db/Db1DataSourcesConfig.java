package com.zjx.multiple.data.sources.atomikos.config.db;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author zjx
 * @version 1.0
 * @date 2020/6/21 21:05
 */
@Configuration
@MapperScan(basePackages = "com.zjx.multiple.data.sources.atomikos.mapper.db1", sqlSessionFactoryRef = "db1SqlSessionFactory")
public class Db1DataSourcesConfig {

    @Bean(name = "db1DataSources")
    @Primary
    public DataSource db1DataSource(Db1Config db1Config) throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(db1Config.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(db1Config.getPassword());
        mysqlXaDataSource.setUser(db1Config.getUsername());
        // 将本地事务注册到创 Atomikos全局事务
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("db1DataSources");

        xaDataSource.setMinPoolSize(db1Config.getMinPoolSize());
        xaDataSource.setMaxPoolSize(db1Config.getMaxPoolSize());
        xaDataSource.setMaxLifetime(db1Config.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(db1Config.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(db1Config.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(db1Config.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(db1Config.getMaxIdleTime());
//        xaDataSource.setTestQuery(db1Config.getTestQuery());
        return xaDataSource;
    }

    @Primary
    @Bean(name = "db1SqlSessionFactory")
    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db1DataSources") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/db1/*.xml"));

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        // 日志输出
        configuration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);
        sessionFactoryBean.setConfiguration(configuration);
        return sessionFactoryBean.getObject();
    }

    @Bean(name = "db1SqlSessionTemplate")
    public SqlSessionTemplate masterSqlSessionTemplate(
            @Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
