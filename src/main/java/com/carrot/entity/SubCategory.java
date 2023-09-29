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
@Table(name = "sub_category")
public class SubCategory extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sub_category_id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@ManyToOne
	@JoinColumn(name = "category_fk", referencedColumnName = "category_id")
	private Category category;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SubCategory subCategory = (SubCategory) o;
		return id.equals(subCategory.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}