package by.bajter.cartridgesrefill.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import by.bajter.cartridgesrefill.model.cartridges.Cartridge;
import by.bajter.cartridgesrefill.model.client.Client;
import by.bajter.cartridgesrefill.model.parts.Part;
import by.bajter.cartridgesrefill.model.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Refill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private Cartridge cartridge;
	private Client client;
	private List<Part> replacedParts;
	private String comment;
	private User refueller;
	private Boolean isIssuedAct;
	
}
