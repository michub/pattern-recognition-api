package it.michelepierri.patternrecognition.repository.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import it.michelepierri.patternrecognition.domain.dto.LineDto;
import it.michelepierri.patternrecognition.domain.dto.PointDto;
import it.michelepierri.patternrecognition.exception.InvalidLineException;
import it.michelepierri.patternrecognition.repository.RecognitionRepository;

@Repository("recognitionRepository")
public class RecognitionRepositoryImpl implements RecognitionRepository {

	private static Logger log = LoggerFactory.getLogger(RecognitionRepositoryImpl.class);

	private Set<PointDto> pointsSpace;
	private Map<Integer, List<LineDto>> lines;

	public RecognitionRepositoryImpl() {
		init();
	}

	@Override
	public void init() {
		this.pointsSpace = new HashSet<>();
		this.lines = new HashMap<>();
	}

	@Override
	public void addPoint(PointDto point) {
		log.info("Adding point {} to plane", point);
		Objects.requireNonNull(point, "point must not be null");
		
		if (!pointsSpace.contains(point)) {
			recomputeLines(point);
			this.pointsSpace.add(point);
		}
	}

	@Override
	public Set<PointDto> getPointsSpace() {
		return this.pointsSpace;
	}

	@Override
	public List<LineDto> getLinesWithCollinearPoints(int n) {
		return this.lines.entrySet().
				stream().filter(
				
						v -> v.getKey() >= n
				
				)
				.map(Map.Entry::getValue)
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
	}

	private static LineDto of(PointDto... points) throws InvalidLineException {

		final Set<PointDto> pointSet = Stream.of(points).filter(Objects::nonNull).collect(Collectors.toSet());

		if (pointSet.size() < 2) {
			throw new InvalidLineException("At least two points are required to draw a line");
		}

		return new LineDto(pointSet);
	}

	private void recomputeLines(final PointDto point) {
		Map<Integer, List<LineDto>> lines = new HashMap<>();

		this.lines.values().stream().flatMap(Collection::stream).forEach(line -> {
			if (isPointCollinearToLine(point, line)) {
				line.addPoint(point);
			}
			List<LineDto> lineList = lines.get(line.getAllPoints().size());
			if (lineList == null) {
				lineList = new ArrayList<>();
			}
			lineList.add(line);

			log.info("Recomputing line {}", line);
			lines.put(line.getAllPoints().size(), lineList);
		});

		this.lines = lines;
		drawNewLines(point);
	}

	private boolean isPointCollinearToLine(final PointDto p, final LineDto line) {
		final List<PointDto> linePoints = line.getAllPoints();
		final PointDto p1 = linePoints.get(0);
		final PointDto p2 = linePoints.get(1);

		double result = (p2.getY() - p1.getY()) * p.getX();
		result += (p1.getX() - p2.getX()) * p.getY();
		result += (p2.getX() * p1.getY() - p1.getX() * p2.getY());

		return result == 0d;
	}

	private void drawNewLines(final PointDto point) {
		final List<LineDto> twoPointsLine;
		if (this.lines.get(2) != null) {
			twoPointsLine = this.lines.get(2);
		} else {
			twoPointsLine = new ArrayList<>();
		}

		this.pointsSpace.forEach(p -> {
			if (!alreadyInLine(point, p)) {
				log.info("Drawing new line between point {} and {}", point, p);
				try {
					LineDto line = of(point, p);
					twoPointsLine.add(line);
				} catch (InvalidLineException e) {
					throw new RuntimeException(e);
				}
			}
		});

		if (!twoPointsLine.isEmpty()) {
			this.lines.put(2, twoPointsLine);
		}
	}

	private boolean alreadyInLine(PointDto p1, PointDto p2) {
		List<PointDto> points = new ArrayList<>();
		points.add(p1);
		points.add(p2);

		return this.lines.values().stream().flatMap(Collection::stream)
				.anyMatch(line -> line.getAllPoints().containsAll(points));
	}

}
