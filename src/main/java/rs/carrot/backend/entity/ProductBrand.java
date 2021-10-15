package rs.carrot.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product_brand")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProductBrand extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "product_brand_id")
    private Integer id;
    @Column(name = "name")
    private String name;

}