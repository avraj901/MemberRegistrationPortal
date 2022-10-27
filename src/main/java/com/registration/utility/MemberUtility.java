package com.registration.utility;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

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

	public static int ageCalculation(Date dob) {
		Instant instant = dob.toInstant();
		ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
		LocalDate dateOfBirth = zonedDateTime.toLocalDate();
		LocalDate currentDate = LocalDate.now();
		if ((dob != null) && (currentDate != null)) {
			return Period.between(dateOfBirth, currentDate).getYears();
		} else {
			return 0;
		}
	}

}
