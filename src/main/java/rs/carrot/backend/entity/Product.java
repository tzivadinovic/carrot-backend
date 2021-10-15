package rs.carrot.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Product extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "product_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "product_brand_fk", referencedColumnName = "product_brand_id")
    @ManyToOne
    private ProductBrand productBrand;
    @JoinColumn(name = "product_model_fk", referencedColumnName = "product_model_id")
    @ManyToOne
    private ProductModel productModel;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "price")
    private Double price;
    @Column(name = "discount_price")
    private Double discountPrice;
    @Column(name = "ean")
    private String ean;
    @Column(name = "sub_category_fk")
    private Integer subCategory;

}