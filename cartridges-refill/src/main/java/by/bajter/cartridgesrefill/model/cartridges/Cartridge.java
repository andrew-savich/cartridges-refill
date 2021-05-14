package by.bajter.cartridgesrefill.model.cartridges;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import by.bajter.cartridgesrefill.model.Refill;
import by.bajter.cartridgesrefill.model.client.Client;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cartridge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String uniqIdentify;
	private Model model;
	private Group group;
	private Type type;
	private Color color;
	private Client client;
	private List<Refill> reffils;
}
