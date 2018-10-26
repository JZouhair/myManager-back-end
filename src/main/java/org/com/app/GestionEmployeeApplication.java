package org.com.app;

import org.com.app.metier.EmpTraitement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement

public class GestionEmployeeApplication {

	@Autowired
	private static EmpTraitement emptr;

	
	public static void setEmptr(EmpTraitement emptr) {
		GestionEmployeeApplication.emptr = emptr;
	}

	
	
	public static void main(String[] args) {
		SpringApplication.run(GestionEmployeeApplication.class, args);
		
	}
}
