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
@Table(name = "product_specification")
public class ProductSpecification extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_specification_id")
	private Integer id;
	@Column(name = "key")
	private String key;
	@Column(name = "value")
	private String value;
	@ManyToOne
	@JoinColumn(name = "product_fk", referencedColumnName = "product_id")
	private Product product;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductSpecification productSpecification = (ProductSpecification) o;
		return id.equals(productSpecification.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}