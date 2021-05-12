package by.bajter.cartridgesrefill.model.cartridges;

import javax.persistence.Entity;
import javax.persistence.Id;

import by.bajter.cartridgesrefill.model.client.Client;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cartridge {
	@Id
	private Long id;
	private String name;
	private Group group;
	private Type type;
	private Color color;
	private Client client;
	private Integer gram;
}
