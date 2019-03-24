package it.michelepierri.patternrecognition.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = { 
		"it.michelepierri.patternrecognition.controller",
		"it.michelepierri.patternrecognition.service",
		"it.michelepierri.patternrecognition.repository" 
})
public class RecognitionConfiguration {
	public static void main(String[] args) {
        SpringApplication.run(RecognitionConfiguration.class, args);
    }
}