package com.springhibernate.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.springhibernate" })
@EnableJpaRepositories(basePackages = "com.springhibernate.repository")
public class HibernateJpaConfig {
	 @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	        entityManagerFactoryBean.setDataSource(dataSource());
	        entityManagerFactoryBean.setPackagesToScan(new String[] { "com.springhibernate.model" });

	        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
	        entityManagerFactoryBean.setJpaProperties(additionalProperties());
	        return entityManagerFactoryBean;
	    }

	    final Properties additionalProperties() {
	        final Properties hibernateProperties = new Properties();
	        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
	        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	        return hibernateProperties;
	    }
	    
	    @Bean
	    public DataSource dataSource() {
	        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/demo");
	        dataSource.setUsername("root");
	        dataSource.setPassword("");
	        return dataSource;
	    }

	    @Bean
	    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
	        final JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(emf);
	        return transactionManager;
	    }
}
