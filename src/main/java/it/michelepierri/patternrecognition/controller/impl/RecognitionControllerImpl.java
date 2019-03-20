package it.michelepierri.patternrecognition.controller.impl;

import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.michelepierri.patternrecognition.controller.RecognitionController;
import it.michelepierri.patternrecognition.domain.dto.LineDto;
import it.michelepierri.patternrecognition.domain.dto.PointDto;
import it.michelepierri.patternrecognition.domain.dto.SpaceDto;
import it.michelepierri.patternrecognition.service.RecognitionService;

@Controller("recognitionController")
public class RecognitionControllerImpl implements RecognitionController {

	@Autowired
	private RecognitionService service;
	
	@RequestMapping("/")
	public String getIndex() {
		return "Greetings from Pattern-recognition-api!";
	}

	@RequestMapping("/")
	public void addPoint(PointDto point) {
		Objects.requireNonNull(point, "point can't be null");
		service.addPoint(point);
	}

	@RequestMapping("/")
	public SpaceDto getSpace() {
		return service.getSpace();
	}

	@RequestMapping("/")
	public Set<LineDto> getLines() {
		return service.getLines();
	}

	@RequestMapping("/")
	public int deleteSpace() {
		return service.deleteSpace();
	}

}
