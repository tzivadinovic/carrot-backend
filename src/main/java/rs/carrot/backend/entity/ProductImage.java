package rs.carrot.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product_image")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProductImage extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "product_image_id")
    private Integer id;
    @JoinColumn(name = "product_fk", referencedColumnName = "product_id")
    @ManyToOne
    private Product product;
    @Column(name = "uri")
    private String uri;

}