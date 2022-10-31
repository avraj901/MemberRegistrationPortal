package com.registration.service;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.exception.MemberException;
import com.registration.modal.Claim;

import com.registration.repository.IClaimRepository;
import com.registration.utility.MemberUtility;

@Service
public class ClaimServiceImpl implements IClaimService{

	@Autowired
	IClaimRepository claimRepository;
	
	@Override
	public Claim createClaim(Claim claim) {
		Date admission = claim.getDateOfAdmission();
		Date discharge = claim.getDateOfDischarge();
		System.out.println("Date of admission :: "+admission);
		System.out.println("Date of discharge :: "+discharge);
		try {
			compareDate(admission, discharge);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long claimNumber = MemberUtility.getClaimNumber();
		claim.setClaimNumber(claimNumber);
		Claim saveClaim = claimRepository.save(claim);
		return saveClaim;
	}

	public void compareDate(Date admission, Date discharge) throws ParseException {
		  
		if (admission.after(discharge))   
		{   
		System.out.println("Date1 comes after Date2");  
		throw new MemberException("Date of Admission should be on or before Discharge.");
		}  
		else if (admission.before(discharge))   
		{   
		System.out.println("Date1 comes before Date2");   
		}   
		else if (admission.equals(discharge))   
		{   
		System.out.println("Both dates are equal");   
		throw new MemberException("Please provide validate date for admissin and discharge.");
		}   
	}

}
