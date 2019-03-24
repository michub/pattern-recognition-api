package it.michelepierri.patternrecognition.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import it.michelepierri.patternrecognition.domain.dto.LineDto;
import it.michelepierri.patternrecognition.domain.dto.PointDto;

public interface RecognitionController {

	/**
	 * @param point
	 */
	public void addPoint(PointDto point);
	
	/**
	 * @return
	 */
	public Set<PointDto> getSpace();
	
	/**
	 * @return
	 */
	public ResponseEntity getLines(int n);
	
	/**
	 * @return
	 */
	public void deleteSpace();
	
}
