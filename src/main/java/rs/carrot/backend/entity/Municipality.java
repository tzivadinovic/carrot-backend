package rs.carrot.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "municipality")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Municipality extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "municipality_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "country_fk", referencedColumnName = "country_id")
    @ManyToOne
    private Country country;

}