package com.carrot.service.impl;

import com.carrot.entity.*;
import com.carrot.repository.UserRoleRepository;
import com.carrot.service.UserRoleService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
	private final UserRoleRepository userRoleRepository;

	@Override
	public List<UserRole> findAll(Specification<UserRole> specification, Sort sort) {
		return userRoleRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public UserRole findById(Integer userRoleId) {
		return userRoleRepository.findById(userRoleId)
				.orElseThrow(() -> new NoSuchElementException("UserRoleService.notFound"));
	}

	@Override
	public UserRole save(UserRole userRole) {
		return userRoleRepository.save(userRole);
	}

	@Override
	public UserRole update(UserRole userRole) {
		return userRoleRepository.save(userRole);
	}

	@Override
	public void deleteById(Integer userRoleId) {
		userRoleRepository.deleteById(userRoleId);
	}


}