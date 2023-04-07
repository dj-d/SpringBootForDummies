package com.mc.mcdonald.app.store.models.responses;

import com.mc.mcdonald.app.store.entities.Sandwich;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SandwichDto {

	private String name;
	private Double price;

	public SandwichDto(Sandwich sandwich) {
		this.name = sandwich.getName();
		this.price = sandwich.getPrice();
	}
}
