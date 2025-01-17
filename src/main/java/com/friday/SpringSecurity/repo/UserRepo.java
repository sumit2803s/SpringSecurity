package com.friday.SpringSecurity.repo;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.friday.SpringSecurity.model.Users;
@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {
    Users findByUsername(String Username);
}
