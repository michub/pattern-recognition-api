package it.michelepierri.patternrecognition.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "it.michelepierri.patternrecognition.controller.impl",
								"it.michelepierri.patternrecognition.service.impl", 
								"it.michelepierri.patternrecognition.repository.impl" })
public class RecognitionConfiguration {

}
