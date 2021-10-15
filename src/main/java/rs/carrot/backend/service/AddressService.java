package rs.carrot.backend.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.backend.entity.*;

public interface AddressService {

	List<Address> findAll(Specification<Address> specification, Sort sort);

	Address save(Address address);

	Address update(Address address);

	Address findById(Integer addressId);

	void deleteById(Integer addressId);

}