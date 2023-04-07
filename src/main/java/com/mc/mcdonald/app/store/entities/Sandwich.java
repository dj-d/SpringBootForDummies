package com.mc.mcdonald.app.store.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.common.aliasing.qual.Unique;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "sandwich")
public class Sandwich {

	enum Allergen {
		EGG,
		PEANUT,
		MILK
	}

	enum Ingredient {
		BREAD,
		MEAT,
		CHEESE
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Unique
	@NotNull
	private String name;

	@NotNull
	private Double price;

	@NotNull
	private String description;

	@NotNull
	private List<Ingredient> ingredients = new ArrayList<>();

	@NotNull
	private List<Allergen> allergens = new ArrayList<>();
}
