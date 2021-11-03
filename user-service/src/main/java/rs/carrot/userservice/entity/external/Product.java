package rs.carrot.userservice.entity.external;

import lombok.Data;
import lombok.EqualsAndHashCode;
import rs.carrot.userservice.entity.Auditable;

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Product extends Auditable {
    private Integer id;
    private String name;
    private ProductBrand productBrand;
    private ProductModel productModel;
    private Integer stock;
    private Double price;
    private Double discountPrice;
    private String ean;
    private SubCategory subCategory;

}
