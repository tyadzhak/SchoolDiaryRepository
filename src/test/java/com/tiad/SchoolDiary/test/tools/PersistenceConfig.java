package com.tiad.SchoolDiary.test.tools;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.tiad.SchoolDiary" })
public class PersistenceConfig {
	
	@Bean(name="transactionManager")
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		System.out.println("transactionManager");
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}

	@Bean(name="exceptionTranslation")
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		System.out.println("exceptionTranslation");
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean(name="sessionFactory")
	public LocalSessionFactoryBean sessionFactory() {
		System.out.println("sessionFactoryTest");
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(restDataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.tiad.SchoolDiary" });
		sessionFactory.setHibernateProperties(hibernateConfiguration().getProperties());
		return sessionFactory;
	}

	@Bean(name="restDataSource")
	public DataSource restDataSource() {
		System.out.println("restDataSourceTest");
		org.hibernate.cfg.Configuration testCfg = hibernateConfiguration();
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(testCfg.getProperty("hibernate.connection.driver_class"));
		dataSource.setUrl(testCfg.getProperty("hibernate.connection.url"));
		dataSource.setUsername(testCfg.getProperty("hibernate.connection.username"));
		dataSource.setPassword(testCfg.getProperty("hibernate.connection.password"));
		return dataSource;
	}

	@Bean(name="hibernateConfiguration")
	public org.hibernate.cfg.Configuration hibernateConfiguration() {
		System.out.println("hibernateConfigurationTest");
		return new org.hibernate.cfg.Configuration().configure("hsqldb.cfg.xml");
	}
}
