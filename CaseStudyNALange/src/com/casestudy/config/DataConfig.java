package com.casestudy.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableSpringDataWebSupport
@EnableTransactionManagement
@EnableJpaRepositories("com.casestudy.repository")
@PropertySource("classpath:casestudy.properties") 
public class DataConfig {
	

	    @Autowired
	    Environment environment;


	    /************* Start Spring JPA config details **************/
	    @Bean(name = "entityManagerFactory")
	    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() { //creating instance of emf
	        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
	        lcemfb.setJpaVendorAdapter(getJpaVendorAdapter());  ///shows what we are using 
	        ///JDBC
	        lcemfb.setDataSource(dataSource());
	        lcemfb.setPersistenceUnitName("CSPersistenceUnit");
	        lcemfb.setPackagesToScan("com.casestudy.model");
	        //Hibernate
	        lcemfb.setJpaProperties(hibernateProperties());
	        return lcemfb;
	    }

	    @Bean
	    public JpaVendorAdapter getJpaVendorAdapter() {
	        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	        return adapter;
	    }

	    @Bean(name = "transactionManager")
	    public PlatformTransactionManager txManager() {
	        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(
	                getEntityManagerFactoryBean().getObject());
	        return jpaTransactionManager;
	    }

	    /************* End Spring JPA config details **************/

	    //JDBC
	    
	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driver"));
	        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
	        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
	        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
	        return dataSource;
	    }
	//HIbernate properties
	    private Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect",
	                environment.getRequiredProperty("hibernate.dialect"));//constant DIALECT
	        properties.put("hibernate.show_sql",
	                environment.getRequiredProperty("hibernate.show_sql"));//constant SHOW_SQL
	        properties.put("hibernate.format_sql",
	                environment.getRequiredProperty("hibernate.format_sql"));// constant FORAT_SQL
	        properties.put("hibernate.hbm2ddl.auto",
	                environment.getRequiredProperty("hibernate.hbm2ddl.auto"));//
	        properties.put("hibernate.enable_lazy_load_no_trans",
	                environment.getRequiredProperty("hibernate.enable_lazy_load_no_trans"));
	        return properties;
	    }
	}




