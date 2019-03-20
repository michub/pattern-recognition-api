package it.michelepierri.patternrecognition.repository;

import java.util.Set;

import it.michelepierri.patternrecognition.domain.dto.LineDto;
import it.michelepierri.patternrecognition.domain.dto.PointDto;
import it.michelepierri.patternrecognition.domain.dto.SpaceDto;

public interface RecognitionRepository {

	/**
	 * @param point
	 */
	public void addPoint(PointDto point);
	
	/**
	 * @return
	 */
	public SpaceDto getSpace();
	
	/**
	 * @return
	 */
	public Set<LineDto> getLines();
	
	/**
	 * @return
	 */
	public int deleteSpace();
}
