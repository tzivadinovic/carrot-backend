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
@Table(name = "product")
@RequiredArgsConstructor
public class Product extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@ManyToOne
	@JoinColumn(name = "product_brand_fk", referencedColumnName = "product_brand_id")
	private ProductBrand productBrand;
	@ManyToOne
	@JoinColumn(name = "product_model_fk", referencedColumnName = "product_model_id")
	private ProductModel productModel;
	@Column(name = "stock")
	private Integer stock;
	@Column(name = "price")
	private Double price;
	@Column(name = "discount_price")
	private Double discountPrice;
	@Column(name = "ean")
	private String ean;
	@ManyToOne
	@JoinColumn(name = "sub_category_fk", referencedColumnName = "sub_category_id")
	private SubCategory subCategory;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return id.equals(product.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}