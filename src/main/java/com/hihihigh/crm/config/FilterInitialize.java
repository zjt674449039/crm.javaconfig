package com.hihihigh.crm.config;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

public class FilterInitialize implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		Dynamic filter = 
				servletContext.addFilter("myFilter", MyFilter.class);
		filter.addMappingForUrlPatterns(null, false, "/*");
	}

}
