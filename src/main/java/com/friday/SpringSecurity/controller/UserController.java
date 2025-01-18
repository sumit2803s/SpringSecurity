package com.friday.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.friday.SpringSecurity.model.Users;
import com.friday.SpringSecurity.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService service;
    @PostMapping("register")
    public Users register(@RequestBody Users user)
    {
       return service.register(user);
    }
}
