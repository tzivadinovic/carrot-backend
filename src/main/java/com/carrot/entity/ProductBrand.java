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
@Table(name = "product_brand")
public class ProductBrand extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_brand_id")
	private Integer id;
	@Column(name = "name")
	private String name;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductBrand productBrand = (ProductBrand) o;
		return id.equals(productBrand.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}