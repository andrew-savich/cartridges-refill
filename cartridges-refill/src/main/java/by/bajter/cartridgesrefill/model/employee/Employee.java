package by.bajter.cartridgesrefill.model.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
	@Size(min = 2, max = 30, message = "Name should be from 2 to 30 characters")
	private String name;
	@NotNull
	@Size(min = 2, max = 30, message = "Surname should be from 2 to 30 characters")
	private String surname;

	@NotNull
	@Column(unique = true)
	@Pattern(regexp = "^[a-zA-Z0-9_-]{3,15}$", message = "login sould be from 3 to 15 characters and must contain a-zA-Z0-9 symbols")
	private String login;
	
	@NotNull
	@Size(min = 4, max = 64, message = "Password should be from 4 to 64 characters")
	private String password;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Position position;

}