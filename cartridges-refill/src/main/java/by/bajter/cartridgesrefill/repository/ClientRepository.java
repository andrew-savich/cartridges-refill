package by.bajter.cartridgesrefill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.bajter.cartridgesrefill.model.client.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
