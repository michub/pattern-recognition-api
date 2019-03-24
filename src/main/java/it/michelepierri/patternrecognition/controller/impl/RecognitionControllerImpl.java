package it.michelepierri.patternrecognition.controller.impl;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.michelepierri.patternrecognition.configuration.RecognitionConfiguration;
import it.michelepierri.patternrecognition.controller.RecognitionController;
import it.michelepierri.patternrecognition.domain.dto.PointDto;
import it.michelepierri.patternrecognition.service.RecognitionService;

@RestController("recognitionController")
@Import({ RecognitionConfiguration.class })
public class RecognitionControllerImpl implements RecognitionController {

	@Autowired
	private RecognitionService service;

	@GetMapping("/")
	public String getIndex() {
		return "Greetings from Pattern-recognition-api!";
	}

	@PostMapping(path = "/add")
	public void addPoint(@RequestBody PointDto point) {
		Objects.requireNonNull(point, "point can't be null");
		service.addPoint(point);
	}

	@GetMapping(path = "/space")
	public Set<PointDto> getSpace() {
		return service.getSpace();
	}

	@GetMapping(path = "/lines/{n}")
	public ResponseEntity getLines(@PathVariable int n) {
		if (n < 2)
			return ResponseEntity.badRequest().body("N should be greater than 1");

		List<List<PointDto>> response = service.getLines(n);
		
		if(response.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

		return ResponseEntity.ok(service.getLines(n));
	}

	@DeleteMapping(path = "/delete")
	public void deleteSpace() {
		service.deleteSpace();
	}

}
