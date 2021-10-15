package rs.carrot.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "comment")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Comment extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "comment_id")
	private Integer id;
	@JoinColumn(name = "product_fk", referencedColumnName = "product_id")
	@ManyToOne
	private Product product;
	@JoinColumn(name = "user_fk", referencedColumnName = "user_id")
	@ManyToOne
	private User user;
	@Column(name = "content")
	private String content;
	
}