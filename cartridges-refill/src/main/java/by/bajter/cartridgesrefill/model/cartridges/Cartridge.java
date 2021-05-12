package by.bajter.cartridgesrefill.model.cartridges;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cartridge {
	
	@Id
	private Long id;
	private Model model;
	private Group group;
	private Integer gramOfToner;
	private Type type;
	private Color color;
	

}
