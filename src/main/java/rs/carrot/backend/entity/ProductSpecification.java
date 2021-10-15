package rs.carrot.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product_specification")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProductSpecification extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "product_specification_id")
    private Integer id;
    @Column(name = "key")
    private String key;
    @Column(name = "value")
    private String value;
    @JoinColumn(name = "product_fk", referencedColumnName = "product_id")
    @ManyToOne
    private Product product;

}