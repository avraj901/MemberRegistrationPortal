package com.registration.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.exception.ResourceNotFoundException;
import com.registration.modal.Customer;
import com.registration.modal.Dependents;
import com.registration.modal.Member;
import com.registration.modal.MemberDependents;
import com.registration.repository.ICustomerRepository;
import com.registration.repository.IDependentRepository;
import com.registration.repository.IMemberRepository;

@Service
public class MemberServiceImpl implements IMemberService {

	@Autowired
	IMemberRepository memberRepository;

	@Autowired
	IDependentRepository dependentRepository;

	@Autowired
	ICustomerRepository customerRepository;

	@Override
	public String saveMember(Member member) {
		Random random = new Random();
		Optional<Member> oldMember = null;
		Member saveMember = memberRepository.save(member);
		int id = saveMember.getId();
		int registrationNumber = random.nextInt(1000);
		String memberId = "R-" + registrationNumber;
		// First we need to get memberId if exit then generate new member id
		oldMember = getMemberByMemberId(memberId);
		System.out.println("OldMember :: " + oldMember.isPresent());
		if (oldMember.isPresent()) {
			String oldMemberId = oldMember.get().getMemberId();
			System.out.println("oldMember Id ::" + oldMemberId + "new Member Id ::" + memberId);
			if (oldMemberId.equalsIgnoreCase(memberId)) {
				registrationNumber = random.nextInt(1000);
				memberId = "R-" + registrationNumber;
				memberRepository.updateMemberId(memberId, id);
			}
		} else {
			memberRepository.updateMemberId(memberId, id);
		}

		return memberId;
	}

	@Override
	public List<Member> getAllMember() {
		return memberRepository.findAll();
	}

	@Override
	public Optional<Member> getMemberByMemberId(String memberId) {
		return memberRepository.findByMemberId(memberId);
	}

	@Override
	public Optional<Member> getMemberById(Integer id) {
		return memberRepository.findById(id);
	}

	@Override
	public Member updateMember(Member member, Integer id) {
		List<MemberDependents> listDependents = new ArrayList<>();
		Member existingMember = memberRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));
		existingMember.setName(member.getName());
		existingMember.setEmailAddress(member.getEmailAddress());
		existingMember.setPanNumber(member.getPanNumber());
		existingMember.setContactNumber(member.getPanNumber());
		existingMember.setDob(member.getDob());
		existingMember.setAddress(member.getAddress());
		existingMember.setCountry(member.getCountry());
		existingMember.setState(member.getState());
		existingMember.setMemberId(member.getMemberId());

		List<MemberDependents> memberDependents = member.getMemberDependents();
		for (MemberDependents memberDependent : memberDependents) {
			String name = memberDependent.getName();
			Date dob = memberDependent.getDob();
			int dependentsId = memberDependent.getId();
			MemberDependents dependents = new MemberDependents();
			dependents.setName(name);
			dependents.setDob(dob);
			dependents.setId(dependentsId);
			listDependents.add(dependents);
		}
		existingMember.setMemberDependents(listDependents);
		// int numberOfDependents = memberDependents.size();
		memberRepository.save(existingMember);
		return existingMember;
	}

	@Override
	public String saveDepents(Dependents dependents) {
		Dependents savedependents = dependentRepository.save(dependents);
		return savedependents.getMemberId();
	}

	@Override
	public String saveCustomer(Customer customer) {
		Random random = new Random();
		Optional<Customer> oldMember = null;
		Customer saveMember = customerRepository.save(customer);
		int id = saveMember.getId();
		int registrationNumber = random.nextInt(1000);
		String memberId = "R-" + registrationNumber;
		// First we need to get memberId if exit then generate new member id
		oldMember = getCustomerByMemberId(memberId);
		System.out.println("OldMember :: " + oldMember.isPresent());
		if (oldMember.isPresent()) {
			String oldMemberId = oldMember.get().getMemberId();
			System.out.println("oldMember Id ::" + oldMemberId + "new Member Id ::" + memberId);
			if (oldMemberId.equalsIgnoreCase(memberId)) {
				registrationNumber = random.nextInt(1000);
				memberId = "R-" + registrationNumber;
				customerRepository.updateMemberId(memberId, id);
			}
		} else {
			customerRepository.updateMemberId(memberId, id);
		}

		return memberId;
	}

	@Override
	public Optional<Customer> getCustomerByMemberId(String memberId) {
		return customerRepository.findByMemberId(memberId);
	}

	@Override
	public Optional<Customer> getCustomerById(Integer id) {
		return customerRepository.findById(id);
	}

	@Override
	public Customer updateCustomer(Customer customer, Integer id) {
		Customer existingCustomer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));
		existingCustomer.setName(customer.getName());
		existingCustomer.setEmailAddress(customer.getEmailAddress());
		existingCustomer.setPanNumber(customer.getPanNumber());
		existingCustomer.setContactNumber(customer.getPanNumber());
		existingCustomer.setDob(customer.getDob());
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setCountry(customer.getCountry());
		existingCustomer.setState(customer.getState());
		existingCustomer.setMemberId(customer.getMemberId());
		customerRepository.save(existingCustomer);
		return existingCustomer;
	}

	@Override
	public List<Dependents> getDependentsByMemberId(String memberId) {
		return dependentRepository.findAllDependents(memberId);
	}

	@Override
	public Optional<Dependents> getDependentsById(Integer id) {
		return dependentRepository.findById(id);
	}

}
