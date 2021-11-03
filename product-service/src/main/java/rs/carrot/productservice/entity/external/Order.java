package rs.carrot.productservice.entity.external;

import lombok.Data;
import lombok.EqualsAndHashCode;
import rs.carrot.productservice.entity.Auditable;
import rs.carrot.productservice.entity.Product;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Order extends Auditable {
    private Integer id;
    private User user;
    private Double totalPrice;
    List<Product> products;
}
