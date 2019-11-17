package com.springhibernate.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{HibernateJpaConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// define the class for dispatcher servlet config 
		return new Class[]{ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// This is request mapping
		String[] s = new String[]{"/"};
		return s;
	}

}
