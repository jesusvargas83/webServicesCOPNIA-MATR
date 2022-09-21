package co.gov.integrador.carpetaCiudadana.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "co.gov.integrador.carpetaCiudadana", exclude = {DataSourceAutoConfiguration.class })
public class CarpetaCiudadanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarpetaCiudadanaApplication.class, args);
	}

}