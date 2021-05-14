package by.bajter.cartridgesrefill.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import by.bajter.cartridgesrefill.model.cartridges.Cartridge;
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

	@Temporal(TemporalType.DATE)
	private Date fillingDdate;

	@OneToMany(fetch = FetchType.EAGER)
	private Cartridge cartridge;

	private Integer actuallyGramsToner;

	private Boolean changedDrum;

	private Boolean changedPcr;

	private Boolean changedMagnet;

	private Boolean changedRakel;

	private Boolean changedDoserBlade;

	private Boolean changedChip;

	private Boolean changedFirmware;

	private String comment;

	@OneToMany(fetch = FetchType.EAGER)
	private User refueller;

	private Boolean isIssuedAct;

}
