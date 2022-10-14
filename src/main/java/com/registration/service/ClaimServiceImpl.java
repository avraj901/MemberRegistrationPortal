package com.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.modal.Claim;

import com.registration.repository.IClaimRepository;
import com.registration.utility.MemberUtility;

@Service
public class ClaimServiceImpl implements IClaimService{

	@Autowired
	IClaimRepository claimRepository;
	
	@Override
	public Claim createClaim(Claim claim) {
		long claimNumber = MemberUtility.getClaimNumber();
		claim.setClaimNumber(claimNumber);
		Claim saveClaim = claimRepository.save(claim);
		return saveClaim;
	}



}
