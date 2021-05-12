package by.bajter.cartridgesrefill.model.user;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
	private Long id;
	private String name;
	private String surName;
	private Position position;
}
