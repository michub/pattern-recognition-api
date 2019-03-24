package it.michelepierri.patternrecognition.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.michelepierri.patternrecognition.domain.dto.PointDto;
import it.michelepierri.patternrecognition.repository.RecognitionRepository;
import it.michelepierri.patternrecognition.service.RecognitionService;

@Service("recognitionService")
public class RecognitionServiceImpl implements RecognitionService{

	@Autowired
	RecognitionRepository repository;
	
    private Function<PointDto, PointDto> pointDtoMapper = 
    		p -> new PointDto(p.getX(), p.getY());

	public void addPoint(PointDto point) {
		Objects.requireNonNull(point, "point can't be null");
		repository.addPoint(point);
	}

	public List<List<PointDto>> getLines(int n) {
		return this.repository.getLinesWithCollinearPoints(n)
                .stream()
                .map(l -> l.getAllPoints()
                        .stream()
                        .map(pointDtoMapper)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
	}

	public void deleteSpace() {
		repository.init();
	}

	@Override
	public Set<PointDto> getSpace() {
		return repository.getPointsSpace();
	}

}
