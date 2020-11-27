package by.grodno.pvt.site.webappsample.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
@EnableConfigurationProperties({ DataSourceProperties.class, HibernateProperties.class })
public class JPAConfiguration {

	@Bean
	public DataSource dataSource(DataSourceProperties config) {
		BasicDataSource singleConnectionDataSource = new BasicDataSource();

		singleConnectionDataSource.setDriverClassName(config.getDriverClassName());
		singleConnectionDataSource.setUrl(config.getUrl());
		singleConnectionDataSource.setUsername(config.getUser());
		singleConnectionDataSource.setPassword(config.getPassword());
		singleConnectionDataSource.setInitialSize(5);
		singleConnectionDataSource.setMaxTotal(20);

		return singleConnectionDataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean sessionProvider(DataSource ds, HibernateProperties hiberConfig) {

		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		Properties props = new Properties();

		props.putAll(hiberConfig.getJpaProperties());

		localContainerEntityManagerFactoryBean.setJpaProperties(props);
		localContainerEntityManagerFactoryBean.setDataSource(ds);
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		localContainerEntityManagerFactoryBean.setPackagesToScan("by.grodno.pvt.site.webappsample.domain");

		return localContainerEntityManagerFactoryBean;
	}

	@Bean
	public PlatformTransactionManager txManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	@Bean
	public TransactionTemplate template(PlatformTransactionManager ptm) {
		return new TransactionTemplate(ptm);
	}
}
