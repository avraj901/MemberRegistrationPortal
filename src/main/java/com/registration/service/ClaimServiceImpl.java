package com.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.modal.Claim;
import com.registration.modal.DependentClaim;
import com.registration.repository.IClaimRepository;

@Service
public class ClaimServiceImpl implements IClaimService{

	@Autowired
	IClaimRepository claimRepository;
	
	@Override
	public Claim createClaim(Claim claim) {
		Claim saveClaim = claimRepository.save(claim);
		return saveClaim;
	}



}
