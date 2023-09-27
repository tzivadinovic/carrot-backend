package com.carrot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Entity
@Getter
@Setter
@ToString
@Table(name = "user")
@RequiredArgsConstructor
public class User extends Auditable implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "phone")
	private String phoneNumber;
	@Column(name = "birth_date")
	private LocalDate birthDate;
	@Column(name = "email")
	private String email;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	@JsonProperty(access = WRITE_ONLY)
	private String password;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_fk"), inverseJoinColumns = @JoinColumn(name = "role_fk"))
	private Role role;

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
			return null;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return isEnabled();
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return isEnabled();
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return isEnabled();
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return id.equals(user.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}