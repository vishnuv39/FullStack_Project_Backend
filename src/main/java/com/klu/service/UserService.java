package com.klu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klu.model.User;
import com.klu.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User signup(User user) {
    	
    	if (userRepo.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already registered");
        }
    	
        return userRepo.save(user);
    }

    public User login(User user) {
        User dbUser = userRepo.findByEmail(user.getEmail());

        
        if (dbUser == null) {
            throw new RuntimeException("User not registered");
        }

       
        if (!dbUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

    
        return dbUser;
    }
}