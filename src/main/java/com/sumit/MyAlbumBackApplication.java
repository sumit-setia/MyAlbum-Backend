package com.sumit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.sumit.config.JwtFilter;

@SpringBootApplication
public class MyAlbumBackApplication {

	@Bean
	public FilterRegistrationBean jwtFiler() {
		final FilterRegistrationBean registrationBean =new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/rest/*");
		return registrationBean;
	}
	public static void main(String[] args) {
		SpringApplication.run(MyAlbumBackApplication.class, args);
	}
}
