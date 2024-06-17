package com.LearnSphere.Services;

import java.util.List;


import com.LearnSphere.Entity.Users;

public interface UserServices{
	
	String addUser(Users user);
	
	boolean validate(String email);

	boolean checkPass(String password);

	boolean checkEmail(String email);
	
	String userRole(String email);


}
