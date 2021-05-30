package by.bajter.cartridgesrefill.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.bajter.cartridgesrefill.model.cartridges.CartridgeGroup;
import by.bajter.cartridgesrefill.repository.CartridgeGroupRepository;

@Service
public class CartridgeGroupService {
	@Autowired
	private CartridgeGroupRepository repository;
	
	public List<CartridgeGroup> getAllCartridgeGroups() {
		return repository.findAll();
	}

	public void save(CartridgeGroup cartridgeGroup) {
		repository.save(cartridgeGroup);
	}

	public void delete(CartridgeGroup cartridgeGroup) {
		repository.delete(cartridgeGroup);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public CartridgeGroup findById(long id) {
		return repository.findById(id).get();
	}

	public CartridgeGroup findByTitle(String title) {
		return repository.findByTitle(title);
	}
	
}
