package com.prjvitor.google_oauth_login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjvitor.google_oauth_login.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
