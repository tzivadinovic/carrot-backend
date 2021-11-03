package rs.carrot.productservice.entity.external;

import lombok.Data;
import lombok.EqualsAndHashCode;
import rs.carrot.productservice.entity.Auditable;

@EqualsAndHashCode(callSuper = true)
@Data
public class Role extends Auditable {
    private Integer id;
    private String name;
}
