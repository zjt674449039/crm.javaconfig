package com.hihihigh.crm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.ComponentScan.Filter;*/
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
		"com.hihihigh.crm.controller" }/*
										 * , excludeFilters={@Filter(type=FilterType.ANNOTATION, value=Service.class)}
										 */)
public class ServletConfig extends WebMvcConfigurerAdapter {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("easyUi/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	/**
	 * 此时会注册一个默认的Handler：DefaultServletHttpRequestHandler，
	 * 这个Handler也是用来处理静态文件的，它会尝试映射/*。当DispatcherServelt映射/时（/ 和/*
	 * 是有区别的），并且没有找到合适的Handler来处理请求时，就会交给DefaultServletHttpRequestHandler
	 * 来处理。注意：这里的静态资源是放置在web根目录下，而非WEB-INF 下。
	 * 可能这里的描述有点不好懂（我自己也这么觉得），所以简单举个例子，例如：在webroot目录下有一个图片：1.png
	 * 我们知道Servelt规范中web根目录（webroot）下的文件可以直接访问的， 但是由于DispatcherServlet配置了映射路径是：/
	 * ，它几乎把所有的请求都拦截了，从而导致1.png 访问不到，这时注册一个 DefaultServletHttpRequestHandler
	 * 就可以解决这个问题。其实可以理解为DispatcherServlet破坏了Servlet的一个特性
	 * （根目录下的文件可以直接访问），DefaultServletHttpRequestHandler是帮助回归这个特性的。
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/*
	 * @Bean public MultipartResolver multipartResolver(){ return new
	 * StandardServletMultipartResolver(); }
	 */

	@Bean(name = "multipartResolver")
	protected CommonsMultipartResolver MultipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		// multipartResolver.setUploadTempDir(new FileSystemResource("/tmp"));//可不设置
		multipartResolver.setMaxUploadSize(2097152);// 2M
		multipartResolver.setMaxInMemorySize(0);
		multipartResolver.setDefaultEncoding("UTF-8");
		return multipartResolver;
	}

	// 静态资源加载映射
	/*
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * registry.addResourceHandler("/js/**") .addResourceLocations( "/js/"); }
	 */
}
