package it.michelepierri.patternrecognition.test.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import it.michelepierri.patternrecognition.domain.dto.PointDto;
import it.michelepierri.patternrecognition.repository.impl.RecognitionRepositoryImpl;
import it.michelepierri.patternrecognition.test.configuration.TestConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes={TestConfiguration.class})
public class RecognitoinRepositoryTest {

	@Autowired
	RecognitionRepositoryImpl repository;

	@Test(expected=NullPointerException.class)
	public void testAddNullPoint() {
		repository.addPoint(null);
	}
	
	@Test
	public void testAddPoint() {
		PointDto p = new PointDto(0, 0);
		repository.addPoint(p);
		assertEquals(true, repository.getPointsSpace().contains(p));
	}

	@Test
	public void testGetPointsSpace() {
		assertNotNull(repository.getPointsSpace());
	}
	
	@Test
	public void testGetLinesWithCollinearPoints() {
		repository.getLinesWithCollinearPoints(0);
	}
	
	@Test
	public void testFunctional() {
		repository.addPoint(new PointDto(0, 0));
		repository.addPoint(new PointDto(1, 1));
		repository.addPoint(new PointDto(-1, -1));
		
		assertEquals(3, repository.getPointsSpace().size());
		
		assertEquals(1,repository.getLinesWithCollinearPoints(3).size());
	}
}
