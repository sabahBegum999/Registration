package net.javaguides.springoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import net.javaguides.springoot.model.Registration;
import net.javaguides.springoot.repository.RegistrationRepository;
import net.javaguides.springoot.service.RegistrationService;

@Component
@RestController
@RequestMapping("/api/v1/")
public class RegistrationController {
	
	
	public RegistrationController() {
		super();
	}

	@Autowired
	private RegistrationRepository regRepo;
	@Autowired 
	private RegistrationService service;
	
	@PostMapping("/registerUser")
	public Registration registerUser(@RequestBody Registration user ) throws Exception {
		String tempEmail = user.getEmail();
		if(tempEmail != null && "".equals(tempEmail)) {
		Registration userobj =	service.fetchUserByEmail(tempEmail);
		if(userobj != null) {
			throw new Exception("User with "+tempEmail+" already exists");
		}
		}
		Registration userObj = null;
		service.saveUser(user);
		return userObj;
	}
	
	@PostMapping("/login")
	public Registration loginUser(@RequestBody Registration user) throws Exception {
		String tempEmail = user.getEmail();
		String tempPass = user.getPassword();
		Registration userObj = null;
		if(tempEmail != null & tempPass != null) {
			userObj = service.fetchUserByEmailandPassword(tempEmail, tempPass);
		}
		if(userObj == null) {
			throw new Exception("Bad credentials");
		}
		return userObj;
	}
	@GetMapping("registration")
public List<Registration> getAllUsers() {
	return this.regRepo.findAll();
}
}


