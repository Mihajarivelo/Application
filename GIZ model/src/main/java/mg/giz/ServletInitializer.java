package mg.giz;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// @Configuration
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GizDevApplication.class);
	}

	/*
	 * @Bean
	 * 
	 * @Order(Ordered.HIGHEST_PRECEDENCE) CharacterEncodingFilter
	 * characterEncodingFilter() { CharacterEncodingFilter filter = new
	 * CharacterEncodingFilter(); filter.setEncoding("UTF-8");
	 * filter.setForceEncoding(true); return filter; }
	 */

}
