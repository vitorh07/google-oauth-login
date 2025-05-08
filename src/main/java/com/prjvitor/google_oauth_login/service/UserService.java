package com.prjvitor.google_oauth_login.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prjvitor.google_oauth_login.model.User;
import com.prjvitor.google_oauth_login.repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
