package by.bajter.cartridgesrefill.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.bajter.cartridgesrefill.model.cartridges.Cartridge;
import by.bajter.cartridgesrefill.repository.CartridgeRepository;

@Service
public class CartridgeService {
	@Autowired
	private CartridgeRepository repository;
	
	public List<Cartridge> getAllCartridges(){
		return repository.findAll();
	}
}
