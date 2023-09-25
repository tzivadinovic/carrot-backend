package com.carrot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "product_order")
public class ProductOrder extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_order_id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "product_fk", referencedColumnName = "product_id")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "order_fk", referencedColumnName = "order_id")
	private Order order;
	@Column(name = "quantity")
	private Integer quantity;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductOrder productOrder = (ProductOrder) o;
		return id.equals(productOrder.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}