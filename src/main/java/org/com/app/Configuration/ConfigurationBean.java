package org.com.app.Configuration;

import javax.sql.DataSource;

import org.com.app.metier.EmpTraitement;
import org.com.app.web.EmployController;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
@ComponentScan({ "org.com.app" })
@EnableTransactionManagement

public class ConfigurationBean {

	// public Empl

	@Autowired
	private DataSource dataSource;
	@Autowired
	private Environment environment;

	@Bean
	public DataSourceConnectionProvider connectionProvider() {
		return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(dataSource));
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/aaemplgestion");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}

	@Bean
	public DefaultDSLContext dsl() {
		return new DefaultDSLContext(configuration());
	}

	@Bean
	public DefaultConfiguration configuration() {
		DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
		jooqConfiguration.set(SQLDialect.MYSQL_5_7);
		jooqConfiguration.set(connectionProvider());
		return jooqConfiguration;
	}

	@Bean
	public EmpTraitement empTraitementConf() {
		return new EmpTraitement(dsl());
	}

	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		return new RequestMappingHandlerMapping();
	}
}
