package it.michelepierri.patternrecognition.service;

import java.util.List;
import java.util.Set;

import it.michelepierri.patternrecognition.domain.dto.LineDto;
import it.michelepierri.patternrecognition.domain.dto.PointDto;

public interface RecognitionService {

	/**
	 * @param point
	 */
	public void addPoint(PointDto point);
	
	/**
	 * @param n 
	 * @return
	 */
	public List<List<PointDto>> getLines(int n);
	
	/**
	 * 
	 */
	public void deleteSpace();

	/**
	 * @return
	 */
	public Set<PointDto> getSpace();
}
