package by.bajter.cartridgesrefill.model.cartridges;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

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
	@Size(min = 2, max = 30, message = "Model should be beetween 2 and 30 characters")
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
	
	@PositiveOrZero(message = "Only numbers")
	@Max(value = 999, message = "Too great a value")
	private Integer defaultGrams;
	@Expose
	private String description;
}
