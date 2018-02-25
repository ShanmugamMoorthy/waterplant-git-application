/**
 * 
 */
package org.we5.waterplant.v1.jpa.persistence;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author KARNA
 *
 */
@Component
@Configuration
@PropertySource({ "classpath:persistence-db.properties" })
@EnableJpaRepositories(basePackages = "org.we5.waterplant.v1", entityManagerFactoryRef = "entityManager", transactionManagerRef = "transactionManager")
public class PersistenceContext {

	@Autowired
	private Environment env;

	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManager() {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(dataSource());
		entityManager.setPackagesToScan(new String[] {"org.we5.waterplant.v1"});

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManager.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		entityManager.setJpaPropertyMap(properties);

		return entityManager;
	}

	@Primary
	@Bean
	/**
	 * Method to populate the datasource by loading the persistence-db properties
	 * 
	 * @return DataSource
	 */
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));

		return dataSource;
	}

	@Primary
	@Bean
	/**
	 * Setting transaction manager
	 * 
	 * @return
	 */
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManager().getObject());
		return transactionManager;
	}
}