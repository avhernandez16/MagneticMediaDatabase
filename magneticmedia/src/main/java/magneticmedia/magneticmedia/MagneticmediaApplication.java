package magneticmedia.magneticmedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MagneticmediaApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MagneticmediaApplication.class, args);
	}
	@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
			return builder.sources(MagneticmediaApplication.class);
		}
}

