package it.michelepierri.patternrecognition.test.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import it.michelepierri.patternrecognition.controller.impl.RecognitionControllerImpl;
import it.michelepierri.patternrecognition.domain.dto.PointDto;
import it.michelepierri.patternrecognition.service.impl.RecognitionServiceImpl;
import it.michelepierri.patternrecognition.test.configuration.TestConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { TestConfiguration.class })
public class RecognitoinServiceTest {

	@Mock
	RecognitionServiceImpl service;

	@Autowired
	@InjectMocks
	RecognitionControllerImpl controller;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetIndex() {
		assertNotNull(controller.getIndex());
	}

	@Test(expected = NullPointerException.class)
	public void testAddNullPoint() {
		controller.addPoint(null);
	}

	@Test
	public void testAddPoint() {
		controller.addPoint(new PointDto(0, 0));
	}

	@Test
	public void testDeleteSpace() {
		controller.deleteSpace();
	}

	@Test
	public void testBadRequestGetLines() {
		assertEquals(HttpStatus.BAD_REQUEST, controller.getLines(0).getStatusCode());
	}

	@Test
	public void testGetLinesEmptyReponse() {
		assertEquals(HttpStatus.NO_CONTENT, controller.getLines(2).getStatusCode());
	}
	
	@Test
	public void testGetLines() {
		List<PointDto> pointsList= Arrays.asList( new PointDto(1, 1), new PointDto(0, 0), new PointDto(-1, -1) );
		List<List<PointDto>> response = new ArrayList<>();
		response.add(pointsList);

		Mockito.when(service.getLines(Mockito.anyInt())).thenReturn(response);

		assertEquals(HttpStatus.OK, controller.getLines(2).getStatusCode());
	}

	@Test
	public void testGetSpace() {
		assertNotNull(controller.getSpace());
	}
}
