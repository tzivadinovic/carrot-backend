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
@Table(name = "municipality")
public class Municipality extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "municipality_id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@ManyToOne
	@JoinColumn(name = "city_fk", referencedColumnName = "city_id")
	private City city;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Municipality municipality = (Municipality) o;
		return id.equals(municipality.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}