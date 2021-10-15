package rs.carrot.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product_image")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProductImage extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "product_image_id")
	private Integer id;
	@JoinColumn(name = "product_fk", referencedColumnName = "product_id")
	@ManyToOne
	private Product product;
	@Column(name = "uri")
	private String uri;
	
}