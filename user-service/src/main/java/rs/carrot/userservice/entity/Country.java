package rs.carrot.userservice.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "country")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Country extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "country_id")
    private Integer id;
    @Column(name = "name")
    private String name;

}