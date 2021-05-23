package by.bajter.cartridgesrefill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.bajter.cartridgesrefill.model.cartridges.Cartridge;

public interface CartridgeRepository extends JpaRepository<Cartridge, Long> {
	
}
