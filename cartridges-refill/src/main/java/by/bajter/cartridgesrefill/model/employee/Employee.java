package by.bajter.cartridgesrefill.model.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	@NotNull
	private String surname;
	
	@NotNull
	@Column(unique = true)
	private String login;
	@NotNull
	private String password;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Position position;

}