package com.carrot.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Table(name = "address")
@RequiredArgsConstructor
public class Address extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "country_fk", referencedColumnName = "country_id")
    private Country country;
    @ManyToOne
    @JoinColumn(name = "municipality_fk", referencedColumnName = "municipality_id")
    private Municipality municipality;
    @ManyToOne
    @JoinColumn(name = "city_fk", referencedColumnName = "city_id")
    private City city;
    @ManyToOne
    @JoinColumn(name = "user_fk", referencedColumnName = "user_id")
    private User user;
    @Column(name = "street")
    private String street;
    @Column(name = "number")
    private String number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id.equals(address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}