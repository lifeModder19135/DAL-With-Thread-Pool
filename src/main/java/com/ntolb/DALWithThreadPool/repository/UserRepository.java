package com.ntolb.DALWithThreadPool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntolb.DALWithThreadPool.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
	
}
