package rs.carrot.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product_brand")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProductBrand extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "product_brand_id")
	private Integer id;
	@Column(name = "name")
	private String name;
	
}