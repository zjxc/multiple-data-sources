package com.zjx.multiple.data.sources.atomikos.config.db;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author zjx
 * @version 1.0
 * @date 2020/6/21 21:20
 */
@Configuration
@MapperScan(basePackages = "com.zjx.multiple.data.sources.atomikos.mapper.db2", sqlSessionFactoryRef = "db2SqlSessionFactory")
public class Db2DataSourcesConfig {

    @Bean(name = "db2DataSources")
    public DataSource db2DataSource(Db2Config db2Config) throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(db2Config.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(db2Config.getPassword());
        mysqlXaDataSource.setUser(db2Config.getUsername());
        // 将本地事务注册到创 Atomikos全局事务
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXaDataSource);
        atomikosDataSourceBean.setUniqueResourceName("db2DataSources");

        atomikosDataSourceBean.setMinPoolSize(db2Config.getMinPoolSize());
        atomikosDataSourceBean.setMaxPoolSize(db2Config.getMaxPoolSize());
        atomikosDataSourceBean.setMaxLifetime(db2Config.getMaxLifetime());
        atomikosDataSourceBean.setBorrowConnectionTimeout(db2Config.getBorrowConnectionTimeout());
        atomikosDataSourceBean.setLoginTimeout(db2Config.getLoginTimeout());
        atomikosDataSourceBean.setMaintenanceInterval(db2Config.getMaintenanceInterval());
        atomikosDataSourceBean.setMaxIdleTime(db2Config.getMaxIdleTime());
//        xaDataSource.setTestQuery(db1Config.getTestQuery());
        return atomikosDataSourceBean;
    }


    @Bean(name = "db2SqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("db2DataSources") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/db2/*.xml"));

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        // 日志输出
        configuration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);
        sessionFactoryBean.setConfiguration(configuration);
        return sessionFactoryBean.getObject();
    }

    @Bean(name = "db2SqlSessionTemplate")
    public SqlSessionTemplate masterSqlSessionTemplate(
            @Qualifier("db2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
