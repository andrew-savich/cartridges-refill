package by.bajter.cartridgesrefill.model.cartridges;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	private Date addDate;
	
	private String uniqIdentify;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private CartridgeModel cartridgeModel;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Client client;
}
