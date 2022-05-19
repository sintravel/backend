package backend.sintravel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SintravelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SintravelApplication.class, args);
	}

}
