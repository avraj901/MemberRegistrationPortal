package com.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.modal.Member;
import com.registration.repository.IMemberRepository;

@Service
public class MemberServiceImpl implements IMemberService{
	
	@Autowired
	IMemberRepository memberRepository;

	@Override
	public Integer saveMember(Member member) {
		Member saveMember =  memberRepository.save(member);
		return saveMember.getId();
	}

}
