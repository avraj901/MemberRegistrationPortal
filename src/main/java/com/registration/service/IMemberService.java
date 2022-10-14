package com.registration.service;

import java.util.List;
import java.util.Optional;

import com.registration.modal.Customer;
import com.registration.modal.Dependents;
import com.registration.modal.Member;

public interface IMemberService {

	String saveMember(Member member);
	
	public List<Member> getAllMember();
	
	public Optional<Member> getMemberByMemberId(String memberId);

	Optional<Member> getMemberById(Integer id);
	
	Member updateMember(Member member, Integer id);
	
	String saveDepents(Dependents dependents);
	
	String saveCustomer(Customer customer);
	
	public Optional<Customer> getCustomerByMemberId(String memberId);
	
	Optional<Customer> getCustomerById(Integer id);
	
	Customer updateCustomer(Customer customer, Integer id);
	
	public List<Dependents> getDependentsByMemberId(String memberId);
	
	Optional<Dependents> getDependentsById(Integer id);
	
	Dependents updateDependents(Dependents dependents, Integer id);
}
