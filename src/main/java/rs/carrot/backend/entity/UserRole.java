package rs.carrot.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user_role")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class UserRole extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "user_role_id")
	private Integer id;
	@JoinColumn(name = "user_fk", referencedColumnName = "user_id")
	@ManyToOne
	private User user;
	@JoinColumn(name = "role_fk", referencedColumnName = "role_id")
	@ManyToOne
	private Role role;
	
}