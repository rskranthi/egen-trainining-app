package io.egen.app;


import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.logging.SessionLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class JpaConfig {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFatory()
	{
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("io.egen.app.entity");
		emf.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
		emf.setJpaProperties(jpaProperties());
		
		return emf;
		
	}

	@Bean
	public PlatformTransactionManager txManager(EntityManagerFactory emf)
	{
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(emf);
		return txManager;
		
	}
	
	private Properties jpaProperties() {
		// TODO Auto-generated method stub
		
		Properties props = new Properties();
		props.setProperty(PersistenceUnitProperties.DDL_DATABASE_GENERATION, PersistenceUnitProperties.DROP_AND_CREATE);
		props.setProperty(PersistenceUnitProperties.LOGGING_LEVEL, SessionLog.FINE_LABEL);
		props.setProperty(PersistenceUnitProperties.WEAVING,"false");
		return props;
	}

	@Bean
	public DataSource dataSource() {
		// TODO Auto-generated method stub
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/employee-db");
		dataSource.setPassword("X9pgptjaud6@");
		dataSource.setUsername("root");
		return dataSource;
	}
	
	

}
