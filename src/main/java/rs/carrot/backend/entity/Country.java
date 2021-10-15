package rs.carrot.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "country")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Country extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "country_id")
	private Integer id;
	@Column(name = "name")
	private String name;
	
}