package com.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.modal.DependentClaim;
import com.registration.repository.IDependentClaimRepository;


@Service
public class IDependentClaimServiceImpl implements IDependentClaimService{

	@Autowired
	IDependentClaimRepository dependentRepository;
	
	@Override
	public DependentClaim createClaimForDependents(DependentClaim claim) {
		DependentClaim dependentclaim = dependentRepository.save(claim);
		return dependentclaim;
	}

}
