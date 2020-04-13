package ma.cs.dolibar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DolibarApplication {

	public static void main(String[] args) {
		SpringApplication.run(DolibarApplication.class, args);
	}

}
