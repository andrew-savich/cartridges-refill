package by.bajter.cartridgesrefill.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.bajter.cartridgesrefill.model.Refill;
import by.bajter.cartridgesrefill.repository.RefillRepository;

@Service
public class RefillService {
	@Autowired
	private RefillRepository repository;
	
	public List<Refill> getAllReffils(){
		return repository.findAll();
	}
	
	public void save(Refill refill) {
		repository.save(refill);
	}

	public void delete(Refill refill) {
		repository.delete(refill);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public Refill findById(long id) {
		return repository.findById(id).get();
	}
	
}
