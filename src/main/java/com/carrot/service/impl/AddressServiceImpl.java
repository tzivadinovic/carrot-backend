package com.carrot.service.impl;

import com.carrot.entity.*;
import com.carrot.repository.AddressRepository;
import com.carrot.service.AddressService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
	private final AddressRepository addressRepository;

	@Override
	public List<Address> findAll(Specification<Address> specification, Sort sort) {
		return addressRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Address findById(Integer addressId) {
		return addressRepository.findById(addressId)
				.orElseThrow(() -> new NoSuchElementException("AddressService.notFound"));
	}

	@Override
	public Address save(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address update(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public void deleteById(Integer addressId) {
		addressRepository.deleteById(addressId);
	}


}