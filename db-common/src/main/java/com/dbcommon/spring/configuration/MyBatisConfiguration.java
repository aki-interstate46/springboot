package com.dbcommon.spring.configuration;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * DBを接続するクラス
 * 
 * @author Y.AKI
 * @version 1.0.0
 */
@Configuration
@EnableTransactionManagement // アノテーション駆動(@Transactional)のトランザクション制御を有効
@MapperScan(value = { "com.dbcommon.mybatis.springbootproject01" })
public class MyBatisConfiguration {
	
	// Bean定義必須① データソース
	@Bean("datasource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create()
		    .build();
	}
	
	// Bean定義必須② SqlSessionFactoryBean
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("datasource") DataSource dataSource) {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		return sessionFactoryBean;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(@Qualifier("datasource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
