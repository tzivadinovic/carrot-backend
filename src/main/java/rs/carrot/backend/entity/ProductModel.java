package rs.carrot.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product_model")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProductModel extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "product_model_id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@JoinColumn(name = "product_brand_fk", referencedColumnName = "product_brand_id")
	@ManyToOne
	private ProductBrand productBrand;
	
}