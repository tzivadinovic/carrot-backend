package rs.carrot.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "order")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Order extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "order_id")
	private Integer id;
	@JoinColumn(name = "user_fk", referencedColumnName = "user_id")
	@ManyToOne
	private User user;
	@Column(name = "total_price")
	private Double totalPrice;
	
}