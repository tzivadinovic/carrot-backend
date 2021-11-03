package rs.carrot.productservice.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product_order")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProductOrder extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "product_order_id")
    private Integer id;
    @JoinColumn(name = "product_fk", referencedColumnName = "product_id")
    @ManyToOne
    private Product product;
    private Integer orderId;
    @Column(name = "quantity")
    private Integer quantity;

}