package mg.giz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import mg.giz.commun.StorageProperties;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class GizDevApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GizDevApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(GizDevApplication.class);
	}
}
