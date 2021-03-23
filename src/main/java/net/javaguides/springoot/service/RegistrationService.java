package net.javaguides.springoot.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import net.javaguides.springoot.model.Registration;
import net.javaguides.springoot.repository.RegistrationRepository;


@Service
public class RegistrationService {
	
	@Autowired 
	private RegistrationRepository repo;
	
	public Registration saveUser(Registration user) {
		
		return repo.save(user);
		
	}
	
	public Registration fetchUserByEmail(String emailId) {
		return repo.findByEmailId(emailId);
		
	}
	
	public Registration fetchUserByEmailandPassword(String emailId, String password) {
		return repo.findbyEmailandPassword(emailId, password);
		

}
