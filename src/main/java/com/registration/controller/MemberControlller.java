package com.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.registration.modal.Member;
import com.registration.service.IMemberService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MemberControlller {

	@Autowired
	IMemberService memberService;

	@GetMapping("/hello")
	public String Hello() {
		return "Welcome to Member Registration portal";
	}

	@PostMapping("/save")
	public Integer saveMember(@RequestBody Member member) {
		return memberService.saveMember(member);

	}

}
