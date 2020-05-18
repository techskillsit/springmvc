package com.springsecurity;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[]{ SecurityConfig.class, DBConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[]{ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		String[] str = new String[]{"/"};
		return str;
	}

}
