package by.bajter.cartridgesrefill.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.bajter.cartridgesrefill.model.cartridges.CartridgeModel;
import by.bajter.cartridgesrefill.repository.CartridgeModelRepository;

@Service
public class CartrigeModelService {
	@Autowired
	private CartridgeModelRepository repository;

	public List<CartridgeModel> getAllCartridgeModels() {
		return repository.findAll();
	}

	public void save(CartridgeModel cartridgeModel) {
		repository.save(cartridgeModel);
	}

	public void delete(CartridgeModel cartridgeModel) {
		repository.delete(cartridgeModel);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public CartridgeModel findById(long id) {
		return repository.findById(id).get();
	}
}
