package com.mc.mcdonald.app.store.controllers;

import com.mc.mcdonald.app.store.entities.Sandwich;
import com.mc.mcdonald.app.store.models.responses.SandwichDto;
import com.mc.mcdonald.app.store.services.SandwichService;
import com.mc.mcdonald.utils.SuccessResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${api.endpoint.v1}/sandwiches")
public class SandwichController {
	private static final Logger LOG = LoggerFactory.getLogger(SandwichController.class);

	private final SandwichService sandwichService;

	public SandwichController(SandwichService sandwichService) {
		this.sandwichService = sandwichService;
	}

	@GetMapping
	public ResponseEntity<List<Sandwich>> getSandwiches() {
		LOG.info("INFO - Getting all sandwiches");
		return ResponseEntity
				.ok()
				.body(sandwichService.getSandwiches());
	}

	@GetMapping(value = "/{name}")
	public ResponseEntity<SandwichDto> getSandwichByName(@PathVariable String name) {
		return ResponseEntity
				.ok()
				.body(sandwichService.getSandwichByName(name));
	}

	@PostMapping
	public ResponseEntity<String> addSandwich(@RequestBody Sandwich sandwich) {
		sandwichService.addSandwich(sandwich);

		return ResponseEntity
				.ok()
				.body("Sandwich added");
	}

	@PutMapping(value = "/{name}")
	public ResponseEntity<SuccessResponse<String>> updateSandwich(@PathVariable String name, @RequestBody Sandwich sandwich) {
		sandwichService.updateSandwich(name, sandwich);

		return ResponseEntity
				.ok()
				.body(new SuccessResponse<>("Sandwich updated"));
	}

	@PutMapping(value = "/{name}/price/{price}")
	public ResponseEntity<SuccessResponse<String>> updateSandwichPrice(@PathVariable String name, @PathVariable Double price) {
		sandwichService.updateSandwichPrice(name, price);

		return ResponseEntity
				.ok()
				.body(new SuccessResponse<>("Sandwich price updated"));
	}

	@DeleteMapping(value = "/{name}")
	public ResponseEntity<SuccessResponse<String>> deleteSandwich(@PathVariable String name) {
		sandwichService.deleteSandwich(name);

		return ResponseEntity
				.ok()
				.body(new SuccessResponse<>("Sandwich deleted"));
	}
}
