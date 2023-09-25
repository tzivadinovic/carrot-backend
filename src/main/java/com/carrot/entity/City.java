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
@Table(name = "city")
@RequiredArgsConstructor
public class City extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "zip_code")
	private String zipCode;
	@ManyToOne
	@JoinColumn(name = "municipality_fk", referencedColumnName = "municipality_id")
	private Municipality municipality;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		City city = (City) o;
		return id.equals(city.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}