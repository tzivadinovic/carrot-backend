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
@Table(name = "product_image")
public class ProductImage extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_image_id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "product_fk", referencedColumnName = "product_id")
	private Product product;
	@Column(name = "uri")
	private String uri;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductImage productImage = (ProductImage) o;
		return id.equals(productImage.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}