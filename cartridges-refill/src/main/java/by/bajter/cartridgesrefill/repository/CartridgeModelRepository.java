package by.bajter.cartridgesrefill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.bajter.cartridgesrefill.model.cartridges.CartridgeModel;

public interface CartridgeModelRepository extends JpaRepository<CartridgeModel, Long> {
	
}
