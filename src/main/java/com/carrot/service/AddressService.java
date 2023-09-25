package com.carrot.service;

import com.carrot.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface AddressService {

	List<Address> findAll(Specification<Address> specification, Sort sort);

	Address save(Address address);

	Address update(Address address);

	Address findById(Integer addressId);

	void deleteById(Integer addressId);

}