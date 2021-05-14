package by.bajter.cartridgesrefill.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import by.bajter.cartridgesrefill.model.cartridges.Cartridge;
import by.bajter.cartridgesrefill.model.user.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Refill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date fillDate;

	@ManyToOne(fetch = FetchType.EAGER)
	private Cartridge cartridge;

	private Integer actualGramsToner;

	private Boolean changedDrum;

	private Boolean changedPcr;

	private Boolean changedMagnet;

	private Boolean changedRakel;

	private Boolean changedDoserBlade;

	private Boolean changedChip;

	private Boolean changedFirmware;

	private String comment;

	@ManyToOne(fetch = FetchType.EAGER)
	private Employee refueller;

	private Boolean isIssuedAct;

}
