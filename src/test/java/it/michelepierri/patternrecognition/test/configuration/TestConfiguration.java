package it.michelepierri.patternrecognition.test.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = { 
		"it.michelepierri.patternrecognition.controller",
		"it.michelepierri.patternrecognition.service",
		"it.michelepierri.patternrecognition.repository" 
})
@Configuration
public class TestConfiguration {

}
