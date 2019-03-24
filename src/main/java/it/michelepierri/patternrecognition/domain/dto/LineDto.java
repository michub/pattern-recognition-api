package it.michelepierri.patternrecognition.domain.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LineDto {

	private Set<PointDto> points;
	
	public LineDto(Set<PointDto> points) {
		this.points = points;
	}

	public void addPoint(PointDto point) {
		if(points==null)
			points = new HashSet<>();
		points.add(point);
	}

	public List<PointDto> getAllPoints() {
		return new ArrayList<>(points);
	}

}
