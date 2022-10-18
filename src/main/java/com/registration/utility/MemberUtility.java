package com.registration.utility;

import java.time.LocalDate;
import java.time.Period;

public class MemberUtility {

	public static long getClaimNumber() {
		long claimNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		System.out.println("Claim Number ::" + claimNumber);
		return claimNumber;

	}

	public static int getMemberId() {
		int memberId = (int) Math.floor(Math.random() * 9_00) + 1_00;
		return memberId;
	}

	public static int ageCalculation(LocalDate dob) {
		LocalDate currentDate = LocalDate.now();
		if ((dob != null) && (currentDate != null)) {
			return Period.between(dob, currentDate).getYears();
		} else {
			return 0;
		}
	}
}
