package rs.carrot.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Data
@Entity
@NoArgsConstructor
@Table(name = "role")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Role extends Auditable implements GrantedAuthority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "role_id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Override
    public String getAuthority() {
        return String.format("role_%s", name)
                .toUpperCase(Locale.ROOT);
    }


}