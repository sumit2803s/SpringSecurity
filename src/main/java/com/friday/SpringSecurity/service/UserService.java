package com.friday.SpringSecurity.service;

import java.beans.Encoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.friday.SpringSecurity.model.Users;
import com.friday.SpringSecurity.repo.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
