package rs.carrot.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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