package by.bajter.cartridgesrefill.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import by.bajter.cartridgesrefill.config.EmployeeDetails;
import by.bajter.cartridgesrefill.model.employee.Employee;
import by.bajter.cartridgesrefill.repository.EmployeeRepository;

public class EmployeeDetailsService implements UserDetailsService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Employee employee = employeeRepository.findByLogin(login);
		
		if(employee == null) {
			throw new UsernameNotFoundException("Could not find employee");
		}
		
		return new EmployeeDetails(employee);
	}

}
