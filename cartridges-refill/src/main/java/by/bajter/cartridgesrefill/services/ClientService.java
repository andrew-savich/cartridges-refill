package by.bajter.cartridgesrefill.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.bajter.cartridgesrefill.model.client.Client;
import by.bajter.cartridgesrefill.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository repository;
	
	public List<Client> getAllClients() {
		return repository.findAll();
	}

	public void save(Client client) {
		repository.save(client);
	}

	public void delete(Client client) {
		repository.delete(client);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public Client findById(long id) {
		return repository.findById(id).get();
	}
}
