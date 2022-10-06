package com.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.modal.Member;

public interface IMemberRepository extends JpaRepository<Member, Integer>{

}
