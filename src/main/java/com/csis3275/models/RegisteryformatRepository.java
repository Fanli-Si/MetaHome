package com.csis3275.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface RegisteryformatRepository extends JpaRepository<Registeryformat, Long>{
	
	List<Registeryformat> findByFirstName(String firstName);
	List<Registeryformat> findByLastName(String lastName);
	List<Registeryformat> findByAge(int age);
	List<Registeryformat> findByEmail(String email);
	List<Registeryformat> findByUserName(String userName);
	List<Registeryformat> findByUserPassword(String userPassword);

}