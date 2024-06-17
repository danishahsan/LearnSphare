package com.LearnSphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LearnSphere.Entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

	boolean existsByEmail(String email);
	boolean existsByPassword(String password);
	
	Users getByEmail(String email);
}