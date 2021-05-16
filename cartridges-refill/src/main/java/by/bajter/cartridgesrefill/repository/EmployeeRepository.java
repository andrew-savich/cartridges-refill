package by.bajter.cartridgesrefill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.bajter.cartridgesrefill.model.user.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}
