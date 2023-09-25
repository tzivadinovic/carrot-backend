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
@Table(name = "user_role")
public class UserRole extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_role_id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "user_fk", referencedColumnName = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "role_fk", referencedColumnName = "role_id")
	private Role role;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserRole userRole = (UserRole) o;
		return id.equals(userRole.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}