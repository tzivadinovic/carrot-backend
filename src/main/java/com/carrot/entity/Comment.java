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
@Table(name = "comment")
@RequiredArgsConstructor
public class Comment extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "product_fk", referencedColumnName = "product_id")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "user_fk", referencedColumnName = "user_id")
	private User user;
	@Column(name = "content")
	private String content;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Comment comment = (Comment) o;
		return id.equals(comment.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}