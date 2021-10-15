package rs.carrot.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "address")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Address extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "address_id")
    private Integer id;
    @JoinColumn(name = "country_fk", referencedColumnName = "country_id")
    @ManyToOne
    private Country country;
    @JoinColumn(name = "municipality_fk", referencedColumnName = "municipality_id")
    @ManyToOne
    private Municipality municipality;
    @JoinColumn(name = "city_fk", referencedColumnName = "city_id")
    @ManyToOne
    private City city;
    @JoinColumn(name = "user_fk", referencedColumnName = "user_id")
    @ManyToOne
    private User user;
    @Column(name = "street")
    private String street;
    @Column(name = "number")
    private String number;

}