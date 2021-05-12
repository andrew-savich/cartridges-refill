package by.bajter.cartridgesrefill.model.client;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Client {
	private Long id;
	private String name;
}
