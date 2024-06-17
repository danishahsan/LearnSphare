package com.LearnSphere.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.LearnSphere.Entity.Users;
import com.LearnSphere.Services.UserServices;

@Controller
public class Services {

	@Autowired
	UserServices uService;

	
	@Autowired
	EmailSenderController emailSenderController;

	//		Add  User
	@PostMapping("/addUser")
	public String addUser(@RequestParam("name")String name,@RequestParam("email")String email,
			@RequestParam("role") String role,@RequestParam("password")String password,RedirectAttributes redi)
	{
		if((uService.checkEmail(email))==false)
		{

			//OTP code should be written here
			emailSenderController.sendEmail(email);
			Users user=new Users();
			user.setEmail(email);
			user.setName(name);
			user.setPassword(password);
			user.setRole(role);
			uService.addUser(user);
			redi.addFlashAttribute("success", "User has been added successfully");
			return "redirect:/login";
		}
		else
		{
			redi.addFlashAttribute("error", "User already exits!!");
			return "redirect:/login";
		}

	}


	//					Login Verify
	@PostMapping("/loginverify")
	public String logInVerify(@RequestParam("email")String email, 

			@RequestParam("password")String password,RedirectAttributes red)
	{
		if(uService.checkEmail(email))
		{
			if(uService.checkPass(password))

			{
				if(uService.userRole(email).equals("Student"))
				{
					System.out.println("User has been logged in successfully");
					return "redirect:/studentHome";
				}

				else
				{
					return "redirect:/trainerHome";
				}
			}

			else {
				red.addFlashAttribute("error","Password is incorrect");
				return "redirect:/login"; 
			}
		}
		else
		{
			red.addFlashAttribute("error","Email does not exist");
			System.out.println("Email doesn't exist");
			return "redirect:/login";
		}

	}

}
