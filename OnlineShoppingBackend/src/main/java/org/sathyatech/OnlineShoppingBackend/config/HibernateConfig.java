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

	private final static String DATABASE_URL="jdbc:mysl://localhost:3306/abc";
	private final static String DATABASE_DRIVER="com.mysql.cj.jdbc.Driver";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.MySQL5Dialect";
	private final static String DATABASE_USERNAME="root";
	private final static String DATABASE_PASSWORD="27041995";
	
	@Bean
	public DataSource getDataSource(){
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName(DATABASE_DRIVER);
		ds.setUrl(DATABASE_URL);
		ds.setUsername(DATABASE_USERNAME);
		ds.setPassword(DATABASE_PASSWORD);
		return ds;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sf=new LocalSessionFactoryBuilder(dataSource);
		sf.addProperties(getHibernateProperties());
		sf.scanPackages("org.sathyatech.OnlineShoppingBackend.dto");
		return sf.buildSessionFactory();
	}
	
	private Properties getHibernateProperties() {
		Properties p=new Properties();
		p.put("hibernate_dialect", DATABASE_DIALECT);
		p.put("hibernate.show_sql", "true");
		p.put("hibernate.format_sql", "true");
		//p.put("hibenate.hbm2ddl.auto", "update");
		return p;
	}
	
	@Bean
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager htm=new HibernateTransactionManager(sessionFactory);
		return htm;
	}
}
