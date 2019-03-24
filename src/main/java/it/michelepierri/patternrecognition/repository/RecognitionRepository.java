package it.michelepierri.patternrecognition.repository;

import java.util.List;
import java.util.Set;

import it.michelepierri.patternrecognition.domain.dto.LineDto;
import it.michelepierri.patternrecognition.domain.dto.PointDto;

public interface RecognitionRepository {

	/**
	 * @param point
	 */
	public void addPoint(PointDto point);
	
	/**
	 * @return
	 */
	void init();

	/**
	 * @return
	 */
	public Set<PointDto> getPointsSpace();

	List<LineDto> getLinesWithCollinearPoints(int n);
}
