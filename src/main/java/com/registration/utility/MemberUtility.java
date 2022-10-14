package com.registration.utility;

public class MemberUtility {

	public static long getClaimNumber() {
		long claimNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		System.out.println("Claim Number ::"+ claimNumber);
		return claimNumber;
		
	}
}
