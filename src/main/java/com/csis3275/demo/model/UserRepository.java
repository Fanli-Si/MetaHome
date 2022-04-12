package com.csis3275.demo.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserId(String userId);
	
	Boolean existsByUserId(String userId);
	
}
