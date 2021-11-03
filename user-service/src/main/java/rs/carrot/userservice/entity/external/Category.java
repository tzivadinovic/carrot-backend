package rs.carrot.userservice.entity.external;

import lombok.Data;
import lombok.EqualsAndHashCode;
import rs.carrot.userservice.entity.Auditable;

@EqualsAndHashCode(callSuper = true)
@Data
public class Category extends Auditable {
    private Integer id;
    private String name;
}
