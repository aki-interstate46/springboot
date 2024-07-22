package com.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.jobcommon.startup.JobRunner;
import com.systemcommon.util.FQCNBeanNameGenerator;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.job.spring"
		, "com.dbcommon.spring"
		, "com.jobcommon.spring"
		, "com.systemcommon.spring"
		} , nameGenerator = FQCNBeanNameGenerator.class)
//@MapperScan(value = {"com.dbcommon.mybatis.springbootproject01"})
public class JobApplication extends JobRunner {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(JobApplication.class);
		start(application, args);
		run(application, args);
		end(application, args);
	}

//    //ここから追加
//    //Bean定義必須① データソース
//    @Bean
//    public DataSource dataSource() {
//        return DataSourceBuilder.create()
//        		.driverClassName("org.mariadb.jdbc.Driver")
//                .url("jdbc:mysql://localhost:13306/spring_boot_project_01?permitMysqlScheme")
//                .username("root")
//                .password("root")
//                .build();
//    }
//
//
//    //Bean定義必須② SqlSessionFactoryBean
//    @Bean
//    public SqlSessionFactoryBean sqlSessionFactory() {
//        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource());
//        return sessionFactoryBean;
//    }
//
// 
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }
}
