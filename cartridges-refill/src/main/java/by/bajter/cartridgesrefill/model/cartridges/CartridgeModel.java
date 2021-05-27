package by.bajter.cartridgesrefill.model.cartridges;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.google.gson.annotations.Expose;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class CartridgeModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	private Long id;
	
	@NotNull
	@Column(unique = true)
	@Expose
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@ToString.Exclude
	@Expose
	private CartridgeGroup group;
	
	@Enumerated(EnumType.STRING)
	@Expose
	private Type type;
	
	@Enumerated(EnumType.STRING)
	@Expose
	private Color color;
	@Expose
	private Integer defaultGrams;
	@Expose
	private String description;
}
