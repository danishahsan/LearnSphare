package com.LearnSphere.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LearnSphere.Entity.Users;
import com.LearnSphere.repository.UserRepository;

@Service
public class UserServicesImplementation implements UserServices {
	@Autowired
	UserRepository repo;

	@Override
	public String addUser(Users d) {

		repo.save(d);
		return "Student added succesfully";
	}

	@Override
	public boolean checkEmail(String email) {
		return repo.existsByEmail(email);
	}

	@Override
	public boolean checkPass(String password) {
		return repo.existsByPassword(password);
	}

	@Override
	public boolean validate(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String userRole(String email) {
		Users u=repo.getByEmail(email);
		return u.getRole();
	}

}
