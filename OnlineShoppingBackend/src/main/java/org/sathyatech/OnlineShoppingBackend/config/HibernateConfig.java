package org.sathyatech.OnlineShoppingBackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"org.sathyatech.OnlineShoppingBackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

	//Change the below based on the DBMS you choose
	private final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/test";
	private final static String DATABASE_DRIVER="org.h2.Driver";
	private final static String DATABASE_USERNAME="sa";
	private final static String DATABASE_PASSWORD="";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	
	//datasource will be available
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource=new BasicDataSource();
		//Providing the database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}
	
	//SessionFactory will be available
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(dataSource);
		localSessionFactoryBuilder.addProperties(gethibernateProperties());
		localSessionFactoryBuilder.scanPackages("org.sathyatech.OnlineShoppingBackend.dto");
		return localSessionFactoryBuilder.buildSessionFactory();
	}

	//All the hibernate properties will be return in this method
	private Properties gethibernateProperties() {
		Properties p=new Properties();
		p.put("hibernate.dialect", DATABASE_DIALECT);
		p.put("hibernate.show_sql", "true");
		p.put("hibernate.format_sql", "true");
		return p;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
		
	}
}
