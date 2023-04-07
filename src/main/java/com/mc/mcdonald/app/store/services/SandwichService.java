package com.mc.mcdonald.app.store.services;

import com.mc.mcdonald.app.store.entities.Sandwich;
import com.mc.mcdonald.app.store.models.responses.SandwichDto;
import com.mc.mcdonald.app.store.repositories.SandwichRepository;
import com.mc.mcdonald.exceptions.customs.ElementAlreadyExistsException;
import com.mc.mcdonald.exceptions.customs.ElementNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SandwichService {
	private final SandwichRepository sandwichRepository;

	public SandwichService(SandwichRepository sandwichRepository) {
		this.sandwichRepository = sandwichRepository;
	}

	public List<Sandwich> getSandwiches() {
		return sandwichRepository.findAll();
	}

	public SandwichDto getSandwichByName(String name) {
		return new SandwichDto(sandwichRepository.findByName(name)
				.orElseThrow(() -> new ElementNotFoundException("Sandwich with name " + name + " not found")));
	}

	public void addSandwich(Sandwich sandwich) {
		if (sandwichRepository.findByName(sandwich.getName()).isPresent())
			throw new ElementAlreadyExistsException("Sandwich with name " + sandwich.getName() + " already exists");

		sandwichRepository.save(sandwich);
	}

	public void updateSandwich(String name, Sandwich sandwich) {
		Sandwich sandwichToUpdate = sandwichRepository.findByName(name)
				.orElseThrow(() -> new ElementNotFoundException("Sandwich with name " + name + " not found"));

		sandwichToUpdate.setName(sandwich.getName());
		sandwichToUpdate.setPrice(sandwich.getPrice());
		sandwichToUpdate.setDescription(sandwich.getDescription());
		sandwichToUpdate.setIngredients(sandwich.getIngredients());
		sandwichToUpdate.setAllergens(sandwich.getAllergens());

		sandwichRepository.save(sandwichToUpdate);
	}

	public void updateSandwichPrice(String name, Double price) {
		Sandwich sandwichToUpdate = sandwichRepository.findByName(name)
				.orElseThrow(() -> new ElementNotFoundException("Sandwich with name " + name + " not found"));

		sandwichToUpdate.setPrice(price);

		sandwichRepository.save(sandwichToUpdate);
	}

	public void deleteSandwich(String name) {
		Sandwich sandwich = sandwichRepository.findByName(name)
				.orElseThrow(() -> new ElementNotFoundException("Sandwich with name " + name + " not found"));

		sandwichRepository.delete(sandwich);
	}
}
