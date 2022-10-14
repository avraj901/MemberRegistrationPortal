package com.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.modal.DependentClaim;
import com.registration.repository.IDependentClaimRepository;
import com.registration.utility.MemberUtility;


@Service
public class DependentClaimServiceImpl implements IDependentClaimService{

	@Autowired
	IDependentClaimRepository dependentRepository;
	
	@Override
	public DependentClaim createClaimForDependents(DependentClaim claim) {
		long claimNumber = MemberUtility.getClaimNumber();
		claim.setClaimNumber(claimNumber);
		DependentClaim dependentclaim = dependentRepository.save(claim);
		return dependentclaim;
	}

}
