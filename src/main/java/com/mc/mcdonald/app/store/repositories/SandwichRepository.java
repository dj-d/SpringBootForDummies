package com.mc.mcdonald.app.store.repositories;

import com.mc.mcdonald.app.store.entities.Sandwich;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SandwichRepository extends JpaRepository<Sandwich, Long> {
	Optional<Sandwich> findByName(String name);
}
