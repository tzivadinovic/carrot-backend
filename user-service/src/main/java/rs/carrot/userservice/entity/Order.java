package rs.carrot.userservice.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "`order`")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Order extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "order_id")
    private Integer id;
    @JoinColumn(name = "user_fk", referencedColumnName = "user_id")
    @ManyToOne
    private User user;
    @Column(name = "total_price")
    private Double totalPrice;
}