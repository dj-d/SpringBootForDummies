package com.mc.mcdonald.healthcheck;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class Healthcheck {
	@GetMapping(value = "/healthcheck")
	public ResponseEntity<?> heathcheckRequest() {
		return ResponseEntity.ok().body("Working...");
	}
}
