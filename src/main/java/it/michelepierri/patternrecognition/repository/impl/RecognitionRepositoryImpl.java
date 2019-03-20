package it.michelepierri.patternrecognition.repository.impl;

import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.michelepierri.patternrecognition.domain.dto.LineDto;
import it.michelepierri.patternrecognition.domain.dto.PointDto;
import it.michelepierri.patternrecognition.domain.dto.SpaceDto;
import it.michelepierri.patternrecognition.repository.RecognitionRepository;

@Repository("recognitionRepository")
public class RecognitionRepositoryImpl implements RecognitionRepository{

	@Autowired
	DataSource datasource;
	
	public void addPoint(PointDto point) {
		// TODO Auto-generated method stub
		
	}

	public SpaceDto getSpace() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<LineDto> getLines() {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteSpace() {
		// TODO Auto-generated method stub
		return 0;
	}

}
