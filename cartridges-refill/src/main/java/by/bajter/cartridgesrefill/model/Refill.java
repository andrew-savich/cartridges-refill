package by.bajter.cartridgesrefill.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import by.bajter.cartridgesrefill.model.cartridges.Cartridge;
import by.bajter.cartridgesrefill.model.employee.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Refill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Temporal(TemporalType.DATE)
	private Date refillDate;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Cartridge cartridge;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Employee refueller;
	
	private Integer actualGrams;
	
	private Boolean changedDrum;

	private Boolean changedPcr;

	private Boolean changedMagnet;

	private Boolean changedRakel;

	private Boolean changedDoserBlade;

	private Boolean changedChip;

	private Boolean changedFirmware;

	private String comment;
	
	private Boolean isIssuedAct;

}
