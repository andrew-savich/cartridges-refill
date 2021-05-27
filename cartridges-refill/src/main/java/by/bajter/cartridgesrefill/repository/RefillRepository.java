package by.bajter.cartridgesrefill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.bajter.cartridgesrefill.model.Refill;

public interface RefillRepository extends JpaRepository<Refill, Long>{
	
}
