package it.michelepierri.patternrecognition.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import it.michelepierri.patternrecognition.domain.dto.LineDto;
import it.michelepierri.patternrecognition.domain.dto.PointDto;
import it.michelepierri.patternrecognition.repository.impl.RecognitionRepositoryImpl;
import it.michelepierri.patternrecognition.service.impl.RecognitionServiceImpl;
import it.michelepierri.patternrecognition.test.configuration.TestConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { TestConfiguration.class })
public class RecognitoinControllerTest {

	@Mock
	RecognitionRepositoryImpl repository;

	@Autowired
	@InjectMocks
	RecognitionServiceImpl service;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = NullPointerException.class)
	public void testAddNullPoint() {
		service.addPoint(null);
	}

	@Test
	public void testAddPoint() {
		service.addPoint(new PointDto(0, 0));
	}

	@Test
	public void testDeleteSpace() {
		service.deleteSpace();
	}

	@Test
	public void testGetLines() {
		assertNotNull(service.getLines(0));
	}

	@Test
	public void testGetSpace() {
		service.getSpace();
	}

	@Test
	public void test() {
		List<PointDto> pointsList= Arrays.asList( new PointDto(1, 1), new PointDto(0, 0), new PointDto(-1, -1) );
		Set<PointDto> pointsSet = new HashSet<>(pointsList);
		LineDto l = new LineDto(pointsSet);
		List<LineDto> lines = Stream.of(l).collect(Collectors.toCollection(ArrayList::new));
		
		Mockito.when(repository.getLinesWithCollinearPoints(Mockito.anyInt())).thenReturn(lines);
		
		List<List<PointDto>> resultLines = service.getLines(3);
		assertEquals(resultLines.size(),1);
		assertEquals(resultLines.get(0).size(), 3);

	}
}
