package rs.carrot.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "city")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class City extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "city_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "zip_code")
    private String zipCode;
    @JoinColumn(name = "municipality_fk", referencedColumnName = "municipality_id")
    @ManyToOne
    private Municipality municipality;

}