package ute.hibook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.service.impl.MyUserDetailsService;

@RestController
public class TestLoginController {

	@Autowired
	MyUserDetailsService userSer;
	
	@GetMapping({"/test-login"})
	public String detailBill() {
		String username="my.daothi.1997@gmail.com";
		String pass="daomy123";
		UserDetails userDetails = userSer.loadUserByUsername(username);
		if(userDetails!=null) {
			return "login successfull!";
		}
		return "login failure";
	}
}
