package com.csis3275.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csis3275.models.LoginFromat.LoginFormat;



public interface LoginformatRepository extends JpaRepository<LoginFormat, Long>{
	
	List<LoginFormat> findByUsername(String username);
	List<LoginFormat> findByPassword(String password);
	
	
}
