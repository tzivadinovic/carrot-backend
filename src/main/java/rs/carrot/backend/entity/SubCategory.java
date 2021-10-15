package rs.carrot.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "sub_category")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class SubCategory extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "sub_category_id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@JoinColumn(name = "category_fk", referencedColumnName = "category_id")
	@ManyToOne
	private Category category;
	@JoinColumn(name = "sub_category_fk", referencedColumnName = "sub_category_id")
	@ManyToOne
	private SubCategory subCategory;
	
}