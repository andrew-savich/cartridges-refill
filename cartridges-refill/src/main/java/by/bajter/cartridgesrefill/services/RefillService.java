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
	
	List<Refill> getAllReffils(){
		return repository.findAll();
	}
}
