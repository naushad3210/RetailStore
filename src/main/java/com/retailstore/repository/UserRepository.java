package com.retailstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retailstore.domain.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Long>{
	
	UserDetails findByUserId(String userId);

}
