package rs.carrot.userservice.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.userservice.entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> findAll(Specification<Address> specification, Sort sort);

    Address save(Address address);

    Address update(Address address);

    Address findById(Integer addressId);

    void deleteById(Integer addressId);

}