package com.recorder.audiorecorderbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AudioRecorderBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AudioRecorderBeApplication.class, args);
	}

	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/record").allowedOrigins("http://localhost:3000");
			}
		};
	}

}
