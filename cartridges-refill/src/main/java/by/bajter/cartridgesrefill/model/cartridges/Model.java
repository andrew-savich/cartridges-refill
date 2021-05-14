package by.bajter.cartridgesrefill.model.cartridges;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Model {
	private Long id;
	private String name;
	private Integer grammDefault;
	private Group proup;
}
