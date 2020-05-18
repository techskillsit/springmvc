package com.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages={"com.springsecurity"})
@EnableWebMvc
public class ServletConfig implements WebMvcConfigurer{

	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver veiwResolver = new InternalResourceViewResolver();
		veiwResolver.setPrefix("/WEB-INF/jsps/");
		veiwResolver.setSuffix(".jsp");
		return veiwResolver;
	}
}
