package by.bajter.cartridgesrefill.model.cartridges;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Group {
	@Id
	private Long id;
	private String name;
	private List<Cartridge> models;
}
