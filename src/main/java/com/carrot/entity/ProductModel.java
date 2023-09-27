package com.carrot.entity;

import java.util.*;
import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "product_model")
public class ProductModel extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_model_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "product_brand_fk", referencedColumnName = "product_brand_id")
    private ProductBrand productBrand;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductModel productModel = (ProductModel) o;
        return id.equals(productModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}