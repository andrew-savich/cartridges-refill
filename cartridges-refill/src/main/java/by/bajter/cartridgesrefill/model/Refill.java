package by.bajter.cartridgesrefill.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import by.bajter.cartridgesrefill.model.cartridges.Cartridge;
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
	
	@OneToMany(fetch = FetchType.EAGER)
	private Cartridge cartridge;
	
	private Integer gramFact;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Part> replacedParts;
	
	private String comment;
	
	@OneToMany(fetch = FetchType.EAGER)
	private User refueller;
	
	private Boolean isIssuedAct;
	
}
