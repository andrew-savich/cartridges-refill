package by.bajter.cartridgesrefill.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private Boolean isReplacedDrum;
	private Boolean isReplacedPcr;
	private Boolean isReplacedMagnet;
	private Boolean isReplacedSqueegee;
	private Boolean isReplacedBlade;
	private Boolean isReplacedChip;
	private String comment;
	private User refueller;
	private Boolean isIssuedAct;
	
}
