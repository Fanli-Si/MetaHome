package com.csis3275.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByEmail(String email);
	List<User> findByFirstName(String firstName);
	List<User> findByLastName(String lastName);
	List<User> findByPhoneNum(Long phoneNum);
	List<User> findByAddress(String address);
}
