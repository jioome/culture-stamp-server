package com.culturestamp.back;

import com.culturestamp.back.auth.config.properties.AppProperties;
import com.culturestamp.back.auth.config.properties.CorsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableConfigurationProperties({
		CorsProperties.class,
		AppProperties.class
})
@EnableJpaAuditing
@SpringBootApplication
public class CultureStampBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(CultureStampBackApplication.class, args);
	}

}
