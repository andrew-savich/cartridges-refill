package by.bajter.cartridgesrefill.model.cartridges;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CartridgeGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(unique = true)
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartridgeModel> cartridgeModels = new ArrayList<>();
	
	public void addCartridgeModel(CartridgeModel cartridgeModel) {
		cartridgeModels.add(cartridgeModel);
		cartridgeModel.setGroup(this);
	}
	
	public void removeCartridgeModel(CartridgeModel cartridgeModel) {
		cartridgeModels.remove(cartridgeModel);
		cartridgeModel.setGroup(null);
	}
}
