package by.bajter.cartridgesrefill.model.cartridges;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@Temporal(TemporalType.DATE)
	private Date addingDate;
	
	private String uniqIdentify;
	
	@OneToMany(fetch = FetchType.EAGER)
	private Model model;
	
	@OneToMany(fetch = FetchType.EAGER)
	private Client client;
}
