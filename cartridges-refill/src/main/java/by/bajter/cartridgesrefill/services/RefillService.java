package by.bajter.cartridgesrefill.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.bajter.cartridgesrefill.model.Refill;
import by.bajter.cartridgesrefill.repository.RefillREpository;

@Service
public class RefillService {
	@Autowired
	private RefillREpository repository;
	
	List<Refill> getAllReffils(){
		return repository.findAll();
	}
}
