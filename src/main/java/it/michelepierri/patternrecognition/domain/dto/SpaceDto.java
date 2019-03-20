package it.michelepierri.patternrecognition.domain.dto;

import java.util.Set;

public class SpaceDto {

	Set<PointDto> spaceOfPoints;

	public Set<PointDto> getSpaceOfPoints() {
		return spaceOfPoints;
	}

	public void setSpaceOfPoints(Set<PointDto> spaceOfPoints) {
		this.spaceOfPoints = spaceOfPoints;
	}
}
