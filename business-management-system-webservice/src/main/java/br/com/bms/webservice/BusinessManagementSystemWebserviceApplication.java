package br.com.bms.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EntityScan(basePackages = "br.com.bms.webservice.domain.model")
@ComponentScan(basePackages = "br.com.bms.*")
@EnableJpaRepositories(basePackages = "br.com.bms.webservice.domain.repository")
@EnableTransactionManagement
@EnableWebMvc
@RestController
@EnableAutoConfiguration
public class BusinessManagementSystemWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessManagementSystemWebserviceApplication.class, args);
	}

}
