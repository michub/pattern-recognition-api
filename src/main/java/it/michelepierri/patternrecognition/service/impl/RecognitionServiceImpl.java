package it.michelepierri.patternrecognition.service.impl;

import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.michelepierri.patternrecognition.domain.dto.LineDto;
import it.michelepierri.patternrecognition.domain.dto.PointDto;
import it.michelepierri.patternrecognition.domain.dto.SpaceDto;
import it.michelepierri.patternrecognition.repository.RecognitionRepository;
import it.michelepierri.patternrecognition.service.RecognitionService;

@Service("recognitionService")
public class RecognitionServiceImpl implements RecognitionService{

	@Autowired
	RecognitionRepository repository;
	
	public void addPoint(PointDto point) {
		Objects.requireNonNull(point, "point can't be null");
		repository.addPoint(point);
	}

	public SpaceDto getSpace() {
		return repository.getSpace();
	}

	public Set<LineDto> getLines() {
		return repository.getLines();
	}

	public int deleteSpace() {
		return repository.deleteSpace();
	}

}
