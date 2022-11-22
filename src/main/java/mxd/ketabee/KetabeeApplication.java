package mxd.ketabee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import mxd.ketabee.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class KetabeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KetabeeApplication.class, args);
	}

}
