package com.hihihigh.crm.config;

/*import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.context.annotation.FilterType;*/
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * 发生的
 * 
 * @author victor
 *
 */
@Configuration
@ComponentScan(basePackages={ 
		"com.hihihigh.crm.service.impl","com.hihihigh.crm.config" }/*,
		excludeFilters={@Filter(type=FilterType.ANNOTATION,
						value=EnableWebMvc.class)}*/)
@Import(DataSourceConfig.class)
public class RootConfig {
	
	/*@Bean
	public BeanNameAutoProxyCreator proxycreate() {
		BeanNameAutoProxyCreator proxycreate = new BeanNameAutoProxyCreator();
		proxycreate.setProxyTargetClass(true);
		proxycreate.setBeanNames("*ServiceImpl");
		proxycreate.setInterceptorNames("transactionInterceptor");
		return proxycreate;
	}*/
}
