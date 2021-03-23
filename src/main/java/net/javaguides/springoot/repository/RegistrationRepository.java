package net.javaguides.springoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springoot.model.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

	public Registration findByEmailId(String emailId);
	public Registration findbyEmailandPassword(String emailId, String password);
}
