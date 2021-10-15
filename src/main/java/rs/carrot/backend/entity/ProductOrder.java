package rs.carrot.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product_order")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProductOrder extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "product_order_id")
	private Integer id;
	@JoinColumn(name = "product_fk", referencedColumnName = "product_id")
	@ManyToOne
	private Product product;
	@JoinColumn(name = "order_fk", referencedColumnName = "order_id")
	@ManyToOne
	private Order order;
	@Column(name = "quantity")
	private Integer quantity;
	
}