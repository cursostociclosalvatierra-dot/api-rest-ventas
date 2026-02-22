package pe.edu.cibertec.api_rest_ventas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ApiRestVentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestVentasApplication.class, args);
	}
	
	@Bean
	WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/v1/**")
				.allowedMethods("GET", "POST", "PUT", "PATCH")
				//.allowedOrigins("http://localhost:4200/");
				.allowedOrigins("*");
			}
					
		};
	}

}
