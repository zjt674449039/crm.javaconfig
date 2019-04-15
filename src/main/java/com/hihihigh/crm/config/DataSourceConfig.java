package com.hihihigh.crm.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource(value="classpath:jdbc.properties"
	,ignoreResourceNotFound=true)
@EnableTransactionManagement
public class DataSourceConfig implements EnvironmentAware{

	private Environment environment;
	
	private final static Logger LOG = Logger.getLogger(DataSourceConfig.class);

	@Bean
	public DataSource dbcpDataSource() {
		String driverClassName = environment
				.getRequiredProperty("spring.datasource.driverClassName");
		String dbUrl = environment
				.getRequiredProperty("spring.datasource.url");
		String username = environment
				.getRequiredProperty("spring.datasource.username");
		String password = environment
				.getRequiredProperty("spring.datasource.password");
		int initialSize = environment
				.getRequiredProperty("spring.datasource.initialSize",Integer.class);
		int maxActive = environment
				.getRequiredProperty("spring.datasource.maxActive",Integer.class);
		LOG.info("Initialize the data source...");
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setInitialSize(initialSize);
		dataSource.setMaxActive(maxActive);
		/*dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/crm");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		dataSource.setInitialSize(10);
		dataSource.setMaxActive(20);*/
		return dataSource;
	}

	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource) {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
	}

	/*@Bean(name="transactionInterceptor")
	public TransactionInterceptor interceptor() {
		TransactionInterceptor interceptor = new TransactionInterceptor();
		interceptor.setTransactionManager(transactionManager());

		Properties transactionAttributes = new Properties();
		transactionAttributes.setProperty("save*", "PROPAGATION_REQUIRED");
		transactionAttributes.setProperty("del*", "PROPAGATION_REQUIRED");
		transactionAttributes.setProperty("update*", "PROPAGATION_REQUIRED");
		transactionAttributes.setProperty("get*", "PROPAGATION_REQUIRED,readOnly");
		transactionAttributes.setProperty("find*", "PROPAGATION_REQUIRED,readOnly");
		transactionAttributes.setProperty("*", "PROPAGATION_REQUIRED");

		interceptor.setTransactionAttributes(transactionAttributes);
		return interceptor;
	}*/

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer msc = new MapperScannerConfigurer();
		msc.setBasePackage("com.hihihigh.crm.dao");
		return msc;
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
		ResourcePatternResolver rpr = new PathMatchingResourcePatternResolver();
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource);
		ssf.setConfigLocation(rpr.getResource("classpath:mybatis-config.xml"));
		ssf.setMapperLocations(rpr.getResources("classpath:com/hihihigh/crm/mapper/*.xml"));
		ssf.setTypeAliasesPackage("com.hihihigh.crm.model");
		return ssf;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment=environment;
	}

	/*@Bean
	public TransactionTemplate transactionTemplate(){
		TransactionTemplate transactionTemplate =
				new TransactionTemplate();
		transactionTemplate.setTransactionManager(transactionManager());
		return transactionTemplate;
	}*/
	
}
