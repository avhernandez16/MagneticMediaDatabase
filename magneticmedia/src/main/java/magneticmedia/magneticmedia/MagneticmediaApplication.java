package magneticmedia.magneticmedia;

import magneticmedia.magneticmedia.services.PasswordHashingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MagneticmediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagneticmediaApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
}
