package com.friday.SpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.friday.SpringSecurity.model.UserPrincipal;
import com.friday.SpringSecurity.model.Users;
import com.friday.SpringSecurity.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String Username) throws UsernameNotFoundException {
        Users user=repo.findByUsername(Username);

        if(user==null)
        {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User Not Found");
        }
        return new UserPrincipal(user);
    }
}
